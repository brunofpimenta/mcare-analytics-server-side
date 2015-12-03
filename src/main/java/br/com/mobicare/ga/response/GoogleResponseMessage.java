package br.com.mobicare.ga.response;

import java.util.List;

public class GoogleResponseMessage {

    private List<HitParsingResult> hitParsingResult;

    private List<ParserMessage> parserMessage;

    public List<HitParsingResult> getHitParsingResult() {
        return hitParsingResult;
    }

    public void setHitParsingResult(List<HitParsingResult> hitParsingResult) {
        this.hitParsingResult = hitParsingResult;
    }

    public List<ParserMessage> getParserMessage() {
        return parserMessage;
    }

    public void setParserMessage(List<ParserMessage> parserMessage) {
        this.parserMessage = parserMessage;
    }
}


