public class LevelSpell extends SpellCard {
    private int levelModifier;

    LevelSpell(String name, String type, String description, int levelModifier) {
        super(name, type, description, 0, 0, 0, "");
        this.levelModifier = levelModifier;
    }
}
