// public static int MAX_LEVEL = 10

public class Card {
    private String nama;
    private String description;
    private String type; //character atau spell
    private cardOnHover(GameWindow gameWindow){
        //menampilkan deskripsi card ke gameWindow
    }
}

public class CharacterCard extends Card{
    // basic
    private int attack;
    private int health;
    private int exp;
    private int level;
    private int maxExp;

    private boolean isSwapActive;
    private int swapDuration;

    // buat priorityQueue of Tupple of Buff
    // buff berisi, duration, hp, attack
    private PriorityQueue<Tupple<Integer, Integer, Integer>> buffPriorityQueue;

    public int getFinalAttack(){
        // integer finalAttack =  attackku berdasarkan attack asli + buff, 

    }
    public int getFinalHealth(){
        // integer finalHealth = healthku berdasarkan health asli + buff, 
    }
    public void attack(CharacterCard victim){
        // trus kurangin health dari victim sebanyak finalAttack
    }

    public void reduceHealth(int damage){
        // reduce buff dulu, baru recude health asli.
    }
    public boolean isDead(){
        // jika healthnya 0, maka dead
    }

}


public class SpellCard extends Card{
    private int mana;
    private int durasi;
    private int Exp;

    abstract public void activate(CharacterCard targetCard);
}

public class SpellCardPTN extends SpellCard{
    public int healthAdded; // dan teman2nya
    public void activate(CharacterCard targetCard); //buff
}


public class SpellCardLVL extends SpellCard{

}


public class SpellCardSWAP extends SpellCard{
    
}


public class SpellCardMORPH extends SpellCard{
    private CharacterCard morphedInto;
    public void activate(CharacterCard targetCard); //morph
}