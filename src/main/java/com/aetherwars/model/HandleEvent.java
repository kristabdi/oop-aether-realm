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
        // tambahkan ke card in hands
        gameState.addCardInHand(gameState.getBufferDrawnCards().remove(nomorKartuYangDipilih - 1));
        // tambah ke deck
        int ukuran = gameState.getBufferDrawnCards().size();
        for(int i = 0; i < ukuran; i++){            
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
            }catch(Exception e){
            }
            
        }
    }

    public static void onBoardClick(int player,int boardNumber){
       

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
            gameState.addCardToBoard(boardNumber);
            gameState.removeCardFromHand();

            // kalo phase sekarang plan, dan yang ada di dalam buffer adalah spell, dan ada character di boardnya, berarti dia mau nge apply spell ke card on board.
        }else if(gameState.getPhase() == GameState.Phase.PLAN && gameState.spellInBuffer() && gameState.isThereACardOnBoardXOnCurrentPlayerBoard(boardNumber) && gameState.getCurrentPlayerMana() >= gameState.getSelectedCardInHand().getMana()){
            gameState.cardOnBoardGotSpelled(boardNumber);

            gameState.setSelectedCardOnBoardNumber(boardNumber);
            gameState.setSelectedCardOnBoardBasedOnCurrentPlayer(boardNumber);

            gameState.removeCardFromHand();

        }else if(gameState.getPhase() == GameState.Phase.ATTACK){

            // Cek apakah kartu di board yang diklik udah menyerang
            gameState.selectAttacker(boardNumber);
        }
        else{
            gameState.setSelectedCardOnBoardNumber(boardNumber);
            gameState.setSelectedCardOnBoardBasedOnCurrentPlayer(boardNumber);
        }
    }
    
    public static void onOpponentClick(int player){        
        if(gameState.getPhase() == GameState.Phase.ATTACK && gameState.getTurn()!=player){
            gameState.attack();
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
                gameState.morphOpponentCardOnBoard(boardNumber);

                gameState.setSelectedCardOnBoardNumber(boardNumber);
                gameState.setSelectedCardOnBoardBasedOnCurrentPlayer(boardNumber);

                gameState.removeCardFromHand();
            } 
        }
    }

    public static void onHover(Integer player, String loc, Integer cardNumber ){
            if(player == 0){ // ini kasus khusus
                player = gameState.getTurn();
            }
            gameState.setCardOnDescriptionBuffer(player,loc,cardNumber);  
      
    }
    public static void onDraw(){
        //dijalankan ketika membuka window draw
        gameState.getThreeCardsFromDeckToBuffer();
        
    }
    public static void addExpButtonOnClick(){
        gameState.currentPlayerManaToExp();
    }

}