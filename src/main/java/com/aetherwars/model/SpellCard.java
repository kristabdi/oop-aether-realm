// import javax.smartcardio.Card;


public abstract class SpellCard extends Card {
    private int mana;
    private int duration;
    private String imagepath;

    SpellCard(String name, String type, String description, int mana, int duration, String imagepath) {
        super(name, type, description);
        this.mana = mana;
        this.duration = duration;
        this.imagepath = imagepath;
    }
    
    abstract void execute(CharacterCard s);

    // abstract void activate(CharacterCard targetCard);

    public int getSpellMana() {
        return mana;
    }

    public void setSpellMana(int mana) {
        this.mana = mana;
    }

    public int getSpellDuration() {
        return duration;
    }

    public void setSpellduration(int duration) {
        this.duration = duration;
    }

    public String getImagePath() {
        return imagepath;
    }

    public void setImagePath(String imagepath) {
        this.imagepath = imagepath;
    }
}