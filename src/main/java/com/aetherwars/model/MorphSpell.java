public class MorphSpell extends SpellCard implements Spell {
    private CharacterCard morphTarget;

    MorphSpell(String name, String type, String description, String imagepath, CharacterCard target, int mana) {
        super(name, type, description, mana, 0, imagepath);
        this.morphTarget = target;
    }

    public CharacterCard getMorphTarget() {
        return morphTarget;
    }

    public void setMorphTarget(CharacterCard morphTarget) {
        this.morphTarget = morphTarget;
    }

    public void execute(CharacterCard s) {
        s = new CharacterCard(morphTarget.getName(), morphTarget.getAttribute(), morphTarget.getDescription(), morphTarget.getImgPath(), morphTarget.getAttack(), morphTarget.getHealth(), morphTarget.getMana(), morphTarget.getAttackUp(), morphTarget.getHealthUp());
    }
}
