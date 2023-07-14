package com.atc.be.gateway.response;

import atc.be.montecarlosimulation.model.Deck;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeckResponse {
    private Deck deck;
    private String message;
}
