package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.aetherwars.model.Type;
import com.aetherwars.model.CharacterCard;
import com.aetherwars.model.Card;
import com.aetherwars.model.SpellCard;
import com.aetherwars.model.LevelSpell;
import com.aetherwars.model.PotionSpell;
import com.aetherwars.model.SwapSpell;
import com.aetherwars.model.MorphSpell;
import com.aetherwars.util.CSVReader;

public class AetherWars extends Application {
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SPELL_MORPH_CSV_FILE_PATH = "card/data/spell_morph.csv";
  private static final String SPELL_PTN_CSV_FILE_PATH = "card/data/spell_ptn.csv";
  private static final String SPELL_SWAP_CSV_FILE_PATH = "card/data/spell_swap.csv";


  public List<String> loadCards() throws IOException, URISyntaxException {
      List<String> idList = new ArrayList<String>();
      File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
      CSVReader Reader = new CSVReader(characterCSVFile, "\t");
      Reader.setSkipHeader(true);
      List<String[]> Rows = Reader.read();
      for (String[] row : Rows) {
        idList.add(row[1]);
        CharacterCard c = new CharacterCard(row[1], Type.valueOf(row[2]), row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
        System.out.println(c);
      }
      return idList;
  }

  public void loadSpellMorph(List<String> idList) throws IOException, URISyntaxException {
    File CSVFile = new File(getClass().getResource(SPELL_MORPH_CSV_FILE_PATH).toURI());
    CSVReader Reader = new CSVReader(CSVFile, "\t");
    Reader.setSkipHeader(true);
    List<String[]> Rows = Reader.read();
    for (String[] row : Rows) {
      // convert targetId into string name of character card
      int targetId = row[4];
      String targetName = idList.get(targetId); // add this target character name to morph spell constructor
      MorphSpell c = new MorphSpell(row[1], "Morph", row[2], row[3], targetName, row[5]);
      System.out.println(c);
    }
  }

  public void loadSpellPtn() throws IOException, URISyntaxException {
    File CSVFile = new File(getClass().getResource(SPELL_PTN_CSV_FILE_PATH).toURI());
    CSVReader Reader = new CSVReader(CSVFile, "\t");
    Reader.setSkipHeader(true);
    List<String[]> Rows = Reader.read();
    for (String[] row : Rows) {
      PotionSpell c = new PotionSpell(row[1], "Potion", row[2], row[6], row[7], 0, row[3], row[4], row[5]); 
      System.out.println(c);
    }
  }

  public void loadSpellSwap() throws IOException, URISyntaxException {
    File CSVFile = new File(getClass().getResource(SPELL_SWAP_CSV_FILE_PATH).toURI());
    CSVReader Reader = new CSVReader(CSVFile, "\t");
    Reader.setSkipHeader(true);
    List<String[]> Rows = Reader.read();
    for (String[] row : Rows) {
      SwapSpell c = new CharacterCard(row[1], Type.valueOf(row[2]), row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
      // System.out.println(c);
    }
  }

  public void loadSpellLevel() throws IOException, URISyntaxException {
    LevelSpell lvlup = new LevelSpell("Level Up", "Level", "Level up your character", 1);
    LevelSpell lvldown = new LevelSPell("Level Down", "Level", "Level down your character", -1);
  }

  @Override
  public void start(Stage stage) {
    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);

    Group root = new Group();
    root.getChildren().add(text);

    Scene scene = new Scene(root, 1280, 720);

    stage.setTitle("Minecraft: Aether Wars");
    stage.setScene(scene);
    stage.show();

    try {
      this.loadCards();
      this.loadSpellMorph();
      this.loadSpellPtn();
      this.loadSpellSwap();
      text.setText("Minecraft: Aether Wars!");
    } catch (Exception e) {
      text.setText("Failed to load cards: " + e);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
