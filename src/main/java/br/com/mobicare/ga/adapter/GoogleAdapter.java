package br.com.mobicare.ga.adapter;

import br.com.mobicare.ga.request.HitRequest;
import br.com.mobicare.ga.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PropertiesUtil propertiesUtil;

    RestTemplate restTemplate;

    static final String DEFAULT_URL = "https://www.google-analytics.com/collect";
    static final String DEFAULT_DEBUG_URL = "https://www.google-analytics.com/debug/collect";

    String url;
    String debugUrl;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();

        url = propertiesUtil.getProperty("analytics.url");
        debugUrl = propertiesUtil.getProperty("analytics.debug.url");

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

        String requestUrl = url;
        if (debug) {
            requestUrl = debugUrl;
        }

        URI uri =
                UriComponentsBuilder.fromHttpUrl(requestUrl)
                        .buildAndExpand().encode().toUri();
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);

        return responseEntity.getBody();

    }

}
