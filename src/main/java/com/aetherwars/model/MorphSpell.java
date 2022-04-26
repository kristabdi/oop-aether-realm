public class MorphSpell extends SpellCard {
    private String morphTarget;

    MorphSpell(String name, String type, String description, String imagepath, String targetName, int mana) {
        super(name, type, description, mana, 0, 0, imagepath);
        this.morphTarget = targetName;
    }

    public String getMorphTarget() {
        return morphTarget;
    }
}
