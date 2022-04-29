package com.aetherwars.model;
import java.util.ArrayList;
import java.util.List;


public class Player {
    //atribut
    private String name;
    private int mana; // default 1
    private int maxMana;
    private int health; // default 80
    private Deck deck;
    private CardInHand cardInHand;
    private Board cardOnBoard;

    Player() {
        this.name = "Player 1";
        this.mana = 1;
        this.maxMana = 10;
        this.health = 80;
        this.deck = new Deck();
        this.cardInHand = new CardInHand();
        this.cardOnBoard = new Board();
    }
    
    Player(String name, int mana, Deck deck, CardInHand cardInHand, Board cardOnBoard) {
        this.name = name;
        this.mana = mana;
        this.maxMana = 10;
        this.health = 80;
        this.deck = deck;
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
        return (this.cardOnBoard.getFilled() <= 0);
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

    public void useManaForExp(CharacterCard card) {
        // menambahkan exp ke card, dengan menghilangkan mana dari player
        if (this.mana > 0) {
            card.addExp(mana);
            this.setMana(this.mana - 1);
        }
    }

    public void useSpellOnCard(CharacterCard card, SpellCard spell) {
        if (spell instanceof LevelSpell) {
            spell.setSpellMana((int)Math.ceil(((double)card.getLevel())/2.0));
        }
        if (this.mana >= spell.getMana()) {
            this.setMana(this.mana - spell.getMana());
            spell.execute(card);
        }
    }

    public void attack(Integer myBoardIndex, CharacterCard victim) {
        // apakah charactercard di my board index ada isinya,
        if(this.cardOnBoard.isSlotFilled(myBoardIndex)){
            //kalau iya
            // apakah karaktercard di myboard index belum attack,
            if(!this.cardOnBoard.hasCardInIndexAttacked(myBoardIndex)){
                ((CharacterCard)this.getCardOnBoard(myBoardIndex)).attack(victim);
            }
        }
        // else do nothing
    }

    public Boolean hasCharacterInBoardWithIndexXAttacked(Integer x){
        return this.cardOnBoard.hasCardInIndexAttacked(x);
    }

    public void setCharacterInBoardWithIndexXAttackedToTrue(Integer x){
        this.cardOnBoard.setCardInIndexAttackedToTrue(x);
    }

    public Card getCardOnBoard(int idx){
        return this.cardOnBoard.getCardBoardByIdx(idx);
    }

    public int getBoardFilled(){
        // mengembalikan jumlah kartu yang sudah diisi di board
        return cardOnBoard.getFilled();
    }

    public void addCardToBoard(Integer idx, Card card) {
        // cek dulu mana yg dimiliki player saat ini, harus lebih dari 'cost' mana buat nge deploy card to deck. 
        // kalo kurang, do nothing
        if (this.mana >= ((CharacterCard)card).getMana()) {
            this.mana -= ((CharacterCard)card).getMana();
            this.cardOnBoard.addCardById(idx,(CharacterCard)card);
        }
    }

    public void addCardToCardInHand(Card card) {
        this.cardInHand.putCardToHand(card);
    }
    public void addCardToDeck(Card card){
        deck.putCardToDeck(card);
    }

    public void decreaseMyHealthBasedOnCardAttackStats(CharacterCard card) {
        this.health = card.attackPlayer(this.health);
    }
    public void updateBoard() {
        // iterate board to set attack modifier, health modifier, etc
        cardOnBoard.update();
    }
    public void setAllBoardHasAttackedToFalse(){
        cardOnBoard.resetAllAttackToFalse();
    }
    public void reduceSpellOnCardOnPlayerBoardDuration(){
        cardOnBoard.reduceSpellOnCardOnBoardDuration();
    }
}
