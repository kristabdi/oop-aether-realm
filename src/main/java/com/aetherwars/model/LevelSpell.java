package com.aetherwars.model;

import java.lang.Math;

public class LevelSpell extends SpellCard implements Spell {
    private int levelModifier;

    public LevelSpell(String name, String type, String description, int mana, int levelModifier) {
        super(name, type, description, mana, 0, 0, "");
        this.levelModifier = levelModifier;
    }

    public void execute(CharacterCard s) {
        setSpellMana((int)Math.ceil(s.getLevel()/2));
        int newLevel = s.getLevel() + this.levelModifier;
        if (newLevel >= 1) {
            if (newLevel > 10) {
                // if more than max level limit
                newLevel = 10;
            }
            s.setLevel(newLevel);
            s.setMaxExp(2 * s.getLevel() - 1);
        } else {
            // set limit to 1
            s.setLevel(1);
            s.setMaxExp(1);
        }
        // reset exp
        s.setExp(0);
    }

    public int getLevelModifier() {
        return levelModifier;
    }
}