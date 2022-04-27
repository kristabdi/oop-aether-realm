package com.aetherwars.model;

// import javax.smartcardio.Card;

public abstract class SpellCard extends Card {
    private int mana;
    private int duration;
    private int exp;
    private String imagepath;

    SpellCard(String name, String type, String description, int mana, int duration, int exp, String imagepath) {
        super(name, type, description);
        this.mana = mana;
        this.duration = duration;
        this.exp = exp;
        this.imagepath = imagepath;
    }
    
    abstract void execute(CharacterCard s);
    public int getSpellMana() {
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

    public String getImagePath() {
        return imagepath;
    }

    public void setImagePath(String imagepath) {
        this.imagepath = imagepath;
    }
}