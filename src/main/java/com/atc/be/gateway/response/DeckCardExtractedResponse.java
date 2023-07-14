package com.atc.be.gateway.response;

import atc.be.montecarlosimulation.model.Card;
import atc.be.montecarlosimulation.model.Deck;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeckCardExtractedResponse {
    private Deck deck;
    private Card card;
    private String message;
}
