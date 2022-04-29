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
    

    public boolean addCardById(int id,CharacterCard c){
        if(this.cardBoard[id].isFilled()){
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
        cardBoard[idx].setAttack(true);
    }

    public void update(){
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