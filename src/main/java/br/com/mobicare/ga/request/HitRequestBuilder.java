package br.com.mobicare.ga.request;

public class HitRequestBuilder {
    private final String url;

    HitRequest hitRequest = new HitRequest();

    public HitRequestBuilder(String url) {
        this.url = url;
    }

    public HitRequestBuilder() {
        this.url = null;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#v
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withVersion(String value) {
        hitRequest.setV(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#v
     *
     * @return Builder
     */
    public HitRequestBuilder withVersionOne() {
        hitRequest.setV("1");
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#tid
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withTrackingId(String value) {
        hitRequest.setTid(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#aip
     *
     * @return Builder
     */
    public HitRequestBuilder withIpAnonymization() {
        hitRequest.setAip("1");
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ds
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withDataSource(String value) {
        hitRequest.setDs(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#qt
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withQueueTime(String value) {
        hitRequest.setQt(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cid
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withClientId(String value) {
        hitRequest.setCid(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#uid
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withUserId(String value) {
        hitRequest.setUid(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#sc
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withSessionControl(String value) {
        hitRequest.setSc(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#uip
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withIp(String value) {
        hitRequest.setUip(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ua
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withUserAgent(String value) {
        hitRequest.setUa(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#geoid
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withGeo(String value) {
        hitRequest.setGeoid(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cn
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withCampaignName(String value) {
        hitRequest.setCn(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cs
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withCampaignSource(String value) {
        hitRequest.setCs(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cm
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withCampaignMedia(String value) {
        hitRequest.setCm(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ck
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withCampaignKey(String value) {
        hitRequest.setCk(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cc
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withCampaignContent(String value) {
        hitRequest.setCc(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ci
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withCampaignId(String value) {
        hitRequest.setCi(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#gclid
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withAdwordsId(String value) {
        hitRequest.setGclid(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dclid
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withGraphsId(String value) {
        hitRequest.setDclid(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#sr
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withScreenResolution(String value) {
        hitRequest.setSr(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#vp
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withVisibleSize(String value) {
        hitRequest.setVp(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#de
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withDocumentEncoding(String value) {
        hitRequest.setDe(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#sd
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withScreenColorDensity(String value) {
        hitRequest.setSd(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ul
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withUserLanguage(String value) {
        hitRequest.setUl(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#je
     *
     * @return Builder
     */
    public HitRequestBuilder withJavaEnabled() {
        hitRequest.setJe("1");
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#fl
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withFlashVersion(String value) {
        hitRequest.setFl(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#t
     *
     * @return Builder
     */
    public HitRequestBuilder withHitType(HitType hitType) {
        hitRequest.setT(hitType.getType());
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ni
     *
     * @return Builder
     */
    public HitRequestBuilder withNonInteractiveHit() {
        hitRequest.setNi("1");
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dp
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withDocumentPath(String value) {
        hitRequest.setDp(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dt
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withDocumentTitle(String value) {
        hitRequest.setDt(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cd
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withContentDescription(String value) {
        hitRequest.setCd(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#an
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withAppName(String value) {
        hitRequest.setAn(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#aid
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withAppId(String value) {
        hitRequest.setAid(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#av
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withAppVersion(String value) {
        hitRequest.setAv(value);
        return this;
    }

    /**
     * Reference: https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#aiid
     *
     * @param value valor da propriedade.
     * @return Builder
     */
    public HitRequestBuilder withAppInstallerId(String value) {
        hitRequest.setAiid(value);
        return this;
    }

    public HitRequest build() {
        this.hitRequest.setUrl(url);
        return this.hitRequest;
    }

}
