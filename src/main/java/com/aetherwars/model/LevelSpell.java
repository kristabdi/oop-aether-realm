package com.aetherwars.model;

import java.lang.Math;

public class LevelSpell extends SpellCard implements Spell {
    private int levelModifier;

    public LevelSpell(String name, String type, String description, int mana, int levelModifier) {
    // SpellCard(String name, String type, String description, int mana, int duration, int exp, String imagepath)
        super(name, type, description, mana, 0, 0, "");
        this.levelModifier = levelModifier;
    }

    public void execute(CharacterCard s) {
        setSpellMana((int)Math.ceil(s.getLevel()/2));
        int newLevel = s.getLevel() + this.levelModifier;
        if (newLevel >= 1) {
            if (newLevel > 10) {
                newLevel = 10;
            }
            s.setLevel(newLevel);
        } else {
            s.setLevel(1);
        }
        s.setExp(0);
    }
}