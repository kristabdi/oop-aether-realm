package com.aetherwars.model; // ini false error

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.aetherwars.model.GameState;
import com.aetherwars.model.HandleEvent;


public class AetherWars extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AetherWars.class.getResource("GameWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // buat gameState
        GameState gameState = new GameState();

        // masukin gameState ke dalam handleEvent
        HandleEvent.setGameState(gameState);
        launch();
    }
}