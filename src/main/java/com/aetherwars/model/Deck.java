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

    public void fillDeck(List<CharacterCard> characterCards, List<MorphSpell> morphSpells, List<PotionSpell> potionSpells, List<SwapSpell> swapSpells, List<LevelSpell> levelSpells){
        // selama belom max capacity, insert
        while(cardInDeck.size() < MAX_STACK_SIZE){
            // Ambil angka random
            int random = (int) (Math.random() * 5) + 1;
            //random card
            if ((random % 5 == 0)) {
                //random level spell
                int randomLevelSpell = (int) (Math.random() * levelSpells.size());
                cardInDeck.push(levelSpells.get(randomLevelSpell));
                // System.out.println(levelSpells.get(randomLevelSpell));
            } else if ((random % 5 == 1)) {
                //random swap spell
                int randomSwapSpell = (int) (Math.random() * swapSpells.size());
                cardInDeck.push(swapSpells.get(randomSwapSpell));
                // System.out.println(swapSpells.get(randomSwapSpell));
            } else if ((random % 5 == 2)) {
                //random potion spell
                int randomPotionSpell = (int) (Math.random() * potionSpells.size());
                cardInDeck.push(potionSpells.get(randomPotionSpell));
                // System.out.println(potionSpells.get(randomPotionSpell));
            } else if ((random % 5 == 3)) {
                //random morph spell
                int randomMorphSpell = (int) (Math.random() * morphSpells.size());
                cardInDeck.push(morphSpells.get(randomMorphSpell));
                // System.out.println(morphSpells.get(randomMorphSpell));
            } else {
                //random character card
                int randomCharacterCard = (int) (Math.random() * characterCards.size());
                cardInDeck.push(characterCards.get(randomCharacterCard));
                // System.out.println(characterCards.get(randomCharacterCard));
            }
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
}
