//ini controller dari gameWindow fxml
package com.aetherwars.model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class GameWindow {
    // Buat atribut yang sesuai tipe tag dan id pada fxml, terus buat method protectedvoid, terus masukin
    // nama fungsi ke dalam fxml dengan nama yang harus sama, misal <Button onAction="#onButtonClick">
    // Buat ganti scene
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button buttonNextFase;
    @FXML
    private Button cardInHand1;
    @FXML
    private Button cardInHand2;
    @FXML
    private Button cardInHand3;
    @FXML
    private Button cardInHand4;
    @FXML
    private Button cardInHand5;
    @FXML
    private ImageView imageWhenHover;
    @FXML
    private Label labelDeck;
    @FXML
    private Label labelFaseAttack;
    @FXML
    private Label labelFaseDraw;
    @FXML
    private Label labelFaseEnd;
    @FXML
    private Label labelFasePlan;
    @FXML
    private Label labelMana;
    @FXML
    private Label labelTurn;
    @FXML
    private Label leftDescriptionWhenHover;
    @FXML
    private ProgressBar player1HealthBar;
    @FXML
    private Label player1Name;
    @FXML
    private Label player2Name;
    @FXML
    private Button player1_CharA;
    @FXML
    private ImageView player1_CharA_image;
    @FXML
    private Button player1_CharB;
    @FXML
    private ImageView player1_CharB_image;
    @FXML
    private Button player1_CharC;
    @FXML
    private ImageView player1_CharC_image;
    @FXML
    private Button player1_CharD;
    @FXML
    private Button player1_CharE;
    @FXML
    private ImageView player1_CharE_image;
    @FXML
    private ProgressBar player2HealthBar;
    @FXML
    private Button player2_CharA;
    @FXML
    private ImageView player2_CharA_image;
    @FXML
    private Button player2_CharB;
    @FXML
    private ImageView player2_CharB_image;
    @FXML
    private Button player2_CharC;
    @FXML
    private ImageView player2_CharC_image;
    @FXML
    private Button player2_CharD;
    @FXML
    private ImageView player2_CharD_image;
    @FXML
    private Button player2_CharE;
    @FXML
    private ImageView player2_CharE_image;
    @FXML
    private Button playerA;
    @FXML
    private ImageView playerA_image;
    @FXML
    private Button playerB;
    @FXML
    private ImageView playerB_image;
    @FXML
    private Label rightDescriptionWhenHover;
    @FXML
    private Button generatedCard1;
    @FXML
    private Button generatedCard2;
    @FXML
    private Button generatedCard3;


    // METHOD GANTI SCENE
    
    public void switchToGameWindowDraw(MouseEvent event) throws IOException {
        System.out.print("==== ganti game window mulai ====");
        root = FXMLLoader.load(getClass().getResource("GameWindowDraw.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1366, 768);
        stage.setScene(scene);
        stage.show();
        System.out.print("ganti game window selesai");
    }

        
    protected void setWindowBasedOnGameState(){
        /* SET BOARD */
        // player 1
        // char A
        // player1_CharA.setText(HandleEvent.gameState.getCardOnBoard(1).getName());
        // char B
        // char C
        // char D
        // char E

        // player 2

        /* SET CARD IN HAND */
        // player 1
        // player 2
        /* SET PLAYER */ 
        // player 1
        player1Name.setText(HandleEvent.gameState.getPlayer(1).getName());
        System.out.println("darah player 1");
        player1HealthBar.setProgress((double)HandleEvent.gameState.getPlayer(1).getHealth()/80);
        System.out.println(HandleEvent.gameState.getPlayer(1).getHealth());
        // player 2
        player2Name.setText(HandleEvent.gameState.getPlayer(2).getName()); 
        System.out.println("darah player 2");
        player2HealthBar.setProgress((double)HandleEvent.gameState.getPlayer(2).getHealth()/80);
        System.out.println(HandleEvent.gameState.getPlayer(2).getHealth());
        /* SET KEBUTUHAN GAME UMUM */
        // set label deck
       labelDeck.setText("hardcode");
       labelDeck.setText("Deck: " + String.valueOf(HandleEvent.gameState.getCurrentPlayer().getPlayerDeckSize())+"/40");
        // set label mana
       labelMana.setText("Mana: " + String.valueOf(HandleEvent.gameState.getCurrentPlayer().getMana()));
       // set phase color
        // switch case based on gamestate phase
        switch (HandleEvent.gameState.getPhase()) {
            case DRAW:
                labelFaseDraw.setStyle("-fx-background-color: #00ff00");
                labelFasePlan.setStyle("-fx-background-color: #ffffff");
                labelFaseAttack.setStyle("-fx-background-color: #ffffff");
                labelFaseEnd.setStyle("-fx-background-color: #ffffff");
                break;
            case PLAN:
                labelFaseDraw.setStyle("-fx-background-color: #ffffff");
                labelFasePlan.setStyle("-fx-background-color: #00ff00");
                labelFaseAttack.setStyle("-fx-background-color: #ffffff");
                labelFaseEnd.setStyle("-fx-background-color: #ffffff");
                break;
            case ATTACK:
                labelFaseDraw.setStyle("-fx-background-color: #ffffff");
                labelFasePlan.setStyle("-fx-background-color: #ffffff");
                labelFaseAttack.setStyle("-fx-background-color: #00ff00");
                labelFaseEnd.setStyle("-fx-background-color: #ffffff");
                break;
            case END:
                labelFaseDraw.setStyle("-fx-background-color: #ffffff");
                labelFasePlan.setStyle("-fx-background-color: #ffffff");
                labelFaseAttack.setStyle("-fx-background-color: #ffffff");
                labelFaseEnd.setStyle("-fx-background-color: #00ff00");
                break;
        }
        // label turn
        labelTurn.setText(String.valueOf(HandleEvent.gameState.getTurn()));
    }

    

    // FUNGSI UNTUK GAME WINDOW UTAMA
    @FXML
    void OnCardInHand1Hover(MouseEvent event) {

    }

    @FXML
    void OnCardInHand2Hover(MouseEvent event) {

    }

    @FXML
    void OnCardInHand3Hover(MouseEvent event) {

    }

    @FXML
    void OnCardInHand4Hover(MouseEvent event) {

    }

    @FXML
    void OnCardInHand5Hover(MouseEvent event) {

    }

    @FXML
    void onCardInHand1Click(MouseEvent event) {
        // update gameState
        HandleEvent.onInHandClick(1);

        
        // update gameWindow
        setWindowBasedOnGameState();
        try {
            switchToGameWindowDraw(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onCardInHand2Click(MouseEvent event) {
HandleEvent.gameState.getPlayer(1).setHealth(40);
        HandleEvent.onInHandClick(2);
    }

    @FXML
    void onCardInHand3Click(MouseEvent event) {
        HandleEvent.onInHandClick(3);

    }

    @FXML
    void onCardInHand4Click(MouseEvent event) {
        HandleEvent.onInHandClick(4);

    }

    @FXML
    void onCardInHand5Click(MouseEvent event) {
        HandleEvent.onInHandClick(5);

    }

    @FXML
    void onNextPhaseClick(MouseEvent event) {
        HandleEvent.onNextPhaseClick();
    }

    @FXML
    void onPlayer1AvatarClick(MouseEvent event) {
        HandleEvent.onOpponentClick(1);
    }

    @FXML
    void onPlayer1_CharA(MouseEvent event) {
        HandleEvent.onBoardClick(1,1);

    }

    @FXML
    void onPlayer1_CharAHover(MouseEvent event) {

    }

    @FXML
    void onPlayer1_CharB(MouseEvent event) {
        HandleEvent.onBoardClick(1,2);
    }

    @FXML
    void onPlayer1_CharBHover(MouseEvent event) {
        

    }

    @FXML
    void onPlayer1_CharC(MouseEvent event) {
        HandleEvent.onBoardClick(1,3);
    }

    @FXML
    void onPlayer1_CharCHover(MouseEvent event) {

    }

    @FXML
    void onPlayer1_CharD(MouseEvent event) {
        HandleEvent.onBoardClick(1,4);

    }

    @FXML
    void onPlayer1_CharDHover(MouseEvent event) {

    }

    @FXML
    void onPlayer1_CharE(MouseEvent event) {
        HandleEvent.onBoardClick(1,5);

    }

    @FXML
    void onPlayer1_CharEHover(MouseEvent event) {

    }

    @FXML
    void onPlayer2AvatarClick(MouseEvent event) {
        HandleEvent.onOpponentClick(2);
    }

    @FXML
    void onPlayer2_CharA(MouseEvent event) {
        HandleEvent.onBoardClick(2,1);

    }

    @FXML
    void onPlayer2_CharAHover(MouseEvent event) {

    }

    @FXML
    void onPlayer2_CharB(MouseEvent event) {
        HandleEvent.onBoardClick(2,2);

    }

    @FXML
    void onPlayer2_CharBHover(MouseEvent event) {

    }

    @FXML
    void onPlayer2_CharC(MouseEvent event) {
        HandleEvent.onBoardClick(2,3);
    }

    @FXML
    void onPlayer2_CharCHover(MouseEvent event) {

    }

    @FXML
    void onPlayer2_CharD(MouseEvent event) {
        HandleEvent.onBoardClick(2,4);

    }

    @FXML
    void onPlayer2_CharDHover(MouseEvent event) {

    }

    @FXML
    void onPlayer2_CharE(MouseEvent event) {
        HandleEvent.onBoardClick(2,5);
    }

    @FXML
    void onPlayer2_CharEHover(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonNextFase != null : "fx:id=\"buttonNextFase\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert cardInHand1 != null : "fx:id=\"cardInHand1\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert cardInHand2 != null : "fx:id=\"cardInHand2\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert cardInHand3 != null : "fx:id=\"cardInHand3\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert cardInHand4 != null : "fx:id=\"cardInHand4\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert cardInHand5 != null : "fx:id=\"cardInHand5\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert imageWhenHover != null : "fx:id=\"imageWhenHover\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert labelDeck != null : "fx:id=\"labelDeck\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert labelFaseAttack != null : "fx:id=\"labelFaseAttack\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert labelFaseDraw != null : "fx:id=\"labelFaseDraw\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert labelFaseEnd != null : "fx:id=\"labelFaseEnd\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert labelFasePlan != null : "fx:id=\"labelFasePlan\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert labelMana != null : "fx:id=\"labelMana\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert labelTurn != null : "fx:id=\"labelTurn\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert leftDescriptionWhenHover != null : "fx:id=\"leftDescriptionWhenHover\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1HealthBar != null : "fx:id=\"player1HealthBar\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1Name != null : "fx:id=\"player1Name\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharA != null : "fx:id=\"player1_CharA\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharA_image != null : "fx:id=\"player1_CharA_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharB != null : "fx:id=\"player1_CharB\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharB_image != null : "fx:id=\"player1_CharB_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharC != null : "fx:id=\"player1_CharC\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharC_image != null : "fx:id=\"player1_CharC_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharD != null : "fx:id=\"player1_CharD\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharE != null : "fx:id=\"player1_CharE\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player1_CharE_image != null : "fx:id=\"player1_CharE_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2HealthBar != null : "fx:id=\"player2HealthBar\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharA != null : "fx:id=\"player2_CharA\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharA_image != null : "fx:id=\"player2_CharA_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharB != null : "fx:id=\"player2_CharB\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharB_image != null : "fx:id=\"player2_CharB_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharC != null : "fx:id=\"player2_CharC\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharC_image != null : "fx:id=\"player2_CharC_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharD != null : "fx:id=\"player2_CharD\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharD_image != null : "fx:id=\"player2_CharD_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharE != null : "fx:id=\"player2_CharE\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert player2_CharE_image != null : "fx:id=\"player2_CharE_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert playerA != null : "fx:id=\"playerA\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert playerA_image != null : "fx:id=\"playerA_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert playerB != null : "fx:id=\"playerB\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert playerB_image != null : "fx:id=\"playerB_image\" was not injected: check your FXML file 'GameWindow.fxml'.";
        assert rightDescriptionWhenHover != null : "fx:id=\"rightDescriptionWhenHover\" was not injected: check your FXML file 'GameWindow.fxml'.";
        System.out.println("AMAN GAME WINDOW, INI AKHIR DARI INITIALIZE");
        this.setWindowBasedOnGameState();
    }
        
}