package br.com.mobicare.ga.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HitParsingResult {

    private boolean valid;
    private String hit;

    @JsonProperty("parserMessage")
    private List<ParserMessage> parserMessages;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public List<ParserMessage> getParserMessages() {
        return parserMessages;
    }

    public void setParserMessages(List<ParserMessage> parserMessages) {
        this.parserMessages = parserMessages;
    }
}
