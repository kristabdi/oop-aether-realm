package com.aetherwars.model;

public class BoardSlot {
    private CharacterCard card;
    private boolean hasAttack;
    private boolean isFilled;

    public BoardSlot() {
        this.card = null;
        this.hasAttack = false;
        this.isFilled = false;
    }

    public BoardSlot(CharacterCard c){
        this.card = c;
        this.hasAttack = false;
        this.isFilled = true;
    }

    public CharacterCard getCard() {
        return card;
    }

    public void setCard(CharacterCard card) {
        this.card = card;
    }

    public boolean hasAttack(){
        return hasAttack;
    }
    
    public void setAttack(boolean b){
        hasAttack = b;
    }

    public boolean isFilled(){
        return isFilled;
    }

    public void setEmptiness(boolean b){
        isFilled = b;
    }
}
