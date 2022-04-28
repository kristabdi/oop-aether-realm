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
            int random = (int) (Math.random() * 100) + 1;
            //random card
            if ((random > 0 && random < 16)) {
                //random level spell
                int randomLevelSpell = (int) (Math.random() * levelSpells.size());
                LevelSpell levelSpell = levelSpells.get(randomLevelSpell);
                LevelSpell newLevelSpell = new LevelSpell(levelSpell.getName(), levelSpell.getType(), levelSpell.getDescription(), levelSpell.getMana(), levelSpell.getLevelModifier());
                cardInDeck.push(newLevelSpell);
                // System.out.println(levelSpell);
            } else if ((random > 15 && random < 31)) {
                //random swap spell
                int randomSwapSpell = (int) (Math.random() * swapSpells.size());
                SwapSpell swapSpell = swapSpells.get(randomSwapSpell);
                SwapSpell newSwapSpell = new SwapSpell(swapSpell.getName(), swapSpell.getType(), swapSpell.getDescription(), swapSpell.getMana(), swapSpell.getSpellDuration(), swapSpell.getEXP(), swapSpell.getImagePath());
                cardInDeck.push(newSwapSpell);
                // System.out.println(swapSpell);
            } else if ((random > 30 && random < 46)) {
                //random potion spell
                int randomPotionSpell = (int) (Math.random() * potionSpells.size());

                PotionSpell ps = potionSpells.get(randomPotionSpell);

                String newName = ps.getName();
                String newType = ps.getType();
                String newDescription = ps.getDescription();
                int newMana = ps.getMana();
                int newDurasi = ps.getSpellDuration();
                int newExp = ps.getEXP();
                String newImagePath = ps.getImagePath();
                int newAttackModifier = ps.getAttackModifier();
                int newHealthModifier = ps.getHealthModifier();

                
                PotionSpell newPotionSpell = new PotionSpell(newName, newType, newDescription, newMana, newDurasi, newExp, newImagePath, newAttackModifier, newHealthModifier);
                cardInDeck.push(newPotionSpell);
                // System.out.println(potionSpells.get(randomPotionSpell));
            } else if ((random > 45 && random < 61)) {
                //random morph spell
                int randomMorphSpell = (int) (Math.random() * morphSpells.size());
                MorphSpell morphSpell = morphSpells.get(randomMorphSpell);
                String newName = morphSpell.getName();
                String newType = morphSpell.getType();
                String newDescription = morphSpell.getDescription();
                CharacterCard newCharacterCard = morphSpell.getMorphTarget();
                int newMana = morphSpell.getMana();
                String newImagePath = morphSpell.getImagePath();
                MorphSpell newMorphSpell = new MorphSpell(newName, newType, newDescription, newCharacterCard, newMana, newImagePath);
                cardInDeck.push(newMorphSpell);
                // System.out.println(morphSpells.get(randomMorphSpell));
            } else {
                //random character card
                int randomCharacterCard = (int) (Math.random() * characterCards.size());
                CharacterCard characterCard = characterCards.get(randomCharacterCard);
                // String name, Type attribute, String description, String imagePath, int attack, int health, int mana, int attackUp, int healthUp
                String newName = characterCard.getName();
                CharacterCard.Type newType = characterCard.getAttribute();
                String newDescription = characterCard.getDescription();
                String newImagePath = characterCard.getImagePath();
                int newAttack = characterCard.getAttack();
                int newHealth = characterCard.getHealth();
                int newMana = characterCard.getMana();
                int newAttackUp = characterCard.getAttackUp();
                int newHealthUp = characterCard.getHealthUp();
                CharacterCard newCharacterCard = new CharacterCard(newName, newType, newDescription, newImagePath, newAttack, newHealth, newMana, newAttackUp, newHealthUp);
                cardInDeck.push(newCharacterCard);
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
