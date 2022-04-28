package com.aetherwars.model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.lang.reflect.*;
import java.util.Objects;

public class testBoard{
    @Test
    @DisplayName("Test ctor Board")
    void testCtor(){
        Board b = new Board();
        Class c = b.getClass();
        Field[] fields = c.getDeclaredFields();
        Object[] att = {new BoardSlot[5],0};
        int i=0;
        for(Field f : fields){
            f.setAccessible(true);
            try{
                assertTrue(Objects.deepEquals(att[i],(Objects) f.get(b)));
            }catch(Exception e){

            }
            
            i++;
        }
    }

    @Test
    @DisplayName("Test getCardBoardByIdx Board")
    void testgetCardBoardByIdx(){
        Board b = new Board();
        assertEquals(null,b.getCardBoardByIdx(0));
    }

    @Test
    @DisplayName("Test getFilled Board")
    void testgetFilled(){
        Board b = new Board();
        assertEquals(0,b.getFilled());
    }

    @Test
    @DisplayName("Test addCardById getCardBoardByIdx isSlotFilled Board")
    void testaddCardById(){
        Board b = new Board();
        CharacterCard cc = new CharacterCard("testCharName", CharacterCard.Type.END, "charDescription", "charImagePath",0,0,0,0,0);
        b.addCardById(1, cc);
        assertEquals(1,b.getFilled());
        assertEquals(cc,b.getCardBoardByIdx(1));
        assertTrue(b.isSlotFilled(1));
        assertFalse(b.isSlotFilled(2));
    } 

    @Test
    @DisplayName("Test setCardInIndexAttackedToTrue hasCardInIndexAttacked Board")
    void testsetCardInIndexAttackedToTrue(){
        Board b = new Board();
        CharacterCard cc = new CharacterCard("testCharName", CharacterCard.Type.END, "charDescription", "charImagePath",0,0,0,0,0);
        b.addCardById(1, cc);
        b.setCardInIndexAttackedToTrue(1);
        assertTrue(b.hasCardInIndexAttacked(1));
    }
}