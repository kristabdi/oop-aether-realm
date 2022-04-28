package com.aetherwars.model;

// import javax.smartcardio.Card;

public abstract class SpellCard extends Card {
    private int mana;
    private int duration;
    private int exp;

    SpellCard(String name, String type, String description, int mana, int duration, int exp, String imagePath) {
        super(name, type, description, imagePath);
        this.mana = mana;
        this.duration = duration;
        this.exp = exp;
    }
    
    abstract void execute(CharacterCard s);

    @Override
    public int getMana() {
        return mana;
    }

    public void setSpellMana(int mana) {
        this.mana = mana;
    }

    public int getSpellDuration() {
        return duration;
    }

    public void setSpellDuration(int duration) {
        this.duration = duration;
    }

    public int getEXP() {
        return exp;
    }

    public void setEXP(int exp) {
        this.exp = exp;
    }
}