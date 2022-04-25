public class PotionSpell extends SpellCard implements Spell {
    private int attackModifier;
    private int healthModifier;
    private int remainingAttack;
    private int remainingHealth;

    public PotionSpell(String name, String type, String description, int mana, int durasi, int exp, String imagepath, int attackModifier, int healthModifier) {
        super(name, type, description, mana, durasi, exp, imagepath);
        this.attackModifier = attackModifier;
        this.healthModifier = healthModifier;
        this.remainingAttack = attackModifier;
        this.remainingHealth = healthModifier;
    }

    public void decreaseRemainingHealth(int decrease) {
        this.remainingHealth -= decrease;
    }

    public void execute(CharacterCard s){
        s.getActiveSpells().add(this);        
        // Nanti akan menambah attackFromSpell dan healthFromSpell
        // Ketika di attack, maka akan mengurangi remaining Health terlebih dahulu
        // Ketika durasi habis, maka akan mengurangi attackFromSpell dan healthFromSpell
    }
}
