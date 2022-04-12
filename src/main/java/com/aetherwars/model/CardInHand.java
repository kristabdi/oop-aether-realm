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

    public void putCardToHand(GameState gameState, Card cardFromDeck){
        // Memasukkan kartu dari deck yang dipilih ke tangan
        // Kalau size udah Max, nanti fase draw di pass aja
        if(cardInHand.size() < MAX_CARD_IN_HAND){
            cardInHand.add(cardFromDeck);
            // cardFromDeck.cardOnHover(gameState);
        }
    }

    public Card removeCardFromHand(GameState gameState, int idx){
        // Memindahkan kartu dari tangan, mengembalikan kartu yang dipilih
        // Idx engga mungkin salah karena pake GUI
        Card cardToBeRemoved = cardInHand.get(idx);
        cardInHand.remove(idx); // Method remove arraylist udah mindahin elemen ke kiri
        return cardToBeRemoved;
    }

    public void putCardToBoard(GameState gameState, int idxBoard, Card cardFromHand){
        // Memindahkan kartu dari tangan ke board
        // Idx engga mungkin salah karena pake GUI
        // I.S. IdxBoard sudah ada, jadi udah klik slot di board, baru fungsi ini dipanggil, kartu dari hand disimpan dulu
        // gameState.board.putCard(atau apalah)(cardFromHand, idxBoard);
    }

}
