package com.aetherwars.model;
import javafx.stage.Stage;
import java.util.List;

public class HandleEvent{
    public static GameState gameState;
    public static void setGameState(GameState gs){
        gameState = gs;
    }

    public static void onNextPhaseClick(){
        gameState.nextPhase();
    }

    public static void onPilihKartuDrawClick(Integer nomorKartuYangDipilih){
        //KI, KEKNYA NERIMA KARTUE DEH (ATO INDEX LAH MINIMAL)
        //pilih kartu yang diklik, kembalikan dua sisanya secara acak
        System.out.println("Klik kartu setelah draw terdeteksi");
        // tambahkan ke card in hands
        gameState.addCardInHand(gameState.getBufferDrawnCards().remove(nomorKartuYangDipilih - 1));
        // tambah ke deck
        System.out.print("gameState.getBufferDrawnCards().size()");
        System.out.print(gameState.getBufferDrawnCards().size());
        int ukuran = gameState.getBufferDrawnCards().size();
        for(int i = 0; i < ukuran; i++){
        System.out.print("JALANAANANANAAN");
            
            gameState.addCardToDeck(gameState.getBufferDrawnCards().remove(0));
        }
        gameState.nextPhase();
    }

    public static void onInHandClick(int cardInHandNumber){
        //pindah dari in hand ke board, simpan di buffer
        // if(gameState.getPhase() == GameState.Phase.DRAW){ //KI, SEBELUMNYA KAMU DRAW. KEKNYA YG BENER PLAN GK SIH?
        if(gameState.getPhase() == GameState.Phase.PLAN){
            try{
                gameState.setSelectedCardInHand(cardInHandNumber); //BILANG JEP
                System.out.println("Lagi plan nih");
            }catch(Exception e){
                System.out.println("Inhand yang diklik ga valid");
            }
            
        }
        System.out.println("Klik kartu in hand terdeteksi");
        System.out.println("In hand ke :" + cardInHandNumber);
    }

    public static void onBoardClick(int player,int boardNumber){
       

        System.out.println("BOARD dari player " + String.valueOf(player) + "di lokasi " + String.valueOf(boardNumber) + "di klik!");
        System.out.println("Turn: " + gameState.getTurn());
        if(player == gameState.getTurn()){
            HandleEvent.onPlayerBoardClick(boardNumber);
        }else{
            HandleEvent.onOpponentBoardClick(boardNumber);
        }
    }


    public static void onPlayerBoardClick(int boardNumber){
        //menambahkan karakter ke board kosong atau spell ke karakter
        /*  
            kalo phase saat ini adalah plan,
            sudah select kartu dari tangan dan kartu tersebut merupakan karakter card,
            mana yang dimiliki player saat ini lebih dari cost mana yg dibutuhkan buat nge deploy ke board,
            dan board di lokasi boardNumber belum ada isinya
            then deploy
        */
        if(gameState.getPhase() == GameState.Phase.PLAN && gameState.haveSelectedCardInHand() && gameState.getSelectedCardInHand() instanceof CharacterCard && gameState.getCurrentPlayerMana() >= gameState.getSelectedCardInHand().getMana() && !gameState.isThereACardOnBoardXOnCurrentPlayerBoard(boardNumber)){ 
            System.out.println("ABIS INI BAKAL NAMBAHIN CARD KE BOARD!");
            gameState.addCardToBoard(boardNumber);
            gameState.removeCardFromHand();

            // kalo phase sekarang plan, dan yang ada di dalam buffer adalah spell, dan ada character di boardnya, berarti dia mau nge apply spell ke card on board.
        }else if(gameState.getPhase() == GameState.Phase.PLAN && gameState.spellInBuffer() && gameState.isThereACardOnBoardXOnCurrentPlayerBoard(boardNumber) && gameState.getCurrentPlayerMana() >= gameState.getSelectedCardInHand().getMana()){
            System.out.println("ABIS INI BAKAL NGE SPELL CHARACTER CARD DI BOARD!");
            gameState.cardOnBoardGotSpelled(boardNumber);

            gameState.setSelectedCardOnBoardNumber(boardNumber);
            gameState.setSelectedCardOnBoardBasedOnCurrentPlayer(boardNumber);

            gameState.removeCardFromHand();

        }else if(gameState.getPhase() == GameState.Phase.ATTACK){
            System.out.println("ABIS INI BAKAL NAMBAHIN CARD DI BOARD YANG BAKAL NGE ATTACK KE BUFFER!");

            // Cek apakah kartu di board yang diklik udah menyerang
            gameState.selectAttacker(boardNumber);
        }
        else{
            gameState.setSelectedCardOnBoardNumber(boardNumber);
            gameState.setSelectedCardOnBoardBasedOnCurrentPlayer(boardNumber);
        }
        System.out.println("Klik board terdeteksi. Board ke : "+ boardNumber);
    }
    
    public static void onOpponentClick(int player){
        // ini yang avatar di klik.
        System.out.println("ON OPPONENT BOARD CLICK!");
        System.out.println("selected card on board saat ini adalah");
        System.out.println(gameState.getSelectedCardOnBoard());
        System.out.println("dengan number");    
        System.out.println(gameState.getSelectedCardOnBoardNumber());
        
        if(gameState.getPhase() == GameState.Phase.ATTACK && gameState.getTurn()!=player){
            gameState.attack();
            System.out.println("Klik lawan terdeteksi");
        }
    }

    public static void onOpponentBoardClick(int boardNumber){

        if(gameState.getPhase()== GameState.Phase.ATTACK){
            gameState.attack(boardNumber);
        }
        // jika fase plan, dan yang di dalam selectedcard in hand itu spellcard
        // dan apakah yg di select di board lawan itu ada isinya
        // dan apakah mana itu cukup
        else if(gameState.getPhase() == GameState.Phase.PLAN && gameState.spellInBuffer() && gameState.isThereACardOnBoardXOnOpponentBoard(boardNumber) && gameState.getCurrentPlayerMana() >= gameState.getSelectedCardInHand().getMana()){
            if(gameState.getSelectedCardInHand() instanceof MorphSpell){
                System.out.println("ABIS INI BAKAL NGE MORPH CHARACTER CARD DI BOARD LAWAN!");
                gameState.morphOpponentCardOnBoard(boardNumber);

                gameState.setSelectedCardOnBoardNumber(boardNumber);
                gameState.setSelectedCardOnBoardBasedOnCurrentPlayer(boardNumber);

                gameState.removeCardFromHand();
            } 
        }
    }

    public static void onHover(Integer player, String loc, Integer cardNumber ){
    //    System.out.print("==ADA YANG DI HOVER===");
            if(player == 0){ // ini kasus khusus
                player = gameState.getTurn();
            }
            gameState.setCardOnDescriptionBuffer(player,loc,cardNumber);  
      
    }
    public static void onDraw(){
        //dijalankan ketika membuka window draw
        System.out.println("masuk handle event on draw");
        gameState.getThreeCardsFromDeckToBuffer();
        System.out.println("keluar handle event on draw");
        
    }
    public static void addExpButtonOnClick(){
        System.out.println("ADD EXP BUTTON CLICKED!");
        gameState.currentPlayerManaToExp();
    }

}