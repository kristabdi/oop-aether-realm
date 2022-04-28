package com.aetherwars.model;

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
        s = new CharacterCard(morphTarget.getName(), morphTarget.getAttribute(), morphTarget.getDescription(), morphTarget.getImgPath(), morphTarget.getAttack(), morphTarget.getHealth(), morphTarget.getMana(), morphTarget.getAttackUp(), morphTarget.getHealthUp(), morphTarget.getImagePath());
    }
}