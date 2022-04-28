package com.aetherwars.model;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameWindowDraw {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button generatedCard1;
    @FXML
    private ImageView generatedCard1_image;
    @FXML
    private Button generatedCard2;
    @FXML
    private ImageView generatedCard2_image;
    @FXML
    private Button generatedCard3;
    @FXML
    private ImageView generatedCard3_image;

    public static final String PATH_TO_IMAGE= "src/main/resources/com/aetherwars/";
    

    public void switchToGameWindow(MouseEvent event) throws IOException {
        System.out.println("event pas mo ganti game window");
        System.out.println(event);
        root = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1366, 768);
        stage.setScene(scene);
        stage.show();
    }
    
    // FUNGSI UNTUK GAME WINDOW DRAW
    @FXML
    void onDrawSelectFirst(MouseEvent event){
        HandleEvent.onPilihKartuDrawClick(1);
        try{
            switchToGameWindow(event);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void onDrawSelectSecond(MouseEvent event){
        HandleEvent.onPilihKartuDrawClick(2);
        try{
            switchToGameWindow(event);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void onDrawSelectThird(MouseEvent event){
        HandleEvent.onPilihKartuDrawClick(3);
        try{
            switchToGameWindow(event);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void initialize(){
        // untuk set gambar dari 
        System.out.println("===== Berhasil Render Scene Draw =====");
        
        //update gameState
        HandleEvent.onDraw();

        //update gameWindowDraw. manual ae, soalnya gk banyak
        for (int i = 0 ; i < HandleEvent.gameState.getBufferDrawnCards().size();i++){
            Card card = HandleEvent.gameState.getBufferDrawnCards().get(i);
            Button buttonToBeEdited = new Button();
            ImageView imageViewToBeEdited = new ImageView();
            if(i == 0){
                buttonToBeEdited = generatedCard1;
                imageViewToBeEdited = generatedCard1_image;
            }
            if(i == 1){
                buttonToBeEdited = generatedCard2;
                imageViewToBeEdited = generatedCard2_image;
            }
            if(i == 2){
                buttonToBeEdited = generatedCard3;
                imageViewToBeEdited = generatedCard3_image;
            }
            buttonToBeEdited.setText(card.getName());
            File cardImage = new File(PATH_TO_IMAGE + card.getImagePath());
            imageViewToBeEdited.setImage(new Image(cardImage.toURI().toString()));
        }

        
    }
}
