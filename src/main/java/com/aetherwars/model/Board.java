package com.aetherwars.model;

public class Board {
    private BoardSlot[] cardBoard;
    private int filled;

    public Board(){
        this.cardBoard = new BoardSlot[5];
        for (int i = 0; i < 5; i++) {
            this.cardBoard[i] = new BoardSlot();
        }
        this.filled = 0;
    }

    public CharacterCard getCardBoardByIdx(int idx){
        // kalo index yang dimasukin salah, return null 
        // Alternatif: Kalo di board kosong, buttonnya di disable untuk indeks itu, jadi ga bakal salah
        if(!this.cardBoard[idx].isFilled()){
            // kalo size dari card board - 1 >= idx, return yg bener. kalo gk return null
            return null;
        } else {
            return this.cardBoard[idx].getCard();
        }
    }
    public int getFilled(){
        return this.filled;
    }
    
    //asumsi input selalu benar
    //exception di atas
    public boolean addCardById(int id,CharacterCard c){
        System.out.println("ADD CARD BY ID DENGAN ID" + String.valueOf(id) + " DAN KARAKTERNYA ADALAH ");
        System.out.println(c);
        if(this.cardBoard[id].isFilled()){
            System.out.println("Udah ada isinya");
            return false;
        }else{
            this.cardBoard[id] = new BoardSlot(c);
            this.filled++;
            return true;
        }
    }

    public boolean isSlotFilled(int id){
        return cardBoard[id].isFilled();
    }
 
    public Boolean hasCardInIndexAttacked(Integer idx){
        return cardBoard[idx].hasAttack();
    }

    public void setCardInIndexAttackedToTrue(Integer idx){
        System.out.println("dari board, setCardInIndexAttackedToTrue jalan, dengan yg diset di index: ");
        System.out.println(idx);
        cardBoard[idx].setAttack(true);
    }
    //masi problem
    public void update(){
        System.out.println("UPDATE BOARD!");
        int i;
        int newFilled = this.getFilled();
        for(i=0;i<5;i++){
            if(this.cardBoard[i].isFilled()){
                if(this.cardBoard[i].getCard().getFinalHealth()>0){
                    this.cardBoard[i].getCard().setAttackBuff();
                    this.cardBoard[i].getCard().setHealthBuff();
                }else{
                    this.cardBoard[i].setCard(null);
                    this.cardBoard[i].setFilling(false);
                    newFilled -= 1;
                }
            }
        }
        this.filled = newFilled;
    }

    public void resetAllAttackToFalse(){
        for(int i=0;i<5;i++){
            if(this.cardBoard[i].isFilled()){
                this.cardBoard[i].setAttack(false);
            }
        }
    }
    public void reduceSpellOnCardOnBoardDuration(){
        for(int i=0;i<5;i++){
            if(this.cardBoard[i].isFilled()){
                this.cardBoard[i].getCard().updateSpellsEndDuration();
            }
        }

    }
}






   // public CharacterCard popCard(int index){
    //     //ngambil kartu dari index ke-index
    //     //ubah indikator index ke-index -> 0
    //     //kurangi filled -1
    //     //return kartu pada index ke-index
    //     this.cardBoard[index].setFilling(false);
    //     this.filled--;
    //     return this.cardBoard[index].getCard();
    // }


// public void addCard(CharacterCard c){
//         //cek dah penuh belum
//         //kalo belum
//         //cari index pertama yang kosong
//         //isi indx pertama yang kosong dengan kartu tadi
//         //ubah array keterisian index ke-index menjadi terisi(1)
//         //tambah jumlah kterisian
        
//             int i = 0;
//             while(this.cardBoard[i].isFilled()&& i<4){
//                 i++;
//             }
//             //karna sudah cek kepenuhan
//             //mentok i di idx 4 dan pasti dapet yang indexNone
//             addCardById(i,c);
//     }