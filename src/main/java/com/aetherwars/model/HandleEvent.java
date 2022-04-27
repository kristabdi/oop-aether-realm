package com.aetherwars.model;

public class HandleEvent{
    public static GameState gameState;
    public static void setGameState(GameState gs){
        gameState = gs;
    }

    public static String onButtonClick(){
        gameState.nextPhase();
        return(gameState.getPhase().name());
    }

    public static void onPilihKartuDrawClick(){
        //pilih kartu yang diklik, kembalikan dua sisanya secara acak
        System.out.println("Klik kartu setelah draw terdeteksi");
    }

    public static void onInHandClick(int index){
        //pindah dari in hand ke board, simpan di buffer
        if(gameState.getPhase()==GameState.Phase.DRAW){
            try{
                gameState.setSelectedCardInHand(index); //BILANG JEP
                System.out.println("Lagi draw nih");
            }catch(Exception e){
                System.out.println("Inhand yang diklik ga valid");
            }
            
        }
        System.out.println("Klik kartu in hand terdeteksi");
        System.out.println("In hand ke :"+index);
    }

    public static void onBoardClick(int player,int index){
        System.out.println("Turn: "+gameState.getTurn());
        if(player==gameState.getTurn()){
            HandleEvent.onPlayerBoardClick(index);
        }else{
            HandleEvent.onOpponentBoardClick(index);
        }
    }


    public static void onPlayerBoardClick(int index){
        //menambahkan karakter ke board kosong atau spell ke karakter
        if(gameState.getPhase()==GameState.Phase.PLAN && gameState.haveSelected()){ // BILANG JEP
            gameState.removeCardFromHand(1); //BILANG JEP, gimana kalo indeks kartu gausah dijadiin parameter ? karena udah disimpen jadi atribut gamestate
            gameState.addCardToBoard(index); //BILANG JEP
        }else if(gameState.getPhase()==GameState.Phase.PLAN && gameState.spellInBuffer()){ //BILANG JEP
            gameState.cardOnBoardGotSpelled(index); //BILANG JEP
        }else if(gameState.getPhase()==GameState.Phase.ATTACK){
            gameState.selectAttacker(index); //BILANG JEP
        }
        System.out.println("Klik board terdeteksi. Board ke : "+index);
    }

    public static void onOpponentClick(){
        // if(gameState.getPhase()==Phase.ATTACK){
        //     gameState.attack()
        // }
        System.out.println("Klik lawan terdeteksi");
    }

    public static void onOpponentBoardClick(int index){
        // if(gameState.getPhase()==Phase.ATTACK){
        //     gameState.attack()
        // }
        System.out.println("Klik board lawan terdeteksi terdeteksi. Board ke :" + index);
    }

}