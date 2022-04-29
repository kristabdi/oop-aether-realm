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
        if(gameState.getPhase() == GameState.Phase.PLAN && gameState.haveSelectedCardInHand() && gameState.getSelectedCardInHand() instanceof CharacterCard && gameState.getCurrentPlayerMana() >= gameState.getSelectedCardInHand().getMana() && !gameState.isThereACardOnBoardXOnCurrentPlayerBoard(boardNumber)){ 
            gameState.addCardToBoard(boardNumber);
            gameState.removeCardFromHand();

            // kalo phase sekarang plan, dan yang ada di dalam buffer adalah spell, dan ada character di boardnya, berarti dia mau nge apply spell ke card on board.
        }else if(gameState.getPhase() == GameState.Phase.PLAN && gameState.spellInBuffer() && gameState.isThereACardOnBoardXOnCurrentPlayerBoard(boardNumber)){
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
        //     gameState.attack(index);
        }
        else if(gameState.getPhase() == GameState.Phase.PLAN && gameState.spellInBuffer()){
            if(gameState.getSelectedCardInHand() instanceof MorphSpell){
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
        gameState.getThreeCardsFromDeckToBuffer();
        
    }
    public static void addExpButtonOnClick(){
        gameState.currentPlayerManaToExp();
    }

}