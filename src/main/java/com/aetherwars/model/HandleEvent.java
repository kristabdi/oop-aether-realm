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

    public static void onInHandClick(int index){
        //pindah dari in hand ke board, simpan di buffer
        // if(gameState.getPhase() == GameState.Phase.DRAW){ //KI, SEBELUMNYA KAMU DRAW. KEKNYA YG BENER PLAN GK SIH?
        if(gameState.getPhase() == GameState.Phase.PLAN){
            try{
                gameState.setSelectedCardInHand(index); //BILANG JEP
                System.out.println("Lagi plan nih");
            }catch(Exception e){
                System.out.println("Inhand yang diklik ga valid");
            }
            
        }
        System.out.println("Klik kartu in hand terdeteksi");
        System.out.println("In hand ke :" + index);
    }

    public static void onBoardClick(int player,int index){
        System.out.println("Turn: "+ gameState.getTurn());
        if(player == gameState.getTurn()){
            HandleEvent.onPlayerBoardClick(index);
        }else{
            HandleEvent.onOpponentBoardClick(index);
        }
    }


    public static void onPlayerBoardClick(int index){
        //menambahkan karakter ke board kosong atau spell ke karakter
        System.out.println("fase saat ini");
        System.out.println(String.valueOf(gameState.getPhase()));
        System.out.println("isi dari have selected");
        System.out.println(String.valueOf(gameState.haveSelectedCardInHand()));

        if(gameState.getPhase() == GameState.Phase.PLAN && gameState.haveSelectedCardInHand()){ // BILANG JEP
            gameState.removeCardFromHand(); //BILANG JEP, gimana kalo indeks kartu gausah dijadiin parameter ? karena udah disimpen jadi atribut gamestate
            gameState.addCardToBoardAndCleanBuffer(index); //BILANG JEP
        }else if(gameState.getPhase() == GameState.Phase.PLAN && gameState.spellInBuffer()){ //BILANG JEP
            gameState.cardOnBoardGotSpelled(index); //BILANG JEP
        }else if(gameState.getPhase() == GameState.Phase.ATTACK){
            gameState.selectAttacker(index); //BILANG JEP
        }
        System.out.println("Klik board terdeteksi. Board ke : "+index);
    }

    public static void onOpponentClick(int player){
        if(gameState.getPhase()==GameState.Phase.ATTACK && gameState.getTurn()!=player){
            gameState.attack();
            System.out.println("Klik lawan terdeteksi");
        }
    }

    public static void onOpponentBoardClick(int index){
        // if(gameState.getPhase()==Phase.ATTACK){
        //     gameState.attack(index);
        // }
        System.out.println("Klik board lawan terdeteksi terdeteksi. Board ke :" + index);
    }

    public static void onHover(Integer player, String loc, Integer cardNumber ){
       System.out.print("==ADA YANG DI HOVER===");
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

}