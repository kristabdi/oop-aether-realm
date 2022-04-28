package com.aetherwars.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;
import com.aetherwars.model.Card;
import com.aetherwars.model.CharacterCard;
import com.aetherwars.model.CharacterCard.Type;
import com.aetherwars.util.*;
import java.util.*;
import java.lang.reflect.*;
import java.io.File;

public class testDeck {
    @Test
    @DisplayName("Testing ctor Deck")
    void testCtor(){
        Deck d = new Deck();
        Class c = d.getClass();
        Field[] fields = c.getDeclaredFields();
        assertEquals(2, fields.length);
    }

    private static final String CHARACTER_CSV_FILE_PATH = "src/main/resources/com/aetherwars/card/data/character.csv";
    private static final String SPELL_MORPH_CSV_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_morph.csv";
    private static final String SPELL_PTN_CSV_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_ptn.csv";
    private static final String SPELL_SWAP_CSV_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_swap.csv";
    public static List<CharacterCard> loadCharacterCards() throws IOException, URISyntaxException {
        List<CharacterCard> characterCards = new ArrayList<CharacterCard>();
        File characterCSVFile = new File(CHARACTER_CSV_FILE_PATH);
        
        CSVReader Reader = new CSVReader(characterCSVFile, "\t");
        Reader.setSkipHeader(true);
        List<String[]> Rows = Reader.read();
        for (String[] row : Rows) {
            CharacterCard c = new CharacterCard(row[1], Type.valueOf(row[2]), row[3], row[4], Integer.valueOf(row[5]), Integer.valueOf(row[6]), Integer.valueOf(row[7]), Integer.valueOf(row[8]), Integer.valueOf(row[9]));
            characterCards.add(c);
        }
        return characterCards;
    }
    
    public static List<MorphSpell> loadSpellMorph(List<CharacterCard> characterCards) throws IOException, URISyntaxException {
        List<MorphSpell> morphSpells = new ArrayList<MorphSpell>();
        File CSVFile = new File(SPELL_MORPH_CSV_FILE_PATH);
        CSVReader Reader = new CSVReader(CSVFile, "\t");
        Reader.setSkipHeader(true);
        List<String[]> Rows = Reader.read();
        for (String[] row : Rows) {
            int targetId = Integer.valueOf(row[4]);
            CharacterCard target = characterCards.get(targetId - 1); // keknya di minus 1 ya? iya bener - 1
            MorphSpell c = new MorphSpell(row[1], "Morph", row[2], target, Integer.valueOf(row[5]), row[3]);
            morphSpells.add(c);
        }
        return morphSpells;
    }
    
    public static List<PotionSpell> loadSpellPtn() throws IOException, URISyntaxException {
        List<PotionSpell> potionSpells = new ArrayList<PotionSpell>();
        File CSVFile = new File(SPELL_PTN_CSV_FILE_PATH);
        CSVReader Reader = new CSVReader(CSVFile, "\t");
        Reader.setSkipHeader(true);
        List<String[]> Rows = Reader.read();
        for (String[] row : Rows) {
            PotionSpell c = new PotionSpell(row[1], "Potion", row[2], Integer.valueOf(row[6]), Integer.valueOf(row[7]), 0, row[3], Integer.valueOf(row[4]), Integer.valueOf(row[5])); 
            potionSpells.add(c);
        }
        return potionSpells;
    }
    
    public static List<SwapSpell> loadSpellSwap() throws IOException, URISyntaxException {
        List<SwapSpell> swapSpells = new ArrayList<SwapSpell>();
        File CSVFile = new File(SPELL_SWAP_CSV_FILE_PATH);
        CSVReader Reader = new CSVReader(CSVFile, "\t");
        Reader.setSkipHeader(true);
        List<String[]> Rows = Reader.read();
        for (String[] row : Rows) {
            SwapSpell c = new SwapSpell(row[1], "Swap", row[2], Integer.valueOf(row[5]), Integer.valueOf(row[4]), 0, row[3]);
            swapSpells.add(c);
        }
        return swapSpells;
    }
    
    public static List<LevelSpell> loadSpellLevel() throws IOException, URISyntaxException {
        List<LevelSpell> levelSpells = new ArrayList<LevelSpell>();
        LevelSpell lvlup = new LevelSpell("Level Up", "Level", "Level up your character",0, 1);
        LevelSpell lvldown = new LevelSpell("Level Down", "Level", "Level down your character",0, -1);
        levelSpells.add(lvlup);
        levelSpells.add(lvldown);
        return levelSpells;
    }

    @Test
    @DisplayName("Testing Method fillDeck")
    void testFillDeck() throws IOException, URISyntaxException{
        try{
            Deck d = new Deck();
            d.fillDeck(loadCharacterCards(), loadSpellMorph(loadCharacterCards()), loadSpellPtn(), loadSpellSwap(), loadSpellLevel());
            Class c = d.getClass();
            Field f = c.getDeclaredField("cardInDeck");
            f.setAccessible(true);
            Stack<Card> cardInDeck = (Stack<Card>) f.get(d);
            assertEquals(40, cardInDeck.size());
        }catch(Exception e){
            
        }
    }
    
    @Test
    @DisplayName("Testing Method putCardToDeck")
    void testPutCardToDeck(){
        try{
            Deck d = new Deck();
            Card card1 = new CharacterCard("name1", Type.END, "description1", "imagePath1", 0, 0, 0, 0, 0);
            Card card2 = new CharacterCard("name2", Type.END, "description2", "imagePath2", 0, 0, 0, 0, 0);
            Card card3 = new CharacterCard("name3", Type.END, "description3", "imagePath3", 0, 0, 0, 0, 0);
            d.putCardToDeck(card1);
            d.putCardToDeck(card2);
            d.putCardToDeck(card3);
            assertEquals(3, d.getDeckSize());
        }catch(Exception e){

        }
    }
    @Test
    @DisplayName("Testing Method showThreeCard")
    void testShowTreeCard(){
        Deck d = new Deck();
        try{
            d.fillDeck(loadCharacterCards(), loadSpellMorph(loadCharacterCards()), loadSpellPtn(), loadSpellSwap(), loadSpellLevel());
        }catch(Exception e){

        }
        List<Card> threeCard = d.showThreeCards(); 
        assertEquals(3, threeCard.size());
    }

}

