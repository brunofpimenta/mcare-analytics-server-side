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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = McareAnalyticsServerSideApplication.class)
@WebAppConfiguration
public class AnalyticsServiceTests {

    @Autowired
    GoogleAdapter googleAdapter;

    @Autowired
    AnalyticsService analyticsService;

    MockRestServiceServer mockServer;

    @Before
    public void initMocks() {
        mockServer = MockRestServiceServer.createServer(googleAdapter.getRestTemplate());
    }

    @Test
    public void sendSuccessHit() {

        HitRequest hitRequest = new HitRequestBuilder().withVersion("1").withTrackingId("UA-70823467-1")
                .withClientId("123456").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        mockServer.expect(requestTo("https://www.google-analytics.com/collect")).andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess());

        try {
            analyticsService.hit(hitRequest);
        } catch (HitException e) {
            Assert.fail("Not expected error.");
        }

        mockServer.verify();
    }

    @Test
    public void sendSuccessDebugHit() {

        HitRequest hitRequest = new HitRequestBuilder().withVersion("1").withTrackingId("UA-70823467-1")
                .withClientId("123456").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        mockServer.expect(requestTo("https://www.google-analytics.com/debug/collect")).andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess());

        try {
            analyticsService.hitDebug(hitRequest);
        } catch (HitException e) {
            Assert.fail("Not expected error.");
        }

        mockServer.verify();
    }

    @Test
    public void hitNotNullParamValidationSuccess() {
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

    @Test
    public void hitDebugNotNullParamValidationSuccess() {
        HitRequest hitRequest = new HitRequestBuilder().withTrackingId("UA-70823467-1")
                .withClientId("123456").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        try {
            analyticsService.hitDebug(hitRequest);
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
            analyticsService.hitDebug(hitRequest);
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
            analyticsService.hitDebug(hitRequest);
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
            analyticsService.hitDebug(hitRequest);
            Assert.fail("Expected error.");
        } catch (HitException e) {
            Assert.assertTrue(e.getMessage().contains("[t]"));
        }

    }

    @Test
    public void testSuccessHitWithParametrizedUrl() {
        HitRequest hitRequest = new HitRequestBuilder("http://www.google.com").withTrackingId("UA-70823467-1").withVersion("1")
                .withClientId("123456").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        mockServer.expect(requestTo("http://www.google.com")).andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess());

        try {
            analyticsService.hit(hitRequest);
        } catch (HitException e) {
            Assert.fail("Not expected error.");
        }

        mockServer.verify();
    }

    @Test
    public void testSuccessHitDebugWithParametrizedUrl() {
        HitRequest hitRequest = new HitRequestBuilder("http://www.google.com").withTrackingId("UA-70823467-1").withVersion("1")
                .withClientId("123456").withHitType(HitType.SCREENVIEW)
                .withAppName("Oi Recarga").withAppVersion("2.1.0").withAppId("br.com.mobicare.oi.recarga")
                .withAppInstallerId("com.android.vending").withContentDescription("Home1")
                .withUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_0_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13A452").build();

        mockServer.expect(requestTo("http://www.google.com")).andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess());

        try {
            analyticsService.hitDebug(hitRequest);
        } catch (HitException e) {
            Assert.fail("Not expected error.");
        }

        mockServer.verify();
    }

}
