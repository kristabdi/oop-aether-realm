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
    private Boolean hasDrawn;
    // using enum for phase
    private Phase phase;

    private Player player1;
    private Player player2;

    // buffer. sapatau butuh
    public Card selectedCardInHand;
    public Card cardOnDescription;
    public Card selectedCardOnBoard;
    public Integer selectedCardOnBoardNumber;
    public List<Card> bufferDrawnCards;

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
        this.player1 = new Player("pesatu", 10, d1, new CardInHand(), new Board());
        this.player2 = new Player("pedua", 10, d2, new CardInHand(), new Board());
        this.characterCards = characterCards;
        this.morphSpells = morphSpells;
        this.potionSpells = potionSpells;
        this.swapSpells = swapSpells;
        this.levelSpells = levelSpells;
        this.hasDrawn = false;
    }
    public int getTurn() {
        return this.turn;
    }
    public Phase getPhase(){
        return this.phase;
    }
    public void nextPhase(){
        // ganti phase, add ngelakuin modifikasi data di game state yg dibutuhkan (misal cleaning seletedCardInHand sama OnBoard. baru kepikiran itu)
        this.bufferDrawnCards = null;
        this.selectedCardInHand = null;
        this.selectedCardOnBoard = null;
        this.cardOnDescription = null;
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
                this.hasDrawn = false;
                if(this.turn == 1){
                    this.turn = 2;
                }
                else{
                    this.turn = 1;
                }
                break;
        }
    }
    public List<Card> getCardInHandGameState(){
        // return card in hand
        if(this.turn == 1){
            return player1.getCardInHandPlayer();
        }
        else{
            return player2.getCardInHandPlayer();
        }

    }
    public Card getPlayerCardOnBoard(Integer player, Integer idx){
        // return card on board
        if(player == 1){
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
    public void setSelectedCardInHand(Integer cardNumber){
        if(this.turn == 1){
            this.selectedCardInHand = player1.getCardInHandPlayer().get(cardNumber - 1);
        }
        else{
            this.selectedCardInHand = player2.getCardInHandPlayer().get(cardNumber - 1);
        }
    }
    public Boolean spellInBuffer(){
        // mengembalikan true, jika bufferSelectedCardInHand bertipe spell
        return (this.selectedCardInHand instanceof SpellCard);
    }
    
    public void selectAttacker(int boardNumber){
    // nyimpen SelectedCardOnBoard sebagai kartu di board SENDIRI yang akan meng attack
        System.out.println("MASUK SELECT ATTACKER!");
        if(this.turn == 1){
            this.selectedCardOnBoard = this.player1.getCardOnBoard(boardNumber  - 1);
        }
        else{
            this.selectedCardOnBoard = this.player2.getCardOnBoard(boardNumber - 1);
        }
        this.selectedCardOnBoardNumber = boardNumber;
    }
    public Card getSelectedCardInHand(){
        return this.selectedCardInHand;
    }
    public void clearSelectedCardInHandBuffer(){
        this.selectedCardInHand = null;
    }
    public void clearSelectedCardOnBoardBuffer(){
        this.selectedCardOnBoard = null;
        this.selectedCardOnBoardNumber = null;
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
    public Player getPlayer(Integer playerNumber){
        if(playerNumber == 1){
            return this.player1;
        }
        else{
            return this.player2;
        }
    }
    public Card getCardOnDescriptionBuffer(){
        return this.cardOnDescription;
    }
    public void setCardOnDescriptionBuffer(Integer player, String location, Integer cardNumber){
        // palyer bisa 1 atau 2
        // location bisa "board" atau "cardInHand"
        // index bisa 1 - 5
        if(player == 1){
            if(location == "board"){
                this.cardOnDescription = this.player1.getCardOnBoard(cardNumber - 1);
            }
            else{
                this.cardOnDescription = this.player1.getCardInHandPlayer().get(cardNumber - 1);
            }
        }
        else{
            if(location == "board"){
                this.cardOnDescription = this.player2.getCardOnBoard(cardNumber - 1);
            }
            else{
                this.cardOnDescription = this.player2.getCardInHandPlayer().get(cardNumber - 1);
            }
        }
        System.out.println("== CARD YANG SAAT INI DI DI DESCRIPTION ADALAH ====");
        System.out.println(this.cardOnDescription);

    }

    public Integer getCurrentPlayerMana(){
        if(this.turn == 1){
            return this.player1.getMana();
        }
        else{
            return this.player2.getMana();
        }
    }
    // HELPER SAAT PHASE DRAW
    public void getThreeCardsFromDeckToBuffer(){
        // ngasi 3 buah kartu dari deck player 1 ataupun player 2. sementara asumsi kalo udah di get 3 dari deck, deck langsung berkurang 3. tapi masih tergantung implementasi dari Deck
        if(this.turn == 1){
            this.bufferDrawnCards = player1.draw();
        }else{
            this.bufferDrawnCards = player2.draw();
        }
    }
    public List<Card> getBufferDrawnCards(){    
        return this.bufferDrawnCards;
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
    public void addCardToBoardAndCleanBuffer(Integer boardNumber){
        // add card ke board player 1 atau player 2 berdasarkan isi dari buffer selected card in hand. abis itu clear buffer selected card in 
        System.out.println("AKAN MENBAMHAKN CARD KE BOARD,");
        System.out.println("CARD YANG DITAMBAHKAN ADALAH ");
        System.out.println(this.selectedCardInHand);
        if(this.turn == 1){
            player1.addCardToBoard(boardNumber - 1, this.selectedCardInHand);
        }else{
            player2.addCardToBoard(boardNumber - 1, this.selectedCardInHand);
        }
        this.clearSelectedCardInHandBuffer();
    }
    
    public void cardOnBoardGotSpelled(Integer boardNumber){
        // berdasarkan current turn dan selectedCardInHand
        if(this.turn == 1){
            // pertama, cek apakah yg di board itu character card dan yang di buffer itu spell.
            if(this.player1.getCardOnBoard(boardNumber - 1) instanceof CharacterCard && this.selectedCardInHand instanceof SpellCard){
                player1.useSpellOnCard((CharacterCard)this.selectedCardOnBoard,(SpellCard) this.selectedCardInHand);
            }
        }
        else{
            if(this.player2.getCardOnBoard(boardNumber - 1) instanceof CharacterCard && this.selectedCardInHand instanceof SpellCard){
                player2.useSpellOnCard((CharacterCard)this.selectedCardOnBoard,(SpellCard) this.selectedCardInHand);
            }
        }
    }

    public void removeCardFromHand(){
        System.out.println("AKAN ME REMOVE CARD DARI CARD IN HAND");
        System.out.println(this.selectedCardInHand);
        // remove card dari hand player 1 atau player 2
        if(this.turn == 1){
            List<Card> cards = player1.getCardInHandPlayer();
            Integer cardNumber = cards.indexOf(this.selectedCardInHand);
            player1.removeCardInHand(cardNumber);
        }else{
            List<Card> cards = player2.getCardInHandPlayer();
            Integer cardNumber = cards.indexOf(this.selectedCardInHand);
            player2.removeCardInHand(cardNumber);
        }
    }
    public Card getSelectedCardOnBoard(){
        return this.selectedCardOnBoard;
    }
    public Integer getSelectedCardOnBoardNumber(){
        return this.selectedCardOnBoardNumber;
    }

    public Boolean haveSelectedCardInHand(){
        return selectedCardInHand != null;
    }

    // HELPER SAAT PHASE ATTACK
    public void attack(){
        System.out.println("ADA YG COBA NGE ATTACK PLAYER LANGSUNG");
        System.out.println("attack di lakukan oleh " + String.valueOf(this.turn));
        System.out.println("menggunakan ");
        System.out.println(this.selectedCardOnBoard);

        // attack langsung ke player
        // jika lawan vulnerable, attack. jika tidak, do nothing
        if(this.selectedCardOnBoard != null){
            if(this.turn == 1){
                System.out.println("apakah charcter di buffer sudah pernah nge attack?");
                Boolean isHaveAttacked = this.player1.hasCharacterInBoardWithIndexXAttacked(this.selectedCardOnBoardNumber - 1);
                System.out.println(isHaveAttacked);
                if(this.player2.isVulnerable() && !isHaveAttacked){
                    this.player2.decreaseMyHealthBasedOnCardAttackStats((CharacterCard)this.selectedCardOnBoard);
                    // Set characterCard player opposite di Index selectedCardOnBoardNumber has Attack menjadi true
                    this.player1.setCharacterInBoardWithIndexXAttackedToTrue(this.selectedCardOnBoardNumber - 1);
                }
            }
            else{
                System.out.println("apakah charcter di buffer sudah pernah nge attack?");
                Boolean isHaveAttacked = this.player2.hasCharacterInBoardWithIndexXAttacked(this.selectedCardOnBoardNumber - 1);
                System.out.println(isHaveAttacked);
                if(this.player1.isVulnerable() && !isHaveAttacked){
                    this.player1.decreaseMyHealthBasedOnCardAttackStats((CharacterCard)this.selectedCardOnBoard);
                    this.player2.setCharacterInBoardWithIndexXAttackedToTrue(this.selectedCardOnBoardNumber - 1);
                }
            }
            this.clearSelectedCardOnBoardBuffer();
        }
    }
    public void attack(Integer boardNumberVictim){
        // get card yg attacker sama victim
        // melakukan peng attackan berdasarkan turn saat ini, selectedCardOnBoard. jadi player pada turn saat ini, akan mengattack selectedCardOnBoard.
        if(this.selectedCardOnBoard != null){
            if(this.turn == 1){
                Card victim = player2.getCardOnBoard(boardNumberVictim - 1);
                if(victim != null){
                    // Cek apakah boardNumber attacker hasAttacknya false
                    if(this.player1.hasCharacterInBoardWithIndexXAttacked(this.selectedCardOnBoardNumber - 1)){
                        player1.attack(this.selectedCardOnBoardNumber - 1, (CharacterCard)victim);
                    }
                    // ((CharacterCard)this.selectedCardOnBoard).attack((CharacterCard)victim);
                }
                // attack
            
            }else{
                // attack dilakukan oleh player 2
                Card victim = player1.getCardOnBoard(boardNumberVictim - 1);
                // attack
                if(victim != null){
                    ((CharacterCard)this.selectedCardOnBoard).attack((CharacterCard)victim);
                }
            }
        }
    }

    public Boolean getHasDrawn(){
        return this.hasDrawn;
    }

    public void setHasDrawn(Boolean bool){
        this.hasDrawn = bool;
    }
    // HELPER SAAT PHASE END
    // butuh method untuk endgame saat salah satu player mati
}
