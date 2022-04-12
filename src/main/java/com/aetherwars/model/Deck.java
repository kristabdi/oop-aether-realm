public class Deck {
    //max stack size
    private final int MAX_STACK_SIZE = 40;
    //stack of cards
    private Stack<Card> cardInDeck;

    public Deck() {
        cardInDeck = new Stack<Card>();
    }

    // Misal cardnya diinisiasi dari gamestate, tinggal push terus ke Deck
    public void putCardToDeck(Card card) {
        if (cardInDeck.size() < MAX_STACK_SIZE) {
            cardInDeck.push(card);
        }
    }

    public Card showThreeCards(gameWIndow) {
        // nampilin 3 kartu ke layar,
        //return satu buah kartu yang dipilih, kembaliin 2 sisanya ke deck
    }
    
    public void putBack(Card card){
        //bisa dimanfaatin sama showthreecards
    }

}
