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
        // Memasukkan card ke Deck
        if (cardInDeck.size() < MAX_STACK_SIZE) {
            cardInDeck.push(card);
        }
    }

    public ArrayList<Card> showThreeCards() {
        // Return sebuah ArrayList yang berisi 3 kartu teratas atau sisa kartu dari Deck yang <= 3
        ArrayList<Card> threeCards = new ArrayList<Card>();
        int i = 0;
        while (i < 3 && cardInDeck.size() > 0) {
            Card card = cardInDeck.pop();
            threeCards.add(card);
            i++;
        }
        return threeCards;
    }

    public int getDeckSize() {
        return cardInDeck.size();
    }

    // Kristo : butuh getSize deck biar ngecek player masih bisa main apa engga
}
