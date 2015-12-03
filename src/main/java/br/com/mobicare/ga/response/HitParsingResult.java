package br.com.mobicare.ga.response;

import java.util.List;

public class HitParsingResult {

    private boolean valid;
    private String hit;

    private List<ParserMessage> parserMessage;

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

    public List<ParserMessage> getParserMessage() {
        return parserMessage;
    }

    public void setParserMessage(List<ParserMessage> parserMessage) {
        this.parserMessage = parserMessage;
    }
}
