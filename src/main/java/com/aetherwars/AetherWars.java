package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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


  public void loadCards() throws IOException, URISyntaxException {
      File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
      CSVReader Reader = new CSVReader(characterCSVFile, "\t");
      Reader.setSkipHeader(true);
      List<String[]> Rows = Reader.read();
      for (String[] row : Rows) {
        CharacterCard c = new CharacterCard(row[1], Type.valueOf(row[2]), row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
        System.out.println(c);
      }
  }

  public void loadSpellMorph() throws IOException, URISyntaxException {
      File CSVFile = new File(getClass().getResource(SPELL_MORPH_CSV_FILE_PATH).toURI());
      CSVReader Reader = new CSVReader(CSVFile, "\t");
      Reader.setSkipHeader(true);
      List<String[]> Rows = Reader.read();
      for (String[] row : Rows) {
        // CharacterCard c = new CharacterCard(row[1], Type.valueOf(row[2]), row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
        // System.out.println(c);
      }
  }

  public void loadSpellPtn() throws IOException, URISyntaxException {
      File CSVFile = new File(getClass().getResource(SPELL_PTN_CSV_FILE_PATH).toURI());
      CSVReader Reader = new CSVReader(CSVFile, "\t");
      Reader.setSkipHeader(true);
      List<String[]> Rows = Reader.read();
      for (String[] row : Rows) {
        // CharacterCard c = new CharacterCard(row[1], Type.valueOf(row[2]), row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
        // System.out.println(c);
      }
  }

  public void loadSpellSwap() throws IOException, URISyntaxException {
      File CSVFile = new File(getClass().getResource(SPELL_SWAP_CSV_FILE_PATH).toURI());
      CSVReader Reader = new CSVReader(CSVFile, "\t");
      Reader.setSkipHeader(true);
      List<String[]> Rows = Reader.read();
      for (String[] row : Rows) {
        // CharacterCard c = new CharacterCard(row[1], Type.valueOf(row[2]), row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
        // System.out.println(c);
      }
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
