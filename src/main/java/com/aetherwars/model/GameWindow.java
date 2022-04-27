//ini controller dari gameWindow fxml
package com.aetherwars.model;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import com.aetherwars.model.GameState.Phase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameWindow {
    // Buat atribut yang sesuai tipe tag dan id pada fxml, terus buat method protectedvoid, terus masukin
    // nama fungsi ke dalam fxml dengan nama yang harus sama, misal <Button onAction="#onButtonClick">
    // Buat ganti scene
    
    private Scene scene;
    private Parent root;
    private Stage stage;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button buttonNextFase;
    @FXML
    private Button addExpButton;
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
    @FXML
    private Button openDrawWindow;
    @FXML
    private AnchorPane ap;


    public static final String PATH_TO_IMAGE= "src/main/resources/com/aetherwars/card/image/";
    // METHOD GANTI SCENE
    
    public void switchToGameWindowDraw(MouseEvent event) throws IOException {
        System.out.println("event pas mo ganti game window");
        System.out.println(event);
        root = FXMLLoader.load(getClass().getResource("GameWindowDraw.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1366, 768);
        stage.setScene(scene);
        stage.show();
    }
    
        
    protected void setWindowBasedOnGameState(){
        System.out.println("SEKARANG TURN ORANG KE " + String.valueOf(HandleEvent.gameState.getTurn()));
        /* SET BOARD */
        // player 1
        System.out.println("SIZE DARI BOARD PLAYER 1 SAAT INI ADALAH" + String.valueOf(HandleEvent.gameState.getPlayer(1).getPlayerDeckSize()));
        // char A
        if(HandleEvent.gameState.getPlayerCardOnBoard(1,0) != null){
            player1_CharA.setText(HandleEvent.gameState.getPlayerCardOnBoard(1,0).getName());
        }
        else{
            player1_CharA.setText("A");
        }
        // char B
        if(HandleEvent.gameState.getPlayerCardOnBoard(1, 1) != null){
            player1_CharB.setText(HandleEvent.gameState.getPlayerCardOnBoard(1, 1).getName());
        }
        else{
            player1_CharB.setText("B");
        }
        // char C
        if(HandleEvent.gameState.getPlayerCardOnBoard(1, 2) != null){
            player1_CharC.setText(HandleEvent.gameState.getPlayerCardOnBoard(1, 2).getName());
        }
        else{
            player1_CharC.setText("C");
        }
        // char D
        if(HandleEvent.gameState.getPlayerCardOnBoard(1, 3) != null){
            player1_CharD.setText(HandleEvent.gameState.getPlayerCardOnBoard(1, 3).getName());
        }
        else{
            player1_CharD.setText("D");
        }        
        // char E
        if(HandleEvent.gameState.getPlayerCardOnBoard(1, 4) != null){
            player1_CharE.setText(HandleEvent.gameState.getPlayerCardOnBoard(1, 4).getName());
        }
        else{
            player1_CharE.setText("E");
        }

        // player 2
        // char A
        if(HandleEvent.gameState.getPlayerCardOnBoard(2, 0) != null){
            player2_CharA.setText(HandleEvent.gameState.getPlayerCardOnBoard(2, 0).getName());
        }
        else{
            player2_CharA.setText("A");
        }
        // char B
        if(HandleEvent.gameState.getPlayerCardOnBoard(2, 1) != null){
            player2_CharB.setText(HandleEvent.gameState.getPlayerCardOnBoard(2, 1).getName());
        }
        else{
            player2_CharB.setText("B");
        }
        // char C
        if(HandleEvent.gameState.getPlayerCardOnBoard(2, 2) != null){
            player2_CharC.setText(HandleEvent.gameState.getPlayerCardOnBoard(2, 2).getName());
        }
        else{
            player2_CharC.setText("C");
        }
        // char D
        if(HandleEvent.gameState.getPlayerCardOnBoard(2, 3) != null){
            player2_CharD.setText(HandleEvent.gameState.getPlayerCardOnBoard(2, 3).getName());
        }
        else{
            player2_CharD.setText("D");
        }        
        // char E
        if(HandleEvent.gameState.getPlayerCardOnBoard(2, 4) != null){
            player2_CharE.setText(HandleEvent.gameState.getPlayerCardOnBoard(2, 4).getName());
        }
        else{
            player2_CharE.setText("E");
        }

        /* SET CARD IN HAND */
        // CLEAR CARD IN HAND START
        cardInHand1.setText("");
        cardInHand2.setText("");
        cardInHand3.setText("");
        cardInHand4.setText("");
        cardInHand5.setText("");
        // CLEAR CARD IN HAND DONE
        // untuk player 1 dan player 2, kalo ganti turn nti ganti sendiri
        List<Card> cardsBuffer = HandleEvent.gameState.getCardInHandGameState();
        //print ukuran card in hand
        Integer ukuran = cardsBuffer.size();
        System.out.println("ukuran = " + String.valueOf(ukuran));
        for(int i = 0; i < ukuran; i++){
            if(i == 0){
                //tambahin ke cardInHand1
                cardInHand1.setText(cardsBuffer.get(i).getName());
            } else if(i == 1){
                //tambahin ke cardInHand2
                cardInHand2.setText(cardsBuffer.get(i).getName());
            } else if(i == 2){
                //tambahin ke cardInHand3
                cardInHand3.setText(cardsBuffer.get(i).getName());
            } else if(i == 3){
                //tambahin ke cardInHand4
                cardInHand4.setText(cardsBuffer.get(i).getName());
            } else if(i == 4){
                //tambahin ke cardInHand5
                cardInHand5.setText(cardsBuffer.get(i).getName());
            }
        }
        /* SET PLAYER */ 
        // player 1
        player1Name.setText(HandleEvent.gameState.getPlayer(1).getName());
        File imagep1 = new File(PATH_TO_IMAGE + "player/Steve.png");
        System.out.println(imagep1.getAbsolutePath());
        playerA_image.setImage(new Image(imagep1.toURI().toString()));
        System.out.println("darah player 1");
        player1HealthBar.setProgress((double)HandleEvent.gameState.getPlayer(1).getHealth()/80);
        System.out.println(HandleEvent.gameState.getPlayer(1).getHealth());
        // player 2
        player2Name.setText(HandleEvent.gameState.getPlayer(2).getName());
        File imagep2 = new File(PATH_TO_IMAGE + "player/Alex.png");
        playerB_image.setImage(new Image(imagep2.toURI().toString()));
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
    protected void onDrawOpenWindow(MouseEvent event){
        if(HandleEvent.gameState.getPhase() == Phase.DRAW){
            try{
                this.switchToGameWindowDraw(event);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void addExpClick(MouseEvent event) {

    }
    
    @FXML
    void OnCardInHand1Hover(MouseEvent event) {
        HandleEvent.onHover(0, "inhand", 1);
    }

    @FXML
    void OnCardInHand2Hover(MouseEvent event) {
        HandleEvent.onHover(0, "inhand", 2);
    }

    @FXML
    void OnCardInHand3Hover(MouseEvent event) {
        HandleEvent.onHover(0, "inhand", 3);
    }

    @FXML
    void OnCardInHand4Hover(MouseEvent event) {
        HandleEvent.onHover(0, "inhand", 4);
    }

    @FXML
    void OnCardInHand5Hover(MouseEvent event) {
        HandleEvent.onHover(0, "inhand", 5);
    }

    @FXML
    void onCardInHand1Click(MouseEvent event) {
        // update gameState
        HandleEvent.onInHandClick(1);

        
        // update gameWindow
        setWindowBasedOnGameState();
    }

    @FXML
    void onCardInHand2Click(MouseEvent event) {
        // update gameState
        HandleEvent.onInHandClick(2);
         
         // update gameWindow
        setWindowBasedOnGameState();
    }

    @FXML
    void onCardInHand3Click(MouseEvent event) {
        // update gameState
        HandleEvent.onInHandClick(3);
         // update gameWindow
        setWindowBasedOnGameState();

    }

    @FXML
    void onCardInHand4Click(MouseEvent event) {
       // update gameState
        HandleEvent.onInHandClick(4);
         // update gameWindow
        setWindowBasedOnGameState();

    }

    @FXML
    void onCardInHand5Click(MouseEvent event) {
        // update gameState
        HandleEvent.onInHandClick(5);
         // update gameWindow
        setWindowBasedOnGameState();

    }

    @FXML
    void onNextPhaseClick(MouseEvent event) {
        System.out.println("DI KLIK NEXT PHASE");
        HandleEvent.onNextPhaseClick();

        this.setWindowBasedOnGameState();
    }

    @FXML
    void onPlayer1AvatarClick(MouseEvent event) {
        HandleEvent.onOpponentClick(1);
    }

    @FXML
    void onPlayer1_CharA(MouseEvent event) {
        HandleEvent.onBoardClick(1,1);
        // update gameWindow
        setWindowBasedOnGameState();
    }

    @FXML
    void onPlayer1_CharAHover(MouseEvent event) {
        HandleEvent.onHover(1, "board", 1);
    }

    @FXML
    void onPlayer1_CharB(MouseEvent event) {
        HandleEvent.onBoardClick(1,2);
        // update gameWindow
        setWindowBasedOnGameState();
    }

    @FXML
    void onPlayer1_CharBHover(MouseEvent event) {
        
        HandleEvent.onHover(1, "board", 2);
    }

    @FXML
    void onPlayer1_CharC(MouseEvent event) {
        HandleEvent.onBoardClick(1,3);
        // update gameWindow
        setWindowBasedOnGameState();
    }

    @FXML
    void onPlayer1_CharCHover(MouseEvent event) {
        HandleEvent.onHover(1, "board", 3);
    }

    @FXML
    void onPlayer1_CharD(MouseEvent event) {
        HandleEvent.onBoardClick(1,4);
        // update gameWindow
        setWindowBasedOnGameState();

    }

    @FXML
    void onPlayer1_CharDHover(MouseEvent event) {
        HandleEvent.onHover(1, "board", 4);
    }

    @FXML
    void onPlayer1_CharE(MouseEvent event) {
        HandleEvent.onBoardClick(1,5);
        // update gameWindow
        setWindowBasedOnGameState();

    }

    @FXML
    void onPlayer1_CharEHover(MouseEvent event) {
        HandleEvent.onHover(1, "board", 5);
    }

    @FXML
    void onPlayer2AvatarClick(MouseEvent event) {
        HandleEvent.onOpponentClick(2);
    }

    @FXML
    void onPlayer2_CharA(MouseEvent event) {
        HandleEvent.onBoardClick(2,1);
        // update gameWindow
        setWindowBasedOnGameState();

    }

    @FXML
    void onPlayer2_CharAHover(MouseEvent event) {
        HandleEvent.onHover(2, "board", 1);
    }

    @FXML
    void onPlayer2_CharB(MouseEvent event) {
        HandleEvent.onBoardClick(2,2);
        // update gameWindow
        setWindowBasedOnGameState();

    }

    @FXML
    void onPlayer2_CharBHover(MouseEvent event) {
        HandleEvent.onHover(2, "board", 2);
    }

    @FXML
    void onPlayer2_CharC(MouseEvent event) {
        HandleEvent.onBoardClick(2,3);
        // update gameWindow
        setWindowBasedOnGameState();
    }

    @FXML
    void onPlayer2_CharCHover(MouseEvent event) {
        HandleEvent.onHover(2, "board", 3);
    }

    @FXML
    void onPlayer2_CharD(MouseEvent event) {
        HandleEvent.onBoardClick(2,4);
        // update gameWindow
        setWindowBasedOnGameState();

    }

    @FXML
    void onPlayer2_CharDHover(MouseEvent event) {
        HandleEvent.onHover(2, "board", 4);
    }

    @FXML
    void onPlayer2_CharE(MouseEvent event) {
        HandleEvent.onBoardClick(2,5);
        // update gameWindow
        setWindowBasedOnGameState();
    }

    @FXML
    void onPlayer2_CharEHover(MouseEvent event) {
        HandleEvent.onHover(2, "board", 5);
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