package com.aetherwars.model;

public class Board {
    private BoardSlot[] cardBoard;
    private int filled;

    public Board(){
        this.cardBoard = new BoardSlot[5];
        this.filled =0;
    }

    public CharacterCard getCardBoardByIdx(int idx){
        // ASUMSI INDEX NYA BENER. KALO GK BENER, RUSAK SUMPAH
        // Alternatif: Kalo di board kosong, buttonnya di disable untuk indeks itu, jadi ga bakal salah
        // if(this.fillingIndicator[idx]!=0){
        return this.cardBoard[idx].getCard();
        // }
    }
    public int getFilled(){
        return this.filled;
    }

    public void addCard(CharacterCard c){
        //cek dah penuh belum
        //kalo belum
        //cari index pertama yang kosong
        //isi indx pertama yang kosong dengan kartu tadi
        //ubah array keterisian index ke-index menjadi terisi(1)
        //tambah jumlah kterisian
        
            int i = 0;
            while(this.cardBoard[i].isFilled()&& i<4){
                i++;
            }
            //karna sudah cek kepenuhan
            //mentok i di idx 4 dan pasti dapet yang indexNone
            addCardById(i,c);
    }

    //asumsi input selalu benar
    //exception di atas
    public void addCardById(int id,CharacterCard c){
        this.cardBoard[id].setCard(c);
        this.filled++;
        this.cardBoard[id].setFilling(true);
    }

    public CharacterCard popCard(int index){
        //ngambil kartu dari index ke-index
        //ubah indikator index ke-index -> 0
        //kurangi filled -1
        //return kartu pada index ke-index
        this.cardBoard[index].setFilling(false);
        this.filled--;
        return this.cardBoard[index].getCard();
    }
//masi problem
    public void updateBoard(){
        int i;
        for(i=0;i<5;i++){
            if(this.cardBoard[i].isFilled()){
                if(this.cardBoard[i].getCard().getFinalHealth()>0){
                    this.cardBoard[i].getCard().updateSpellsEndDuration();
                    this.cardBoard[i].getCard().setAttackBuff();
                    this.cardBoard[i].getCard().setHealthBuff();
                    this.cardBoard[i].setAttack(false);
                }else{
                    this.cardBoard[i].setFilling(false);
                }
            }
        }
    }

    public boolean isCardBoardEmpty(int idx){
        return this.cardBoard[idx].isFilled();
    }
}
