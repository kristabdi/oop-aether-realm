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
        // if(gameState.getPhase()==Phase.DRAW){
        //     gameState.setSelectedCardInHand(index); //BILANG JEP
        // }
        System.out.println("Klik kartu in hand terdeteksi");
        System.out.println("In hand ke :"+index);
    }

    public static void onBoardClick(int index){
        //menambahkan karakter ke board kosong atau spell ke karakter
        // if(gameState.getPhase()==Phase.PLAN && gameState.haveSelected()){ // BILANG JEP
        //     gameState.removeCardFromHand(1,indekskartu); //BILANG JEP, gimana kalo indeks kartu gausah dijadiin parameter ? karena udah disimpen jadi atribut gamestate
        //     gameState.addCardToBoard(1,card); //BILANG JEP
        // }else if(gameState.getPhase()==Phase.PLAN && gameState.spellInBuffer()){ //BILANG JEP
        //     gameState.cardOnBoardGotSpelled(1,index); //BILANG JEP
        // }else if(gameState.getPhase()==Phase.ATTACK){
        //     gameState.selectAttacker(); //BILANG JEP
        // }
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