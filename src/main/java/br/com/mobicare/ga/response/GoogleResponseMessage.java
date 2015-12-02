package br.com.mobicare.ga.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GoogleResponseMessage {

    @JsonProperty("hitParsingResult")
    private List<HitParsingResult> hitParsingResults;

    public List<HitParsingResult> getHitParsingResults() {
        return hitParsingResults;
    }

    public void setHitParsingResults(List<HitParsingResult> hitParsingResults) {
        this.hitParsingResults = hitParsingResults;
    }

}


