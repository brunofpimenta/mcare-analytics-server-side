package br.com.mobicare.ga.adapter;

import br.com.mobicare.ga.request.HitRequest;
import br.com.mobicare.ga.response.GoogleResponseMessage;
import br.com.mobicare.ga.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.ArrayList;

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

        resolveUrl();
    }

    public GoogleResponseMessage hit(HitRequest hitRequest, boolean debug) {
        ArrayList<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.APPLICATION_JSON);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(mediaTypes);

        HttpEntity<HitRequest> httpEntity = new HttpEntity<HitRequest>(hitRequest, httpHeaders);

        String requestUrl = url;
        if (debug) {
            requestUrl = debugUrl;
        }

        URI uri =
                UriComponentsBuilder.fromHttpUrl(requestUrl)
                        .buildAndExpand().encode().toUri();
        ResponseEntity<GoogleResponseMessage> googleResponseMessageResponseEntity =
                restTemplate.exchange(uri, HttpMethod.POST, httpEntity, GoogleResponseMessage.class);

        return googleResponseMessageResponseEntity.getBody();

    }

    private void resolveUrl() {
        if (StringUtils.isEmpty(url)) {
            url = DEFAULT_URL;
        }

        if (StringUtils.isEmpty(url)) {
            debugUrl = DEFAULT_DEBUG_URL;
        }
    }

}
