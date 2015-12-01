package br.com.mobicare.ga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;

@SpringBootApplication
public class McareGaServerSideApplication implements CommandLineRunner {

    @Autowired
    GAService gaService;

    public static void main(String[] args) {
        SpringApplication.run(McareGaServerSideApplication.class, args);
    }

    @Override public void run(String... strings) throws Exception {
        gaService.hit();
    }
}


@Service class GAService {

    RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
    }

    public void hit() {
        String url = "http://www.google-analytics.com/collect";

        HitRequest hitRequest = new HitRequestBuilder().withVersion("1").withPropertyId("UA-70823467-1")
                .withClientId("brunofpimenta@gmail.com").withHitType(HitType.PAGEVIEW)
                .withDocumentPath("outro-test-novo").withDocumentTitle("Página de Teste")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        HttpEntity<HitRequest> httpEntity = new HttpEntity<>(hitRequest);

        URI uri =
                UriComponentsBuilder.fromHttpUrl(url)
                        .buildAndExpand().encode().toUri();

        ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);

        System.out.println(exchange);
    }

}
