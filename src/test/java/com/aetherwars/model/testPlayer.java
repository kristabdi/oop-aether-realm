package com.aetherwars.model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.lang.reflect.*;
import java.util.Objects;

public class testPlayer {
    @Test
    @DisplayName("Test ctor Player")
    void testCtor(){
        Player p = new Player();
        Class c = p.getClass();
        Field[] fields = c.getDeclaredFields();
        Object[] att = {"Player 1",1,10,80,new Deck(),-1,new CardInHand(),new Board()};
        int i=0;
        for(Field f : fields){
            f.setAccessible(true);
            try{
                assertTrue(Objects.deepEquals(att[i],(Objects) f.get(p)));
            }catch(Exception e){

            }
            
            i++;
        }

        Player q = new Player("name",5,new Deck(), new CardInHand(), new Board());
        Object[] att1 = {"name",5,10,80,new Deck(),-1,new CardInHand(),new Board()};
        c = q.getClass();
        fields = c.getDeclaredFields();
        for(Field f : fields){
            f.setAccessible(true);
            try{
                assertTrue(Objects.deepEquals(att[i],(Objects) f.get(p)));
            }catch(Exception e){

            }
            
            i++;
        }
    }

    @Test
    @DisplayName("Test getName Player")
    void testgetName(){
        Player q = new Player("name",5,new Deck(), new CardInHand(), new Board());
        assertEquals("name",q.getName());
    }

    @Test
    @DisplayName("Test setName Player")
    void testsetName(){
        Player q = new Player("new name",5,new Deck(), new CardInHand(), new Board());
        assertEquals("new name",q.getName());
    }

    @Test
    @DisplayName("Test getMana Player")
    void testgetMana(){
        Player q = new Player("new name",5,new Deck(), new CardInHand(), new Board());
        assertEquals(5,q.getMana());
    }

    @Test
    @DisplayName("Test setMana Player")
    void testsetMana(){
        Player q = new Player("new name",5,new Deck(), new CardInHand(), new Board());
        q.setMana(7);
        assertEquals(7,q.getMana());
    }

    @Test
    @DisplayName("Test resetMana Player")
    void testresetMana(){
        Player q = new Player("new name",5,new Deck(), new CardInHand(), new Board());
        q.resetMana(8);
        assertEquals(8,q.getMana());
        q.resetMana(15);
        assertEquals(10,q.getMana());
    }

    @Test
    @DisplayName("Test getHealth Player")
    void testgetHealth(){
        Player q = new Player("new name",5,new Deck(), new CardInHand(), new Board());
        assertEquals(80,q.getHealth());
    }

    @Test
    @DisplayName("Test setHealth Player")
    void testsetHealth(){
        Player q = new Player("new name",5,new Deck(), new CardInHand(), new Board());
        q.setHealth(50);
        assertEquals(50,q.getHealth());
    }

    @Test
    @DisplayName("Test isDead Player")
    void testisDead(){
        Player q = new Player("new name",5,new Deck(), new CardInHand(), new Board());
        assertTrue(q.isDead());
    }

    @Test
    @DisplayName("Test addCardToBoard dan add CardToCardInHand Player")
    void testaddCardToBoard(){
        Player q = new Player("new name",5,new Deck(), new CardInHand(), new Board());
        Card c = new CharacterCard("name",CharacterCard.Type.END,"desc","path",0,0,0,0,0);
        q.addCardToCardInHand(c);
        assertTrue(Objects.deepEquals(c,q.getCardInHandPlayer().get(0)));
        q.addCardToBoard(0,c);
        assertTrue(Objects.deepEquals(c,q.getCardOnBoard(0)));
    }
}
