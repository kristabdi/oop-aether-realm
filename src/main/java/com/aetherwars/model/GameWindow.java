package com.aetherwars.model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameWindow {
    // Buat atribut yang sesuai tipe tag dan id pada fxml, terus buat method protectedvoid, terus masukin
    // nama fungsi ke dalam fxml dengan nama yang harus sama, misal <Button onAction="#onButtonClick">
    @FXML
    private Button player1_CharD;

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    @FXML
    protected void onPlayer1CharDClick(){
        String teks = HandleEvent.onButtonClick();
        player1_CharD.setText(teks);
        // player1_CharD.setText("ini yang baru");
        }
        
}