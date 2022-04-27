package com.aetherwars.model;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameWindowDraw {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToGameWindow(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1366, 768);
        stage.setScene(scene);
        stage.show();
    }
    
    // FUNGSI UNTUK GAME WINDOW DRAW
    @FXML
    void onDrawSelectFirst(MouseEvent event){
    
        try{
            switchToGameWindow(event);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void onDrawSelectSecond(MouseEvent event){
        try{
            switchToGameWindow(event);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void onDrawSelectThird(MouseEvent event){
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
    }
}
