package com.aetherwars.model;

import java.util.List;

// public class GameState {
//     //punya catatan global yg gabakal keganti
//     // list semua kartu yg mungkin

//     // attribut
//     private String word;

//     // UMUM
//     public GameState() {
//         this.word = "abcdef";
//     }
//     public String getWord(){
//         return this.word;
//     }
//     public void changeWord(){
//         if(this.word.equals("abcdef")){
//             this.word = "ini yg baru";
//         }
//         else{
//             this.word = "abcdef";
//         }
//     }
// }


public class GameState {
    //punya catatan global yg gabakal keganti
    // list semua kartu yg mungkin
    private List<CharacterCard> characterCards;
    private List<MorphSpell> morphSpells;
    private List<PotionSpell> potionSpells;
    private List<SwapSpell> swapSpells;
    private List<LevelSpell> levelSpells;
    // attribut
    private Integer turn;
    // using enum for phase
    private Phase phase;

    private Player player1;
    private Player player2;

    // buffer. sapatau butuh
    public Card selectedCardInHand;
    public Card selectedCardOnBoard;

    public enum Phase {
        DRAW,
        PLAN,
        ATTACK,
        END
    }

    // UMUM
    public GameState(List<CharacterCard> characterCards, List<MorphSpell> morphSpells, List<PotionSpell> potionSpells, List<SwapSpell> swapSpells, List<LevelSpell> levelSpells) {
        this.turn = 1;
        this.phase = Phase.DRAW;
        Deck d1 = new Deck();
        d1.fillDeck(characterCards, morphSpells, potionSpells, swapSpells, levelSpells);
        Deck d2 = new Deck();
        d2.fillDeck(characterCards, morphSpells, potionSpells, swapSpells, levelSpells);
        this.player1 = new Player("pesatu", 0, d1, new CardInHand(), new Board());
        this.player2 = new Player("pedua", 0, d2, new CardInHand(), new Board());
        this.characterCards = characterCards;
        this.morphSpells = morphSpells;
        this.potionSpells = potionSpells;
        this.swapSpells = swapSpells;
        this.levelSpells = levelSpells;

    }
    public int getTurn() {
        return this.turn;
    }
    public Phase getPhase(){
        return this.phase;
    }
    public void nextPhase(){
        // ganti phase, add ngelakuin modifikasi data di game state yg dibutuhkan (misal cleaning seletedCardInHand sama OnBoard. baru kepikiran itu)
        switch (this.phase){
            case DRAW:
                this.phase = Phase.PLAN;
                break;
            case PLAN:
                this.phase = Phase.ATTACK;
                break;
            case ATTACK:
                this.phase = Phase.END;
                break;
            case END:
            //tambahin update board
                this.phase = Phase.DRAW;
                if(this.turn == 1){
                    this.turn = 2;
                }
                else{
                    this.turn = 1;
                }
                break;
        }
    }
    public List<Card> getCardInHand(){
        // return card in hand
        if(this.turn == 1){
            return player1.getCardInHandPlayer();
        }
        else{
            return player2.getCardInHandPlayer();
        }

    }
    public Card getCardOnBoard(Integer idx){
        // return card on board
        if(this.turn == 1){
            return player1.getCardOnBoard(idx);
        }else{
            return player2.getCardOnBoard(idx);
        }
    }
    public Boolean isGameOver(){
        // mengecek apakah deck salah satu pemain sudah habis. kalo sudah return true. 
        if(player1.getPlayerDeckSize() == 0 || player2.getPlayerDeckSize() == 0 || player1.getHealth() <= 0 || player2.getHealth() <= 0){
            return true;
        }else return false;
    }
    public void setSelectedCardInHand(Integer index){
        if(this.turn == 1){
            this.selectedCardInHand = player1.getCardInHandPlayer().get(index);
        }
        else{
            this.selectedCardInHand = player2.getCardInHandPlayer().get(index);
        }
    }
    public Boolean spellInBuffer(){
        // mengembalikan true, jika bufferSelectedCardInHand bertipe spell
        return (this.selectedCardInHand instanceof SpellCard);
    }
    
