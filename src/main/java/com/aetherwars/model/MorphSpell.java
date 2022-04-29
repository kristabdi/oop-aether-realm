package com.aetherwars.model;

import java.util.ArrayList;

public class MorphSpell extends SpellCard implements Spell {
    private CharacterCard morphTarget;

    public MorphSpell(String name, String type, String description, CharacterCard target, int mana, String imagePath) {
        
        super(name, type, description, mana, 0, 0, imagePath);
        this.morphTarget = target;
    }

    public CharacterCard getMorphTarget() {
        return morphTarget;
    }

    public void setMorphTarget(CharacterCard morphTarget) {
        this.morphTarget = morphTarget;
    }

    public void execute(CharacterCard s) {
        // change s attribute into morphTarget attribute
        s.setName(morphTarget.getName());
        s.setAttribute(morphTarget.getAttribute());
        s.setDescription(morphTarget.getDescription());
        s.setImagePath(morphTarget.getImagePath());
        s.setAttack(morphTarget.getAttack());
        s.setHealth(morphTarget.getHealth());
        s.setBaseAttack(morphTarget.getAttack());
        s.setBaseHP(morphTarget.getHealth());
        s.setMana(morphTarget.getMana());
        s.setAttackUp(morphTarget.getAttackUp());
        s.setHealthUp(morphTarget.getHealthUp());
        s.setLevel(1);
        s.setExp(0);
        s.setMaxExp(1);
        s.setActiveSpells(new ArrayList<>());
        s.setAttackBuff();
        s.setHealthBuff();
    }
}