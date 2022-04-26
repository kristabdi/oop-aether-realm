package com.aetherwars.model;

public class Board {
    private CharacterCard[] cardBoard;
    private int[] fillingIndicator;
    private int filled;

    public Board(){
        this.cardBoard = new CharacterCard[5];
        this.fillingIndicator = new int[]{0,0,0,0,0};
        this.filled =0;
    }

    public Board(CharacterCard[] cardBoard, int[]fillingIndicator, int filled){
        this.filled = filled;
        this.cardBoard = new CharacterCard[5];
        this.fillingIndicator = new int[5];
        int i =0;
        while(i<5){
            if(fillingIndicator[i]==1){
                this.cardBoard[i]=cardBoard[this.filled-filled];
            }
            this.fillingIndicator[i]=fillingIndicator[i];
            i++;
            filled--;
        }
    }

    public Card getCardBoardByIdx(int idx){
        // ASUMSI INDEX NYA BENER. KALO GK BENER, RUSAK SUMPAH
        // Alternatif: Kalo di board kosong, buttonnya di disable untuk indeks itu, jadi ga bakal salah
        // if(this.fillingIndicator[idx]!=0){
        return this.cardBoard[idx];
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
        if(this.filled < 5){
            int i = 0;
            while(this.fillingIndicator[i]!=0 && i<4){
                i++;
            }
            //karna sudah cek kepenuhan
            //mentok i di idx 4 dan pasti dapet yang indexNone
            this.cardBoard[i]=c;
            this.fillingIndicator[i]=1;
            this.filled++;
        }
    }

    //asumsi input selalu benar
    //exception di atas
    public void addCardById(int id,CharacterCard c){
        this.fillingIndicator[id]=1;
        this.filled++;
        this.cardBoard[id]=c;
    }
    public CharacterCard popCard(int index){
        //ngambil kartu dari index ke-index
        //ubah indikator index ke-index -> 0
        //kurangi filled -1
        //return kartu pada index ke-index
        this.fillingIndicator[index]=0;
        this.filled--;
        return this.cardBoard[index];
    }
}
