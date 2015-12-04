package br.com.mobicare.ga;

import br.com.mobicare.ga.adapter.GoogleAdapter;
import br.com.mobicare.ga.exception.HitException;
import br.com.mobicare.ga.request.HitRequest;
import br.com.mobicare.ga.request.HitRequestBuilder;
import br.com.mobicare.ga.request.HitType;
import br.com.mobicare.ga.service.AnalyticsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = McareGaServerSideApplication.class)
@WebAppConfiguration
public class AnalyticsServiceTests {

    @InjectMocks
    AnalyticsService analyticsService;

    @Mock
    GoogleAdapter googleAdapter;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sendSuccessDebugHit() {

        HitRequest hitRequest = new HitRequestBuilder().withVersion("1").withTrackingId("UA-70823467-1")
                .withClientId("123456").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        Mockito.when(googleAdapter.hit(hitRequest, false)).thenReturn("OK");
        try {
            analyticsService.hit(hitRequest);
        } catch (HitException e) {
            Assert.fail("Not expected error.");
        }
    }

    @Test
    public void notNullParamValidationSuccess() {
        HitRequest hitRequest = new HitRequestBuilder().withTrackingId("UA-70823467-1")
                .withClientId("123456").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        try {
            analyticsService.hit(hitRequest);
            Assert.fail("Expected error.");
        } catch (HitException e) {
            Assert.assertTrue(e.getMessage().contains("[v]"));
        }

        hitRequest = new HitRequestBuilder().withVersion("1")
                .withClientId("123456").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        try {
            analyticsService.hit(hitRequest);
            Assert.fail("Expected error.");
        } catch (HitException e) {
            Assert.assertTrue(e.getMessage().contains("[tid]"));
        }

        hitRequest = new HitRequestBuilder().withVersion("1").withTrackingId("UA-70823467-1")
                .withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        try {
            analyticsService.hit(hitRequest);
            Assert.fail("Expected error.");
        } catch (HitException e) {
            Assert.assertTrue(e.getMessage().contains("[cid]"));
        }

        hitRequest = new HitRequestBuilder().withVersion("1").withTrackingId("UA-70823467-1")
                .withClientId("123456")
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        try {
            analyticsService.hit(hitRequest);
            Assert.fail("Expected error.");
        } catch (HitException e) {
            Assert.assertTrue(e.getMessage().contains("[t]"));
        }

    }

}
