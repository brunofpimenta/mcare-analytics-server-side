package br.com.mobicare.ga;

public enum HitType {

    PAGEVIEW("pageview"),
    SCREENVIEW("screenview"),
    EVENT("event"),
    TRANSACTION("transaction"),
    ITEM("item"),
    SOCIAL("social"),
    EXCEPTION("exception"),
    TIMING("timing");

    private String type;

    HitType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
