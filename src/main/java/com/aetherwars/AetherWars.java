package com.aetherwars.model; // ini false error

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.aetherwars.model.CharacterCard;
import com.aetherwars.model.GameState;
import com.aetherwars.model.HandleEvent;
import com.aetherwars.model.LevelSpell;
import com.aetherwars.model.MorphSpell;
import com.aetherwars.model.PotionSpell;
import com.aetherwars.model.SpellCard;
import com.aetherwars.model.SwapSpell;
import com.aetherwars.model.CharacterCard.Type;
import com.aetherwars.util.CSVReader;


public class AetherWars extends Application {
    private static final String CHARACTER_CSV_FILE_PATH = "src/main/resources/com/aetherwars/card/data/character.csv";
  private static final String SPELL_MORPH_CSV_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_morph.csv";
  private static final String SPELL_PTN_CSV_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_ptn.csv";
  private static final String SPELL_SWAP_CSV_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_swap.csv";


  public static List<CharacterCard> loadCharacterCards() throws IOException, URISyntaxException {
    //   List<String> idList = new ArrayList<String>();
    List<CharacterCard> characterCards = new ArrayList<CharacterCard>();
    File characterCSVFile = new File(CHARACTER_CSV_FILE_PATH);
    System.out.println("characterCSVFile: " + characterCSVFile.getAbsolutePath());

    CSVReader Reader = new CSVReader(characterCSVFile, "\t");
    Reader.setSkipHeader(true);
    List<String[]> Rows = Reader.read();
    for (String[] row : Rows) {
      // idList.add(row[1]);
      CharacterCard c = new CharacterCard(row[1], Type.valueOf(row[2]), row[3], row[4], Integer.valueOf(row[5]), Integer.valueOf(row[6]), Integer.valueOf(row[7]), Integer.valueOf(row[8]), Integer.valueOf(row[9]));
      System.out.println("data");
      System.out.println(c);
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
      // convert targetId into string name of character card
      int targetId = Integer.valueOf(row[4]);

      CharacterCard target = characterCards.get(targetId - 1); // keknya di minus 1 ya? iya bener - 1
      // MorphSpell(String name, String type, String description, CharacterCard target, int mana)
        
      MorphSpell c = new MorphSpell(row[1], "Morph", row[2], target, Integer.valueOf(row[5]));
      System.out.println(c);
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
      System.out.println(c);
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
      System.out.println(c);
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

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AetherWars.class.getResource("GameWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        stage.getIcons().add(new Image("https://w7.pngwing.com/pngs/426/500/png-transparent-minecraft-survivalcraft-mob-creeper-skeleton-creeper-s-video-game-grass-survival.png"));
        stage.setTitle("Aether Realm");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        File directory = new File("src/main/resources/card/data");
        System.out.println(directory.getAbsolutePath());
        //baca semua possible card
        try {
            List<CharacterCard> characterCards = loadCharacterCards();
            List<MorphSpell> morphSpells =  loadSpellMorph(characterCards);
            List<PotionSpell> potionSpells =  loadSpellPtn();
            List<SwapSpell> swapSpells = loadSpellSwap();
            List<LevelSpell> levelSpells = loadSpellLevel();
          } catch (Exception e) {
            e.printStackTrace();
            System.out.println("GAGAL LOAD CARD");

          }
        // buat gameState
        GameState gameState = new GameState();
        // masukin gameState ke dalam handleEvent
        HandleEvent.setGameState(gameState);
        //jalankan gameWindow
        launch();
    }
}