    public void selectAttacker(int index){
    // nyimpen SelectedCardOnBoard sebagai kartu di board lawan yang dipilih
        if(this.turn == 1){
            this.selectedCardOnBoard = this.player2.getCardOnBoard(index);
        }
        else{
            this.selectedCardOnBoard = this.player1.getCardOnBoard(index);
        }
    }

    public void clearSelectedCardInHandBuffer(){
        this.selectedCardInHand = null;
    }
    public void clearSelectedCardOnBoardBuffer(){
        this.selectedCardOnBoard = null;
    }
    public Player getCurrentPlayer(){
        if(this.turn == 1){
            System.out.println("current player adalah player 1");
            return this.player1;
        }
        else{
            System.out.println("current player adalah player 2");
            return this.player2;
        }
    }
    public Player getPlayer(Integer idx){
        if(idx == 1){
            return this.player1;
        }
        else{
            return this.player2;
        }
    }
    // HELPER SAAT PHASE DRAW
    public List<Card> getThreeCardFromDeck(Integer player){
        // ngasi 3 buah kartu dari deck player 1 ataupun player 2. sementara asumsi kalo udah di get 3 dari deck, deck langsung berkurang 3. tapi masih tergantung implementasi dari Deck
        if(player==1){
            return player1.draw();
        }else{
            return player2.draw();
        }
    }
    public void addCardInHand(Card card){
        // add card ke hand player 1 atau player 2
        if(this.turn == 1){
            player1.addCardToCardInHand(card);
        }
        else{
            player2.addCardToCardInHand(card);
        }
    }
    public void addCardToDeck(Card card){
        // add card ke deck player 1 atau player 2 berdasarkan current turn
        if(this.turn == 1){
            player1.addCardToDeck(card);
        }
        else{
            player2.addCardToDeck(card);
        }
    }

    // HELPER SAAT PHASE PLAN
    public void addCardToBoardAndCleanBuffer(Integer idxBoard){
        // add card ke board player 1 atau player 2 berdasarkan isi dari buffer selected card in hand. abis itu clear buffer selected card in hand
        if(this.turn == 1){
            player1.addCardToBoard(idxBoard,this.selectedCardInHand);
        }else{
            player2.addCardToBoard(idxBoard,this.selectedCardInHand);
        }
        this.clearSelectedCardInHandBuffer();
    }
    public void cardOnBoardGotSpelled(Integer idxBoard){
        //berdasarkan turn dan buffer selectedCardInHand
        // mengenai spell ke card on board
        //masi bingung :(
        // minta ke player lawan, 
            // butuh cardOnBoardGotSpelled(lokasi card di board, lokasi spell card in hand)
        if(this.turn == 1){
            player1.useSpellOnCard((CharacterCard)this.selectedCardOnBoard,(SpellCard) this.selectedCardInHand);
        }
        else{
            player2.useSpellOnCard((CharacterCard)this.selectedCardOnBoard,(SpellCard) this.selectedCardInHand);
        }
    }
    public void removeCardFromHand(Integer cardIdx){
        // remove card dari hand player 1 atau player 2
        if(this.turn == 1){
            player1.removeCardInHand(cardIdx);
        }else{
            player2.removeCardInHand(cardIdx);
        }
    }

    public boolean haveSelected(){
        return selectedCardInHand != null;
    }

    // HELPER SAAT PHASE ATTACK
    public void attack(Integer idxBoardAttacker){
        // get card yg attacker sama victim
        // melakukan peng attackan berdasarkan turn saat ini, selectedCardOnBoard. jadi player pada turn saat ini, akan mengattack selectedCardOnBoard.
        if(this.turn == 1){
            Card attacker = player2.getCardOnBoard(idxBoardAttacker);
            // attack
            if(player1.isVulnerable()){
                // attack player langsung
                player1.decreaseMyHealthBasedOnCardAttackStats((CharacterCard) attacker);
            }
            else{
                // kalo board yg diklik valid(ada card disitu), dan dia belum nge attack, brarti bisa attack.
                // kalo gk, do nothing
            }
        }else{
            // attack dilakukan oleh player 2
        }
    }
    // HELPER SAAT PHASE END
    // butuh method untuk endgame saat salah satu player mati
}
