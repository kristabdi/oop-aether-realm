package com.aetherwars.model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.lang.reflect.*;
import java.util.Objects;

public class testBoardSlot {
    @Test
    @DisplayName("Testing ctor BoardSlot")
    void testCtorBoardSlot(){
        BoardSlot b = new BoardSlot();
        Class c = b.getClass();
        Field[] fields = c.getDeclaredFields();
        Object[] att = {null,false,false};
        int i=0;
        for(Field f : fields){
            f.setAccessible(true);
            try{
                assertTrue(Objects.deepEquals(att[i],(Objects) f.get(b)));
            }catch(Exception e){

            }
            
            i++;
        }
        CharacterCard cc = new CharacterCard("name",CharacterCard.Type.END,"desc","path",0,0,0,0,0);
        b=new BoardSlot(cc);
        c = b.getClass();
        fields = c.getDeclaredFields();
        Object[] att1 = {cc,false,false};
        i=0;
        for(Field f : fields){
            f.setAccessible(true);
            try{
                assertTrue(Objects.deepEquals(att1[i],(Objects) f.get(b)));
            }catch(Exception e){

            }
            
            i++;
        }
    }

    @Test
    @DisplayName("Testing getCard setCard BoardSlot")
    void testgetCardBoardSlot(){
        CharacterCard cc = new CharacterCard("name",CharacterCard.Type.END,"desc","path",0,0,0,0,0);
        BoardSlot b=new BoardSlot();
        b.setCard(cc);
        assertTrue(Objects.deepEquals(cc,b.getCard()));
    }

    @Test
    @DisplayName("Testing setAttack getAttack BoardSlot")
    void testsetAttackBoardSlot(){
        BoardSlot b=new BoardSlot();
        b.setAttack(true);
        assertTrue(b.hasAttack());
    
        b.setAttack(false);
        assertFalse(b.hasAttack());
    }

    @Test
    @DisplayName("Testing setFilling isFilled BoardSlot")
    void testsetFillingBoardSlot(){
        BoardSlot b=new BoardSlot();
        b.setFilling(true);
        assertTrue(b.isFilled());
    
        b.setFilling(false);
        assertFalse(b.isFilled());
    }
}
