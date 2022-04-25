import javax.smartcardio.Card;

public abstract class SpellCard extends Card {
    private int mana;
    private int duration;
    private int exp;
    private String imagepath;

    SpellCard(String name, String type, String description, int mana, int duration, int exp, String imagepath) {
        super(name, type, description);
        this.mana = mana;
        this.duration = duration;
        this.exp = exp;
        this.imagepath = imagepath;
    }
    
    abstract void execute(SummonedCard s);

    abstract void activate(SummonedCard targetCard);

    public SpellCard(String name, String type, String description, int mana, int durasi, int exp, String imagepath) {
        super(name, type, description);
        this.mana = mana;
        this.durasi = durasi;
        this.exp = exp;
        this.imagepath = imagepath;
    }

    public String getSpellMana() {
        return mana;
    }

    public void setSpellMana(int mana) {
        this.mana = mana;
    }

    public String getSpellDuration() {
        return duration;
    }

    public void setSpellduration(int duration) {
        this.duration = duration;
    }

    public String getEXP() {
        return exp;
    }

    public void setEXP(int exp) {
        this.exp = exp;
    }

    public String getImagePath() {
        return imagepath;
    }

    public void setImagePath(String imagepath) {
        this.imagepath = imagepath;
    }
}