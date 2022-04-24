import java.util.ArrayList;
import java.util.List;

public class Card {
    private String nama;
    private String description;
    private String type; //character atau spell

    Card(String name, String type, String description) {
        this.nama = name;
        this.type = type;
        this.description = description;
    };

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
    }
    // private cardOnHover(GameWindow gameWindow){
    //     //menampilkan deskripsi card ke gameWindow
    // }
}

public class CharacterCard extends Card {
    private int attack;
    private int health;
    private int healthUp;
    private int attackUp;
    private int exp;
    private int level;
    private int maxExp;
    private String imgPath;
    private Type attribute;
    private List<SpellCard> activeSpells;

    // private boolean isSwapActive;
    // private int swapDuration;

    CharacterCard(String name, Type attribute, String description, String imgPath, int attack, int health, int mana, int attackUp, int healthUp) {
        super(name, "Character", description);
        this.attribute = attribute;
        this.imgPath = imgPath;
        this.attack = attack;
        this.health = health;
        this.mana = mana;
        this.healthUp = healthUp;
        this.attackUp = attackUp;
        this.exp = 0;
        this.level = 1;
        this.maxExp = 1;
        this.activeSpells = new ArrayList<>();
    }

    // Getter

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getHealthUp() {
        return healthUp;
    }

    public int getAttackUp() {
        return attackUp;
    }

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Type getAttribute() {
        return attribute;
    }

    public List<SpellCard> getActiveSpells() {
        return this.activeSpells;
    }

    public void addSpell(Spell s) {
        this.activeSpells.add(s);
    }

    public void addExp(int n) {
        this.exp += n;
        if (this.exp > this.maxExp) {
            levelUp();
        }
    }

    public void levelUp() {
        int temp = this.getExp();
        int batasExp = 1;
        for (int i = this.getLevel(); i <= 10; i++) {
            if (i != 1) {
                batasExp = 2 * this.getLevel() - 1; 
            }

            if (temp >= batasExp) {
                temp -= batasExp;
            }

            if (temp < batasExp) {
                this.level = i;
                this.maxExp = 2 * this.getLevel() - 1;
            }
        }

        this.exp = temp;
        int attack = this.attack + (this.getLevel() - 1) * this.attackUp;
        int health = this.health + (this.getLevel() - 1) * this.healthUp;
    }

    public int getMultiplierAttack(CharacterCard victim) {
        int vic = victim.getAttribute().ordinal();
        int attacker = this.getAttribute().ordinal();
        if (attacker == vic) return 1;

        if (attacker == 0) {
            if (vic == 1) {
                return 2;
            }
            return 0.5;
        } else if (attacker == 1) {
            if (vic == 2) {
                return 2;
            }
            return 0.5;
        } else {
            if (vic == 0) {
                return 2;
            }
            return 0.5;
        }
    }

    public void attack(CharacterCard victim) {
        // trus kurangin health dari victim sebanyak finalAttack
        if (victim.getHealth() - getFinalAttack() <= 0) {
            // Karakter musuh mati, dapat EXp
            victim.setHealth(0);
            addExp(victim.getLevel());
        } else {
            victim.setHealth(victim.getHealth() - getFinalAttack());
        }
    }

    public void attackPlayer(Player player) {
        //  Jika tidak ada karakter di board lawan
    }

    public int getFinalAttack() {
        // integer finalAttack =  attackku berdasarkan attack asli + buff, 

    }
    public int getFinalHealth() {
        // integer finalHealth = healthku berdasarkan health asli + buff, 
    }

    public void reduceHealth(int damage){
        // reduce buff dulu, baru recude health asli.
    }

    public boolean isDead() {
        return (health == 0);
    }

     // buat priorityQueue of Tupple of Buff
    // buff berisi, duration, hp, attack
    private PriorityQueue<Tupple<Integer, Integer, Integer>> buffPriorityQueue;
}