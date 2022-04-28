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
    private ImageView cardInHand1Image;
    @FXML
    private Button cardInHand2;
    @FXML
    private ImageView cardInHand2Image;
    @FXML
    private Button cardInHand3;
    @FXML
    private ImageView cardInHand3Image;
    @FXML
    private Button cardInHand4;
    @FXML
    private ImageView cardInHand4Image;
    @FXML
    private Button cardInHand5;
    @FXML
    private ImageView cardInHand5Image;
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
    private ImageView player1_CharD_image;
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


    public static final String PATH_TO_IMAGE= "src/main/resources/com/aetherwars/";
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
    
    protected void setBoardOnGameWindowBasedOnGameState(){
        /* SET BOARD */
        // player 1
        System.out.println("SIZE DARI BOARD PLAYER 1 SAAT INI ADALAH" + String.valueOf(HandleEvent.gameState.getPlayer(1).getBoardFilled()));
        for(int playerNumber =  1; playerNumber <= 2; playerNumber++){
            for(int i = 0 ; i < 5 ; i++){
                Button buttonToBeEdited = new Button();
                String defaultBoardText = "";
                ImageView imageViewToBeEdited = new ImageView();
                if(i == 0){
                    if(playerNumber == 1){
                        buttonToBeEdited = player1_CharA;
                        imageViewToBeEdited = player1_CharA_image;
                    }
                    else{
                        buttonToBeEdited = player2_CharA;
                        imageViewToBeEdited = player2_CharA_image;

                    }
                    defaultBoardText = "A";
                }
                if(i == 1){
                    if(playerNumber == 1){
                        buttonToBeEdited = player1_CharB;
                        imageViewToBeEdited = player1_CharB_image;
                    }
                    else{
                        buttonToBeEdited = player2_CharB;
                        imageViewToBeEdited = player2_CharB_image;

                    }
                    defaultBoardText = "B";
                }
                if(i == 2){
                    if(playerNumber == 1){
                        buttonToBeEdited = player1_CharC;
                        imageViewToBeEdited = player1_CharC_image;

                    }
                    else{
                        buttonToBeEdited = player2_CharC;
                        imageViewToBeEdited = player2_CharC_image;

                    }
                    defaultBoardText = "C";
                }
                if(i == 3){
                    if(playerNumber == 1){
                        buttonToBeEdited = player1_CharD;
                        imageViewToBeEdited = player1_CharD_image;

                    }
                    else{
                        buttonToBeEdited = player2_CharD;
                        imageViewToBeEdited = player2_CharD_image;

                    }
                    defaultBoardText = "D";
                }
                if(i == 4){
                    if(playerNumber == 1){
                        buttonToBeEdited = player1_CharE;
                        imageViewToBeEdited = player1_CharE_image;
                    }
                    else{
                        buttonToBeEdited = player2_CharE;
                        imageViewToBeEdited = player2_CharE_image;
                    }
                    defaultBoardText = "E";
                }
                if(HandleEvent.gameState.getPlayerCardOnBoard(playerNumber,i) != null){
                    buttonToBeEdited.setText(HandleEvent.gameState.getPlayerCardOnBoard(playerNumber,i).getName());
                    File imageBoard = new File(PATH_TO_IMAGE + HandleEvent.gameState.getPlayerCardOnBoard(playerNumber,i).getImagePath());
                    if(imageViewToBeEdited != null){
                        imageViewToBeEdited.setImage(new Image(imageBoard.toURI().toString()));
                    }
                }
                else{
                    buttonToBeEdited.setText(defaultBoardText);
                    if(imageViewToBeEdited != null){
                        imageViewToBeEdited.setImage(null);
                    }

                }   
            }
        }
    }
    
    protected void setCardInHandOnGameWindowBasedOnGameState(){
        /* SET CARD IN HAND */
        // CLEAR CARD IN HAND START
        cardInHand1.setText("");
        cardInHand1Image.setImage(null);
        cardInHand2.setText("");
        cardInHand2Image.setImage(null);
        cardInHand3.setText("");
        cardInHand3Image.setImage(null);
        cardInHand4.setText("");
        cardInHand4Image.setImage(null);
        cardInHand5.setText("");
        cardInHand5Image.setImage(null);
        // CLEAR CARD IN HAND DONE
        // untuk player 1 dan player 2, kalo ganti turn nti ganti sendiri
        List<Card> cardsBuffer = HandleEvent.gameState.getCardInHandGameState();
        //print ukuran card in hand
        Integer ukuran = cardsBuffer.size();
        System.out.println("ukuran = " + String.valueOf(ukuran));
        for(int i = 0; i < ukuran; i++){
            Button ButtonToBeEdited = new Button();
            ImageView imageViewToBeEdited = new ImageView();
            if(i == 0){
                ButtonToBeEdited = cardInHand1;
                imageViewToBeEdited = cardInHand1Image;
            } else if(i == 1){
                ButtonToBeEdited = cardInHand2;
                imageViewToBeEdited = cardInHand2Image;
            } else if(i == 2){
                ButtonToBeEdited = cardInHand3;
                imageViewToBeEdited = cardInHand3Image;
            } else if(i == 3){
                ButtonToBeEdited = cardInHand4;
                imageViewToBeEdited = cardInHand4Image;
            } else if(i == 4){
                ButtonToBeEdited = cardInHand5;
                imageViewToBeEdited = cardInHand5Image;
            }
            
            ButtonToBeEdited.setText(cardsBuffer.get(i).getName() + "\n" + "MANA: " + String.valueOf(cardsBuffer.get(i).getMana()));
            File imageCIH = new File(PATH_TO_IMAGE + cardsBuffer.get(i).getImagePath());
            imageViewToBeEdited.setImage(new Image(imageCIH.toURI().toString()));
        }
    }

    protected void setPlayerGameWindowBasedOnGameState(){
        /* SET PLAYER */ 
        // player 1
        player1Name.setText(HandleEvent.gameState.getPlayer(1).getName());
        File imagep1 = new File(PATH_TO_IMAGE + "card/image/player/Steve.png");
        System.out.println(imagep1.getAbsolutePath());
        playerA_image.setImage(new Image(imagep1.toURI().toString()));
        System.out.println("darah player 1");
        player1HealthBar.setProgress((double)HandleEvent.gameState.getPlayer(1).getHealth()/80);
        System.out.println(HandleEvent.gameState.getPlayer(1).getHealth());
        // player 2
        player2Name.setText(HandleEvent.gameState.getPlayer(2).getName());
        File imagep2 = new File(PATH_TO_IMAGE + "card/image/player/Alex.png");
        playerB_image.setImage(new Image(imagep2.toURI().toString()));
        System.out.println("darah player 2");
        player2HealthBar.setProgress((double)HandleEvent.gameState.getPlayer(2).getHealth()/80);
        System.out.println(HandleEvent.gameState.getPlayer(2).getHealth());
    }

    protected void setGeneralGameWindowBasedOnGameState(){
        /* SET KEBUTUHAN GAME UMUM */
        // SET LABEL DECK
       labelDeck.setText("hardcode");
       labelDeck.setText("Deck: " + String.valueOf(HandleEvent.gameState.getCurrentPlayer().getPlayerDeckSize())+"/40");
        // SET MANA LABEL
       labelMana.setText("Mana: " + String.valueOf(HandleEvent.gameState.getCurrentPlayer().getMana()));
       // SET PHASE COLOR
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
        // SET LABEL TURN
        labelTurn.setText(String.valueOf(HandleEvent.gameState.getTurn()));
        /// SET CARD DESCRIPTION ON HOVER
        if(HandleEvent.gameState.getCardOnDescriptionBuffer() != null){
            Card card = HandleEvent.gameState.getCardOnDescriptionBuffer();
            StringBuilder string = new StringBuilder();
            string.append(card.getName());
            string.append("\n");
            if (card instanceof CharacterCard) {
                string.append("Health: " + String.valueOf(((CharacterCard) card).getFinalHealth()) + "\n");
                string.append("Attack: " + String.valueOf(((CharacterCard) card).getFinalAttack())+ "\n");
                string.append("Level: " + String.valueOf(((CharacterCard) card).getLevel())+ "\n");
                string.append("Exp: " + String.valueOf(((CharacterCard) card).getExp()) + "/" + String.valueOf(((CharacterCard) card).getMaxExp())+ "\n");
                string.append("Type: " + String.valueOf(((CharacterCard) card).getType())+ "\n");
            } else if (card instanceof SpellCard){
                // isiin info spell
                if (((SpellCard) card).getSpellDuration() == 0){
                    string.append("Duration: Permanen\n");
                } else {
                    string.append("Duration: " + String.valueOf(((SpellCard) card).getSpellDuration())+ "\n");
                }
                // Kalo dia morph, level, swap, ato potion
                if (card instanceof MorphSpell){
                    string.append("MorphSpell\n");
                    string.append("Morph menjadi " + String.valueOf(((MorphSpell) card).getMorphTarget().getName())+ "\n");
                } else if (card instanceof LevelSpell) {
                    string.append("LevelSpell\n");
                    if (((LevelSpell) card).getLevelModifier() > 0){
                        string.append("Level +" + String.valueOf(((LevelSpell) card).getLevelModifier())+ "\n");
                    } else {
                        string.append("Level " + String.valueOf(((LevelSpell) card).getLevelModifier())+ "\n");
                    }
                } else if (card instanceof PotionSpell){
                    string.append("PotionSpell\n");
                    if (((PotionSpell) card).getAttackModifier() > 0){
                        string.append("ATK +" + String.valueOf(((PotionSpell) card).getAttackModifier())+ "\n");
                    } else {
                        string.append("ATK " + String.valueOf(((PotionSpell) card).getAttackModifier())+ "\n");
                    }
                    if (((PotionSpell) card).getHealthModifier() > 0){
                        string.append("HP +" + String.valueOf(((PotionSpell) card).getHealthModifier())+ "\n");
                    } else {
                        string.append("HP " + String.valueOf(((PotionSpell) card).getHealthModifier())+ "\n");
                    }
                } else if (card instanceof SwapSpell){
                    string.append("SwapSpell\n");
                }
            } 
            // Masukkan string ke description
            leftDescriptionWhenHover.setWrapText(true);
            rightDescriptionWhenHover.setWrapText(true);
            leftDescriptionWhenHover.setText(string.toString());
            rightDescriptionWhenHover.setText(card.getDescription());
            // Masukkan gambar ke description
            File imageForHover = new File(PATH_TO_IMAGE + card.getImagePath());
            imageWhenHover.setImage(new Image(imageForHover.toURI().toString()));
        }
    }

    protected void setWindowBasedOnGameState(){
        //SET BOARD
        this.setBoardOnGameWindowBasedOnGameState();
        //SET CARD IN HAND
        this.setCardInHandOnGameWindowBasedOnGameState();
        //SET PLAYER
        this.setPlayerGameWindowBasedOnGameState();
        //SET UMUM 
        this.setGeneralGameWindowBasedOnGameState();
    }

    

    // FUNGSI UNTUK GAME WINDOW UTAMA
    @FXML
    protected void onDrawOpenWindow(MouseEvent event){
        try{
            if(HandleEvent.gameState.getPhase() == Phase.DRAW && !HandleEvent.gameState.getHasDrawn()){
                HandleEvent.gameState.setHasDrawn(true);
                this.switchToGameWindowDraw(event);
            }
        }
        catch(IOException e){
                e.printStackTrace();
        }
    }

    @FXML
    void addExpClick(MouseEvent event) {
        try{
            // update game state
            // update game window
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }
    
    @FXML
    void OnCardInHand1Hover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(0, "inhand", 1);
           
            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void OnCardInHand2Hover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(0, "inhand", 2);
           
            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void OnCardInHand3Hover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(0, "inhand", 3);
           
            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void OnCardInHand4Hover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(0, "inhand", 4);
           
            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void OnCardInHand5Hover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(0, "inhand", 5);
           
            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onCardInHand1Click(MouseEvent event) {
        try{
            // update gameState
            HandleEvent.onInHandClick(1);
        
            // update gameWindow
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        } 
    }

    @FXML
    void onCardInHand2Click(MouseEvent event) {
        try{
            // update gameState
            HandleEvent.onInHandClick(2);
         
            // update gameWindow
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
        
    }

    @FXML
    void onCardInHand3Click(MouseEvent event) {
        try{
            // update gameState
            HandleEvent.onInHandClick(3);
            // update gameWindow
            this.setWindowBasedOnGameState();

        }catch(Exception e){
            System.out.println(" == Catched == ");
        }

    }

    @FXML
    void onCardInHand4Click(MouseEvent event) {
        try{
           // update gameState
            HandleEvent.onInHandClick(4);
            // update gameWindow
            this.setWindowBasedOnGameState();

        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
        

    }

    @FXML
    void onCardInHand5Click(MouseEvent event) {
        try{
            // update gameState
            HandleEvent.onInHandClick(5);
            // update gameWindow
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }

    }

    @FXML
    void onNextPhaseClick(MouseEvent event) {
        try{
            // gaboleh di next, kalo sekarang phasenya lagi draw, dan belum ngambil kartu
            if (!(HandleEvent.gameState.getPhase() == Phase.DRAW && !HandleEvent.gameState.getHasDrawn())){
                 //update game state
                System.out.println("DI KLIK NEXT PHASE");
                HandleEvent.onNextPhaseClick();
                //update game window
                this.setWindowBasedOnGameState();
            }
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
        
    }

    @FXML
    void onPlayer1AvatarClick(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onOpponentClick(1);
            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer1_CharA(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(1,1);
            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer1_CharAHover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(1, "board", 1);

            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer1_CharB(MouseEvent event) {
        HandleEvent.onBoardClick(1,2);
        // update gameWindow
        this.setWindowBasedOnGameState();
    }

    @FXML
    void onPlayer1_CharBHover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(1, "board", 2);

            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer1_CharC(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(1,3);
            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer1_CharCHover(MouseEvent event) {
         try{
            //update game state
            HandleEvent.onHover(1, "board", 3);


            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer1_CharD(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(1,4);

            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer1_CharDHover(MouseEvent event) {
         try{
            //update game state
            HandleEvent.onHover(1, "board", 4);

            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer1_CharE(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(1,5);

            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer1_CharEHover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(1, "board", 5);


            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer2AvatarClick(MouseEvent event) {
        try{
            // update game state
            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer2_CharA(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(2,1);

            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }

    }

    @FXML
    void onPlayer2_CharAHover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(2, "board", 1);

            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer2_CharB(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(2,2);

            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer2_CharBHover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(2, "board", 2);

            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer2_CharC(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(2,3);

            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer2_CharCHover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(2, "board", 3);


            //update game window
            this.setWindowBasedOnGameState();
        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer2_CharD(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(2,4);

            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }

    }

    @FXML
    void onPlayer2_CharDHover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(2, "board", 4);

            //update game window
            this.setWindowBasedOnGameState();
        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
    }

    @FXML
    void onPlayer2_CharE(MouseEvent event) {
        try{
            // update game state
            HandleEvent.onBoardClick(2,5);

            // update game window
            this.setWindowBasedOnGameState();
        }catch(Exception e){
            System.out.println(" == Catched == ");
        }
    }

    @FXML
    void onPlayer2_CharEHover(MouseEvent event) {
        try{
            //update game state
            HandleEvent.onHover(2, "board", 5);

            //update game window
            this.setWindowBasedOnGameState();

        }
        catch (Exception e){
            System.out.print("pokok e on hover error lah, natah apapun");
        }
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