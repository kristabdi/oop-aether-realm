public class HandleEvent {
    public static void onPilihKartuDrawClick(){
        //pilih kartu yang diklik, kembalikan dua sisanya secara acak
    }

    public static void onInHandClick(GameState g, int index){
        //pindah dari in hand ke board, simpan di buffer
        if(g.getPhase()==Phase.DRAW){
            g.setSelectedCardInHand(index); //BILANG JEP
        }
    }

    public static void onBoardClick(GameState g, int index){
        //menambahkan karakter ke board kosong atau spell ke karakter
        if(g.getPhase()==Phase.PLAN && g.haveSelected()){ // BILANG JEP
            g.removeCardFromHand(1,indekskartu); //BILANG JEP, gimana kalo indeks kartu gausah dijadiin parameter ? karena udah disimpen jadi atribut gamestate
            g.addCardToBoard(1,card); //BILANG JEP
        }else if(g.getPhase()==Phase.PLAN && g.spellInBuffer()){ //BILANG JEP
            g.cardOnBoardGotSpelled(1,index); //BILANG JEP
        }else if(g.getPhase()==Phase.ATTACK){
            g.selectAttacker(); //BILANG JEP
        }
    }

    public static void onOpponentClick(GameState g){
        if(g.getPhase()==Phase.ATTACK){
            g.attack()
        }
    }

    public static void onOpponentBoardClick(GameState g){
        if(g.getPhase()==Phase.ATTACK){
            g.attack()
        }
    }


}
