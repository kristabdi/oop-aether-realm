package com.aetherwars.model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.lang.reflect.*;
import java.util.*;

public class testCardInHand {
    
    @Test
    @DisplayName("Test ctor getCardInHand CardInHand")
    void testCtor(){
        ArrayList<Card> cards = new ArrayList<Card>();
        CardInHand c = new CardInHand();
        assertTrue(Objects.deepEquals(cards, c.getCardInHand()));
    }

    @Test
    @DisplayName("Test putCardToHand isCardInHand removeCardFromHand CardInHand")
    void testputCardToHand(){
        CardInHand c = new CardInHand();
        Card card = new Card("name", "type", "description", "imagePath");
        c.putCardToHand(card);
        assertTrue(c.isCardinHand(card));

        c.removeCardFromHand(0);
        assertFalse(c.isCardinHand(card));
    }
    
}
