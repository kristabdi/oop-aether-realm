import java.lang.Math;

public class LevelSpell extends SpellCard implements Spell {
    private int levelModifier;

    LevelSpell(String name, String type, String description, int mana, int levelModifier) {
        super(name, type, description, mana, 0, "");
        this.levelModifier = levelModifier;
    }

    public void execute(CharacterCard s) {
        this.mana = Math.ceil(s.getLevel()/2);
        int newLevel = s.getLevel() + this.levelModifier;
        if (newLevel >= 1) {
            s.setLevel(newLevel);
            s.setExp(0);
        }
    }
}
