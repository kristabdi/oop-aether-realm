package com.aetherwars.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class testCard {
    @Test
    @DisplayName("Testin ctor Card")
    void testCtor() {
        Card card = new Card("name", "type", "description", "imagePath");
        assertEquals("name", card.getName());
        assertEquals("type", card.getType());
        assertEquals("description", card.getDescription());
        assertEquals("imagePath", card.getImagePath());
    }   
}
