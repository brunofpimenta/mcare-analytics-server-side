package br.com.mobicare.ga.adapter;

import br.com.mobicare.ga.request.HitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;

/**
 * Classe responsavel por fazer a conexao com o servico do GA e enviar o hit ou fazer sua validacao.
 * ver: https://developers.google.com/analytics/devguides/collection/protocol/v1/devguide
 */
@Component
public class GoogleAdapter {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Autowired
    ApplicationContext applicationContext;

    static final String DEFAULT_URL = "https://www.google-analytics.com/collect";
    static final String DEFAULT_DEBUG_URL = "https://www.google-analytics.com/debug/collect";

    RestTemplate restTemplate;

    String url;
    String debugUrl;

    @PostConstruct
    public void init() {

        if(applicationContext.getEnvironment().containsProperty("analytics.url")) {
            url = applicationContext.getEnvironment().getProperty("analytics.url");
        }

        if(applicationContext.getEnvironment().containsProperty("analytics.debug.url")) {
            debugUrl = applicationContext.getEnvironment().getProperty("analytics.debug.url");
        }

        if (StringUtils.isEmpty(url)) {
            url = DEFAULT_URL;
        }

        if (StringUtils.isEmpty(debugUrl)) {
            debugUrl = DEFAULT_DEBUG_URL;
        }
    }

    /**
     * @param hitRequest request com informacoes do GA.
     * @param debug      se true, o request vai ser enviado para um endpoint diferente que e responsavel somente por validar o request
     *                   (ver: https://developers.google.com/analytics/devguides/collection/protocol/v1/validating-hits); se true, as informacoes
     *                   de fato serao enviadas para o GA.
     * @return se [debug] for true, retorna uma string que representa a classe br.com.mobicare.ga.response.GoogleResponseMessage;
     * se [debug] for false, nada e retornado.
     */
    public String hit(HitRequest hitRequest, boolean debug) {
        HttpEntity<HitRequest> httpEntity = new HttpEntity<HitRequest>(hitRequest);

        String requestUrl = getRequestUrl(hitRequest.getUrl(), debug);

        LOG.info("Sending hit request (debug? [{}]) to URL [{}]...", debug, requestUrl);

        URI uri =
                UriComponentsBuilder.fromHttpUrl(requestUrl)
                        .buildAndExpand().encode().toUri();
        ResponseEntity<String> responseEntity = getRestTemplate().exchange(uri, HttpMethod.POST, httpEntity, String.class);

        String returnBody = responseEntity.getBody();
        LOG.info("Hit request sent and returned [{}]", returnBody);

        return returnBody;

    }

    private String getRequestUrl(String parametrizedUrl, boolean debug) {
        if (!StringUtils.isEmpty(parametrizedUrl)) {
            return parametrizedUrl;
        }

        String requestUrl = this.url;
        if (debug) {
            requestUrl = debugUrl;
        }

        return requestUrl;
    }

    public RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }
        return restTemplate;
    }
}
