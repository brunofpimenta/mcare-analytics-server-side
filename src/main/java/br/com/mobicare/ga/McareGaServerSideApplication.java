package br.com.mobicare.ga;

import br.com.mobicare.ga.request.HitRequest;
import br.com.mobicare.ga.request.HitRequestBuilder;
import br.com.mobicare.ga.request.HitType;
import br.com.mobicare.ga.response.GoogleResponseMessage;
import br.com.mobicare.ga.service.GAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class McareGaServerSideApplication implements CommandLineRunner {

    @Autowired
    GAService gaService;

    public static void main(String[] args) {
        SpringApplication.run(McareGaServerSideApplication.class, args);
    }

    @Override public void run(String... strings) throws Exception {

        HitRequest hitRequest = new HitRequestBuilder().withVersion("1").withTrackingId("UA-70823467-1")
                .withClientId("brunofpimenta@gmail.com").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        GoogleResponseMessage googleResponseMessage = gaService.hit(hitRequest, false);

        System.out.println(googleResponseMessage);
    }
}



