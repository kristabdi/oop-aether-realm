public class CardInHand {
    // Atributnya ada arrayList yg berisi 5
    private ArrayList<Card> cardInHand;
    private final static int MAX_CARD_IN_HAND = 5;
    private int selectedCardInHandIndex;
    
    // Method yang dimiliki ya ctor, putCardToHand, removeCardFromHand, putCardToBoard
    public CardInHand(){
        cardInHand = new ArrayList<Card>();
        selectedCardInHandIndex = -1;
    }

    public void putCardToHand(Card cardFromDeck){
        // Memasukkan kartu dari deck yang dipilih ke tangan
        // Kalau size udah Max, nanti fase draw di pass aja
        if(cardInHand.size() < MAX_CARD_IN_HAND){
            cardInHand.add(cardFromDeck);
            // cardFromDeck.cardOnHover(gameState);
        }
    }

    public Card removeCardFromHand(int idx){
        // Memindahkan kartu dari tangan, mengembalikan kartu yang dipilih
        // Idx engga mungkin salah karena pake GUI
        Card cardToBeRemoved = cardInHand.get(idx);
        if (cardToBeRemoved != null){
            cardInHand.remove(idx);
            // cardToBeRemoved.cardOnHover(gameState);
        }
        return cardToBeRemoved;
    }

    public Boolean isCardinHand(Card card) {
        for (Card cardHand : cardInHand) {
            if (cardHand.getName() == card.getName() && cardHand.getType() == card.getType() && cardHand.getDescription() == card.getDescription()) {
                return true;
            }
        }
        return false;
    }

    // Ngga usah pake ini, nanti di gameState yang manggil method ini trus naruh ke board
    // public void putCardToBoard(GameState gameState, int idxBoard, Card cardFromHand){
    //     // Memindahkan kartu dari tangan ke board
    //     // Idx engga mungkin salah karena pake GUI
    //     // I.S. IdxBoard sudah ada, jadi udah klik slot di board, baru fungsi ini dipanggil, kartu dari hand disimpan dulu
    //     // gameState.board.putCard(atau apalah)(cardFromHand, idxBoard);
    // }

    // cardInHand.removeByCard(card);
    // Kristo : player butuh fungsi buat ngehapus suatu card dari cardInHand dengan ngecek kalo ada maka dihapus
}
