public class GameState {
    //punya catatan global yg gabakal keganti
    // list semua kartu yg mungkin

    // attribut
    private Integer turn;
    // using enum for phase
    private Phase phase;

    private Player player1;
    private Player player2;

    // buffer. sapatau butuh
    public Card selectedCardInHand;
    public Card selectedCardOnBoard;

    // UMUM
    public GameState() {
        this.turn = 1;
        this.phase = Phase.DRAW;
        this.player1 = new Player();
        this.player2 = new Player();
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
                this.phase = Phase.DRAW;
                if(this.turn === 1){
                    this.turn = 2;
                }
                else{
                    this.turn = 1;
                }
                break;
        }
    }
    public List<Card> getCardInHand(Integer player){
        // return card in hand
    }
    public Card getCardOnBoard(Integer player, Integer idx){
        // return card on board
    }
    public Boolean isGameOver(){
        // mengecek apakah deck salah satu pemain sudah habis. kalo sudah return true
        return false;
    }

    // HELPER SAAT PHASE DRAW
    public List<Card> getThreeCardFromDeck(Integer player){
        // ngasi 3 buah kartu dari deck player 1 ataupun player 2. sementara asumsi kalo udah di get 3 dari deck, deck langsung berkurang 3. tapi masih tergantung implementasi dari Deck
    }
    public void addCardInHand(Integer player, Card card){
        // add card ke hand player 1 atau player 2
    }
    public void addCardToDeck(Integer player, Card card){
        // add card ke deck player 1 atau player 2
    }

    // HELPER SAAT PHASE PLAN
    public void addCardToBoard(Integer player, Integer idxBoard, Card card){
        // add card ke board player 1 atau player 2
    }
    public void cardOnBoardGotSpelled(Integer player, Integer idxBoard, Integer spellCardIdx){
        // mengenai spell ke card on board
    }
    public void removeCardFromHand(Integer player, Integer idxCardInHand){
        // remove card dari hand player 1 atau player 2
    }
    // HELPER SAAT PHASE ATTACK
    public void attack(Integer playerAttacker, Integer idxBoardAttacker, Integer idxBoardVictim){
        
    }
    // HELPER SAAT PHASE END

}

enum Phase {
    DRAW,
    PLAN,
    ATTACK,
    END
}