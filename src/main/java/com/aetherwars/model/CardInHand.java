package com.aetherwars.model;
import java.util.ArrayList;

public class CardInHand {
    // Atributnya ada arrayList yg berisi 5
    private ArrayList<Card> cardInHand;
    private final static int MAX_CARD_IN_HAND = 5;
    
    public CardInHand(){
        cardInHand = new ArrayList<Card>();
        // selectedCardInHandIndex = -1;
    }

    public void putCardToHand(Card cardFromDeck){
        // Memasukkan kartu dari deck yang dipilih ke tangan
        // Kalau size udah Max, nanti fase draw di pass aja
        if(cardInHand.size() < MAX_CARD_IN_HAND){
            cardInHand.add(cardFromDeck);
        } else {
            // Remove paling kiri dari cardInHand, terus add yang terpilih
            cardInHand.remove(0);
            cardInHand.add(cardFromDeck);
        }
    }

    public Card removeCardFromHand(int idx){
        // Memindahkan kartu dari tangan, mengembalikan kartu yang dipilih
        // Idx engga mungkin salah karena pake GUI
        Card cardToBeRemoved = cardInHand.get(idx);
        if (cardToBeRemoved != null){
            cardInHand.remove(idx);
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

    public ArrayList<Card> getCardInHand() {
        return cardInHand;
    }
}
