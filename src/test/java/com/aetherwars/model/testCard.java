package com.aetherwars.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aetherwars.model.CharacterCard.Type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class testCard {

    @Test
    @DisplayName("Testing ctor Card")
    void testCtorClassCard() {
        Card card = new Card("name", "type", "description", "imagePath");
        assertEquals("name", card.getName());
        assertEquals("type", card.getType());
        assertEquals("description", card.getDescription());
        assertEquals("imagePath", card.getImagePath());
    } 
    
    @Test
    @DisplayName("Testing ctor SwapSpellCard")
    void testCtorClassSwapSpellCard() {
        SwapSpell swapSpell = new SwapSpell("name", "type", "description", 0,0,0,"imagePath");
        assertEquals("name", swapSpell.getName());
        assertEquals("type", swapSpell.getType());
        assertEquals(0, swapSpell.getMana());
        assertEquals(0, swapSpell.getSpellDuration());
        assertEquals(0, swapSpell.getEXP());
        assertEquals("description", swapSpell.getDescription());
        assertEquals("imagePath", swapSpell.getImagePath());
    } 

    @Test
    @DisplayName("Testing ctor PotionSpell")
    void testCtorClassPotionSpellCard() {
        PotionSpell potionSpell = new PotionSpell("name", "type", "description", 0,0,0,"imagePath",0,0);
        assertEquals("name", potionSpell.getName());
        assertEquals("type", potionSpell.getType());
        assertEquals(0, potionSpell.getMana());
        assertEquals(0, potionSpell.getSpellDuration());
        assertEquals(0, potionSpell.getEXP());
        assertEquals("description", potionSpell.getDescription());
        assertEquals("imagePath", potionSpell.getImagePath());
        assertEquals(0, potionSpell.getHealthModifier());
        assertEquals(0, potionSpell.getAttackModifier());
    } 

    @Test
    @DisplayName("Testing ctor MorphSpell")
    void testCtorClassMorphSpellCard() {
        CharacterCard testCharacter = new CharacterCard("testCharName", Type.END, "charDescription", "charImagePath",0,0,0,0,0);
        MorphSpell morphSpell = new MorphSpell("morphName", "type", "description", testCharacter,0, "morphImagePath");
        assertEquals("morphName", morphSpell.getName());
        assertEquals("type", morphSpell.getType());
        assertEquals("description", morphSpell.getDescription());
        assertEquals(testCharacter, morphSpell.getMorphTarget());
        assertEquals(0, morphSpell.getMana());
        assertEquals("morphImagePath", morphSpell.getImagePath());
    }
    
    @Test
    @DisplayName("Testing ctor LevelSpell ")
    void testCtorClassLevelSpell() {
        CharacterCard testCharacter = new CharacterCard("testCharName", Type.END, "charDescription", "charImagePath",0,0,0,0,0);
        LevelSpell levelSpell = new LevelSpell("name", "type", "description", 0, 0);
        assertEquals("name", levelSpell.getName());
        assertEquals("type", levelSpell.getType());
        assertEquals("description", levelSpell.getDescription());
        assertEquals(0, levelSpell.getMana());
        assertEquals(0, levelSpell.getLevelModifier());
    }
    @Test
    @DisplayName("Testing ctor CharacterCard")
    void testCtorClassCharacterCard() {
        CharacterCard character = new CharacterCard("name", Type.END, "description", "imagePath",0,0,0,0,0);
        assertEquals("name", character.getName());
        assertEquals(Type.END, character.getAttribute());
        assertEquals("description", character.getDescription());
        assertEquals("imagePath", character.getImagePath());
        assertEquals(0, character.getAttack());
        assertEquals(0, character.getMana());
        assertEquals(0, character.getHealth());
        assertEquals(0, character.getAttackUp());
        assertEquals(0, character.getHealthUp());
    }
    
    @Test
    @DisplayName("Testing execute SwapSpell")
    void testExecuteSwapSpell(){
        CharacterCard testCharacter = new CharacterCard("name", Type.END, "description", "imagePath", 1, 10, 0, 0, 0);
        SwapSpell swapSpell = new SwapSpell("name", "type", "description", 0,0,0,"imagePath");
        swapSpell.execute(testCharacter);
        assertEquals(10, testCharacter.getAttack());
        assertEquals(1, testCharacter.getHealth());
    }
    
    @Test
    @DisplayName("Testing execute MorphSpell")
    void testExecuteMorphSpell(){
        CharacterCard morphCharacter = new CharacterCard("nameMorph", Type.END, "descriptionMorph", "imagePathMorph", 1, 1, 1, 1, 1);
        MorphSpell morphSpell = new MorphSpell("morphSpellName", "type", "description", morphCharacter, 0, "imagePath");
        CharacterCard characterExample = new CharacterCard("newCharacter", Type.NETHER, "description", "imagePath", 0, 0, 0, 0, 0);
        morphSpell.execute(characterExample);
        assertEquals("nameMorph", characterExample.getName());
        assertEquals(Type.END, characterExample.getAttribute());
        assertEquals("descriptionMorph", characterExample.getDescription());
        assertEquals("imagePathMorph", characterExample.getImagePath());
        assertEquals(1, characterExample.getAttack());
        assertEquals(1, characterExample.getHealth());
        assertEquals(1, characterExample.getMana());
        assertEquals(1, characterExample.getAttackUp());
        assertEquals(1, characterExample.getHealthUp());
    }
    
    @Test
    @DisplayName("Testing execute PotionSpell")
    void testExecutePotionSpell(){
        CharacterCard s  = new CharacterCard("name", Type.END, "description", "imagePath", 1, 1, 1, 1, 1);
        PotionSpell potionBuffAttack = new PotionSpell("ptnName", "type", "description", 0, 0, 0, "imagepath", 9, 0);
        PotionSpell potionBuffHealth = new PotionSpell("ptnName", "type", "description", 0, 0, 0, "imagepath", 0, 9);
        potionBuffAttack.execute(s);
        s.setAttackBuff();
        potionBuffHealth.execute(s);
        s.setHealthBuff();
        assertEquals(10,s.getFinalAttack());
        assertEquals(10,s.getFinalHealth());
    }
    
    @Test
    @DisplayName("Testing execute LevelSpell")
    void testExecuteLevelSpell(){
        CharacterCard characterExample = new CharacterCard("newCharacter", Type.NETHER, "description", "imagePath", 0, 0, 0, 0, 0);
        LevelSpell levelSpellUp = new LevelSpell("name", "type", "description", 0, 1);
        LevelSpell levelSpellDown = new LevelSpell("name", "type", "description", 0, -1);
        characterExample.setExp(9);
        assertEquals(1, characterExample.getLevel());
        assertEquals(9, characterExample.getExp());
        
        levelSpellUp.execute(characterExample);
        assertEquals(2, characterExample.getLevel());
        assertEquals(0, characterExample.getExp());
        
        characterExample.setLevel(10);
        assertEquals(10, characterExample.getLevel());
        assertEquals(0, characterExample.getExp());
        
        characterExample.setLevel(10);
        levelSpellUp.execute(characterExample);
        assertEquals(10, characterExample.getLevel());
        assertEquals(0, characterExample.getExp());
        
        characterExample.setLevel(2);
        levelSpellDown.execute(characterExample);
        assertEquals(1, characterExample.getLevel());
        assertEquals(0, characterExample.getExp());
        
        characterExample.setLevel(1);
        levelSpellDown.execute(characterExample);
        assertEquals(1, characterExample.getLevel());
        assertEquals(0, characterExample.getExp());
    }
    

}
