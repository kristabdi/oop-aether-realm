package com.aetherwars.model;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ext.DeclHandler;

public class Player {
    //atribut
    private String name;
    private int mana; // default 1
    private int maxMana;
    private int health; // default 80
    private Deck deck;
    private int selectedCardInHandIndex;
    private CardInHand cardInHand;
    private Board cardOnBoard;

    Player() {
        this.name = "Player 1";
        this.mana = 1;
        this.maxMana = 10;
        this.health = 80;
        this.deck = new Deck();
        this.selectedCardInHandIndex = -1;
        this.cardInHand = new CardInHand();
        this.cardOnBoard = new Board();
    }

    Player(String name, int mana, int selectedCardInHandIndex, Deck deck, CardInHand cardInHand, Board cardOnBoard) {
        this.name = name;
        this.mana = mana;
        this.maxMana = 10;
        this.health = 80;
        this.deck = deck;
        this.selectedCardInHandIndex = selectedCardInHandIndex;
        this.cardInHand = cardInHand;
        this.cardOnBoard = cardOnBoard;
    }

    // Getter Setter

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana <= maxMana) {
            this.mana = mana;
        }
    }

    public void resetMana(int turn) {
        // At the beginning of turn, mana = turn
        if (turn <= maxMana) {
            this.mana = turn;
        } else {
            this.mana = maxMana;
        }
    }
    

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        // Used if attacked
        this.health = health;
    }

    public Boolean isDead() {
        return (health <= 0 || deck.getDeckSize() == 0);
    }

    public int getPlayerDeckSize() {
        return (this.deck.getDeckSize());
    }

    public Boolean isVulnerable() {
        // Method to check if player can be attacked directly
        return (this.summonedCard.size() <= 0);
    }

    public List<Card> draw(){
        return deck.showThreeCards();
       // FS kartu yg dipilih udah masuk ke hand, kartu sisa udah masuk dec
    }

    public List<Card> getCardInHandPlayer(){
        // mengembalikan list of card yang dimiliki oleh player tersebut
        return cardInHand.getCardInHand();
    }

    public void removeCardInHand(Integer i) {
        cardInHand.removeCardFromHand(i);
    }

    public void removeSummonedCard(CharacterCard card) {
        summonedCard.remove(card);
    }

    public void addCardToBoard(Card card){
        // fungsi ini pure cuman nambahin kartu ke board. gk peduli card in hand, atau deck
        // mirip addcard inhand
        //  aku mau dia nambah card di index ke 'selctedCardInHand' ke board, abis itu delete card di hand di index 'selectedCardInHand', trus selectedCardInHand brubah jadi -1
        //update GUI cardInHand sama cardOnBoard
        //kalau spell:
        if (cardInHand.isCardinHand(card)) {
            if (card.getType().equals("Character")) {
                if (this.mana >= ((CharacterCard)card).getMana()) {
                    this.mana -= ((CharacterCard)card).getMana();
                }
                this.cardOnBoard.addCard((CharacterCard)card);
            }
        }
    }

    public void useManaForExp(CharacterCard card) {
        // menambahkan exp ke card, dengan menghilangkan mana dari player
        if (this.mana > 0) {
            card.addExp(mana);
            this.setMana(this.mana - 1);
        }
    }

    public void useSpellOnCard(CharacterCard card, SpellCard spell) {
        if (this.mana >= spell.getSpellMana()) {
            this.setMana(this.mana - spell.getSpellMana());
            spell.execute(card);
        }
    }

    public void attack(CharacterCard player, CharacterCard other) {
        player.attack(other);
    }

    public Card getCardOnBoard(int idx){
        return this.cardOnBoard.getCardBoardByIdx(idx);
    }

    public int getBoardFilled(){
        return cardOnBoard.getFilled();
    }

    public void addCardToBoard(Integer idx, Card card) {
        this.cardOnBoard.addCardById(idx,(CharacterCard)card);
    }

    public void addCardToCardInHand(Card card) {
        this.cardInHand.putCardToHand(card);
    }
    public void addCardToDeck(Card card){
        
    }
    // public void attackPlayerDirectly(Player enemy, int cardAttack){
        
    // }
    public void decreaseMyHealthBasedOnCardAttackStats(CharacterCard card) {
        this.health -= card.getFinalAttack();
    }
    // public void updateBoard() {
    //     // iterate board to set attack modifier, health modifier, etc
    //     cardOnBoard.update();
    // }
}