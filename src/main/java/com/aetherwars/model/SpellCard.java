import javax.smartcardio.Card;

public abstract class SpellCard extends Card {
    private int mana;
    private int duration;
    private int exp;
    private String imagepath;
    
    abstract void execute(SummonedCard s);

    abstract void activate(SummonedCard targetCard);

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