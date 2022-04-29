package com.aetherwars.model;

import java.util.List;

public class GameState {
    // list semua kartu yg mungkin
    private List<CharacterCard> characterCards;
    private List<MorphSpell> morphSpells;
    private List<PotionSpell> potionSpells;
    private List<SwapSpell> swapSpells;
    private List<LevelSpell> levelSpells;
    // attribut
    private Integer turn;
    private Boolean hasDrawn;
    private Integer round; // 1 ronde terdiri atas 2 turn
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
    public boolean hasAttackInThisTurn;
    public enum Phase {
        DRAW,
        PLAN,
        ATTACK,
        END
    }

    // UMUM
    public GameState(List<CharacterCard> characterCards, List<MorphSpell> morphSpells, List<PotionSpell> potionSpells, List<SwapSpell> swapSpells, List<LevelSpell> levelSpells) {
        this.round = 1;
        this.turn = 1;
        this.phase = Phase.DRAW;
        Deck d1 = new Deck();
        d1.fillDeck(characterCards, morphSpells, potionSpells, swapSpells, levelSpells);
        Deck d2 = new Deck();
        d2.fillDeck(characterCards, morphSpells, potionSpells, swapSpells, levelSpells);
        this.player1 = new Player("Geprek", 1, d1, new CardInHand(), new Board());
        this.player2 = new Player("Jones", 1, d2, new CardInHand(), new Board());
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
                    this.round += 1;
                }
                this.player1.resetMana(round);
                this.player1.setAllBoardHasAttackedToFalse();
                this.player1.reduceSpellOnCardOnPlayerBoardDuration();
                this.player2.resetMana(round);
                this.player2.setAllBoardHasAttackedToFalse();
                this.player2.reduceSpellOnCardOnPlayerBoardDuration();
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
            return this.player1;
        }
        else{
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

    }
    public int getRound(){
        return this.round;
    }
    public Integer getCurrentPlayerMana(){
        if(this.turn == 1){
            return this.player1.getMana();
        }
        else{
            return this.player2.getMana();
        }
    }

    public void refreshBothPlayerDeck(){

        this.player1.updateBoard();
        this.player2.updateBoard();
    }

    public void currentPlayerManaToExp(){
        if(this.phase == Phase.PLAN){
            if(this.turn == 1){
                if(this.player1.getMana() > 0 && this.selectedCardOnBoard != null){
                    this.player1.setMana(this.player1.getMana() - 1);
                    ((CharacterCard)this.selectedCardOnBoard).addExp(1);
                }
            }
            else{
                if(this.player2.getMana() > 0 && this.selectedCardOnBoard != null){
                    this.player2.setMana(this.player2.getMana() - 1);
                    ((CharacterCard)this.selectedCardOnBoard).addExp(1);;
                }
            }
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
    public void addCardToBoard(Integer boardNumber){
        // add card ke board player 1 atau player 2 berdasarkan isi dari buffer selected card in hand. abis itu clear buffer selected card in 
        if(this.turn == 1){
            player1.addCardToBoard(boardNumber - 1, this.selectedCardInHand);
        }else{
            player2.addCardToBoard(boardNumber - 1, this.selectedCardInHand);
        }
    }
    
    public void morphOpponentCardOnBoard(Integer OpponentBoardNumber){
        // berdasarkan current turn dan selectedCardInHand
        if(this.turn == 1){
            // pertama, cek apakah yg di board itu character card dan yang di buffer itu spell.
            if(this.player2.getCardOnBoard(OpponentBoardNumber - 1) instanceof CharacterCard && this.selectedCardInHand instanceof MorphSpell){
                // gunakan spell
                player2.useSpellOnCard((CharacterCard)this.player1.getCardOnBoard(OpponentBoardNumber - 1),(SpellCard) this.selectedCardInHand);
                
            }
        }
        else{
            if(this.player1.getCardOnBoard(OpponentBoardNumber - 1) instanceof CharacterCard && this.selectedCardInHand instanceof MorphSpell){
                player1.useSpellOnCard((CharacterCard)this.player2.getCardOnBoard(OpponentBoardNumber - 1),(SpellCard) this.selectedCardInHand);
            }
        }
    }

    public void cardOnBoardGotSpelled(Integer boardNumber){
        // berdasarkan current turn dan selectedCardInHand
        if(this.turn == 1){
            // pertama, cek apakah yg di board itu character card dan yang di buffer itu spell.
            if(this.player1.getCardOnBoard(boardNumber - 1) instanceof CharacterCard && this.selectedCardInHand instanceof SpellCard){
                // gunakan spell
                player1.useSpellOnCard((CharacterCard)this.player1.getCardOnBoard(boardNumber - 1),(SpellCard) this.selectedCardInHand);
                // remove selected card on hand
                
            }
        }
        else{
            if(this.player2.getCardOnBoard(boardNumber - 1) instanceof CharacterCard && this.selectedCardInHand instanceof SpellCard){
                player2.useSpellOnCard((CharacterCard)this.player2.getCardOnBoard(boardNumber - 1),(SpellCard) this.selectedCardInHand);
            }
        }
    }

    public void removeCardFromHand(){
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
        this.clearSelectedCardInHandBuffer();

    }
    public Card getSelectedCardOnBoard(){
        return this.selectedCardOnBoard;
    }
    public void setSelectedCardOnBoard(Card card){
        this.selectedCardOnBoard = card;
    }
    public Integer getSelectedCardOnBoardNumber(){
        return this.selectedCardOnBoardNumber;
    }
    public void setSelectedCardOnBoardNumber(Integer boardNumber){
        this.selectedCardOnBoardNumber = boardNumber;
    }
    public void setSelectedCardOnBoardBasedOnCurrentPlayer(Integer boardNumber){
        if(this.turn == 1){
            this.selectedCardOnBoard = this.player1.getCardOnBoard(boardNumber - 1);
        }
        else{
            this.selectedCardOnBoard = this.player2.getCardOnBoard(boardNumber - 1);
        }
    }

    public Boolean haveSelectedCardInHand(){
        return selectedCardInHand != null;
    }
    public Boolean isThereACardOnBoardXOnCurrentPlayerBoard(Integer boardNumber){
        if(this.turn == 1){
            return (this.player1.getCardOnBoard(boardNumber - 1) != null);
        }
        else{
            return (this.player2.getCardOnBoard(boardNumber - 1) != null);
        }

    }
    // HELPER SAAT PHASE ATTACK
    public void attack(){
        // attack langsung ke player
        // jika lawan vulnerable, attack. jika tidak, do nothing
        
        if(this.selectedCardOnBoard != null && this.phase == Phase.ATTACK){
            if(this.turn == 1){
                Boolean isHaveAttacked = this.player1.hasCharacterInBoardWithIndexXAttacked(this.selectedCardOnBoardNumber - 1);
                if(this.player2.isVulnerable() && !isHaveAttacked){
                    this.player2.decreaseMyHealthBasedOnCardAttackStats((CharacterCard)this.selectedCardOnBoard);
                    // Set characterCard player attacker di Index selectedCardOnBoardNumber has Attack menjadi true
                    this.player1.setCharacterInBoardWithIndexXAttackedToTrue(this.selectedCardOnBoardNumber - 1);
                }
            }
            else{
                Boolean isHaveAttacked = this.player2.hasCharacterInBoardWithIndexXAttacked(this.selectedCardOnBoardNumber - 1);
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
        if(this.selectedCardOnBoard != null && this.phase == Phase.ATTACK){
            if(this.turn == 1){
                Boolean isHaveAttacked = this.player1.hasCharacterInBoardWithIndexXAttacked(this.selectedCardOnBoardNumber - 1);
                
                Card victim = player2.getCardOnBoard(boardNumberVictim - 1);

                // Cek apakah boardNumber attacker hasAttacknya false
                if(victim != null && !isHaveAttacked){
                    player1.attack(this.selectedCardOnBoardNumber - 1, (CharacterCard)victim);
                    this.player1.setCharacterInBoardWithIndexXAttackedToTrue(this.selectedCardOnBoardNumber - 1);
                }
            
            
            }else{
                Boolean isHaveAttacked = this.player2.hasCharacterInBoardWithIndexXAttacked(this.selectedCardOnBoardNumber - 1);
                // attack dilakukan oleh player 2
                Card victim = player1.getCardOnBoard(boardNumberVictim - 1);
                // attack
                if(victim != null && !isHaveAttacked){
                    player2.attack(this.selectedCardOnBoardNumber - 1, (CharacterCard)victim);
                    this.player2.setCharacterInBoardWithIndexXAttackedToTrue(this.selectedCardOnBoardNumber - 1);

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
    public boolean isGameEnded(){
        return (this.player1.getHealth() <= 0 || this.player2.getHealth() <= 0 || this.player1.getPlayerDeckSize() <= 0 || this.player2.getPlayerDeckSize() <= 0);
    }
    public Player whoIsTheWinner(){
        if(this.isGameEnded()){
            if(this.player2.getHealth() <= 0){
                return this.player1;
            }
            else{
                return this.player2;
            }
        }
        else{
            return null;
        }
    }
    // HELPER SAAT PHASE END
    // butuh method untuk endgame saat salah satu player mati
}
