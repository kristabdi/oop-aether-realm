package com.aetherwars.model;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class Deck {
    //max stack size
    private static final int MAX_STACK_SIZE = 40;
    //stack of cards
    private Stack<Card> cardInDeck;

    public Deck() {
        cardInDeck = new Stack<Card>();
    }

    public void fillDeck(List<Card> listOfPossibleCard){
        // selama belom max capacity, insert
        while(cardInDeck.size() < MAX_STACK_SIZE){
            //random card
            int randomCard = (int) (Math.random() * listOfPossibleCard.size());
            //insert
            this.putCardToDeck(listOfPossibleCard.get(randomCard));
        }
    }

    // Misal cardnya diinisiasi dari gamestate, tinggal push terus ke Deck
    public void putCardToDeck(Card card) {
        // Memasukkan card ke Deck
        if (cardInDeck.size() < MAX_STACK_SIZE) {
            cardInDeck.push(card);
        }
    }

    public List<Card> showThreeCards() {
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

    // Kristo : butuh getSize deck biar ngecek player masih bisa main apa engga (done)
}
