import javax.smartcardio.Card;

public abstract class SpellCard extends Card {
    private int mana;
    private int durasi;
    private int exp;
    private String imagepath;
    // private Spell spell;
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

    public String getSpellDurasi() {
        return durasi;
    }

    public void setSpellDurasi(int durasi) {
        this.durasi = durasi;
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