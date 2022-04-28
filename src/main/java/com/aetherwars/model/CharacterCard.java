package com.aetherwars.model;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
// import com.aetherwars.model.Type;

public class CharacterCard extends Card {
    public enum Type {
        OVERWORLD, END, NETHER
    };
    private int attack;
    private int health;
    private int healthUp;
    private int attackUp;
    private int mana;
    private int exp;
    private int level;
    private int maxExp;
    private String imgPath;
    private Type attribute;
    private List<SpellCard> activeSpells;
    private int attackBuff;
    private int healthBuff;

    public CharacterCard(String name, Type attribute, String description, String imgPath, int attack, int health, int mana, int attackUp, int healthUp) {
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
        this.attackBuff = 0;
        this.healthBuff = 0;
    }

    // Getter

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealthUp() {
        return healthUp;
    }

    public void setHealthUp(int healthUp) {
        this.healthUp = healthUp;
    }

    public int getAttackUp() {
        return attackUp;
    }

    public void setAttackUp(int attackUp) {
        this.attackUp = attackUp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Type getAttribute() {
        return attribute;
    }

    public void setAttribute(Type attribute) {
        this.attribute = attribute;
    }

    public int getMana() {
        return mana;
    }
    
    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public void updateSpellsEndDuration() {
        for (int i = 0; i < activeSpells.size(); i++) {
            int duration = activeSpells.get(i).getSpellDuration();
            if (duration == 1) {
                activeSpells.remove(i);
            } else if (activeSpells.get(i).getSpellDuration() > 1) {
                activeSpells.get(i).setSpellDuration(duration - 1);
            }
        }
    }

    public List<SpellCard> getActiveSpells() {
        return this.activeSpells;
    }

    public void setActiveSpells(List<SpellCard> activeSpells) {
        this.activeSpells = activeSpells;
    }

    public Boolean isHaveSpell() {
        return this.getActiveSpells().size() > 0;
    }

    public void addSpell(SpellCard s) {
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
        this.attack = this.attack + (this.getLevel() - 1) * this.attackUp;
        this.health = this.health + (this.getLevel() - 1) * this.healthUp;
    }

    public double getMultiplierAttack(CharacterCard victim) {
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
    
    public void decreaseHealth(int attackReceived){
        // Alurnya, mengurangi remaining Health di potion spell, baru mengurangi health asli si character card
        // Cek dulu apakah activeSpells > 0
        if (this.getActiveSpells().size() > 0) {
            // Iterasi satu-satu cek apakah dia Potion Spell
            for (int i = 0; i < this.getActiveSpells().size(); i++) {
                int healthPotion = ((PotionSpell)this.getActiveSpells().get(i)).getHealthModifier();
                if ((this.getActiveSpells().get(i) instanceof PotionSpell) && (healthPotion > 0)) {
                    // cek dulu kalo attackReceived melebihi atau sama dengan remainingHealth
                    if (attackReceived >= healthPotion) {
                        // maka attackReceived -= remainingHealth
                        attackReceived -= healthPotion;
                        // remainingHealth = 0
                        ((PotionSpell)this.getActiveSpells().get(i)).decreaseRemainingHealth(healthPotion);
                        // remove spell ini
                        this.getActiveSpells().remove(i);
                    } else {
                        // kalo kurang, maka remainingHealth = remainingHealth - attackReceived
                        ((PotionSpell)this.getActiveSpells().get(i)).decreaseRemainingHealth(attackReceived);
                        // attackReceived = 0
                        attackReceived = 0;
                    }
                }
            }
        } 
        if (attackReceived > 0) {
            // Cek apakah health character Card jadi 0
            if (this.getHealth() - attackReceived <= 0) {
                // Jika ya, maka health = 0
                this.setHealth(0);
            } else {
                // Jika tidak, maka health -= attackReceived
                this.setHealth(this.getHealth() - attackReceived);
            }
        }
    }

    public void attack(CharacterCard victim) {
        // trus kurangin health dari victim sebanyak finalAttack
        if (victim.getFinalHealth() - getFinalAttack() <= 0) {
            // Karakter musuh mati, dapat EXp
            victim.decreaseHealth(this.getFinalAttack());
            this.addExp(victim.getLevel());

            // Victim serang balik
            this.decreaseHealth(victim.getFinalAttack());
            int thisHealth = this.getFinalHealth();
            if (thisHealth <= 0) {
                victim.addExp(this.getLevel());
            }
        } else {
            victim.decreaseHealth(this.getFinalAttack());
        }
    }

    public Integer attackPlayer(Integer otherHealth) {
        Integer resOtherHealth = otherHealth - getFinalAttack();
        if (resOtherHealth >= 0) {
            return resOtherHealth;
        }
        return 0;
    }
    

    public void setAttackBuff() {
        //  iterate active spells that spell is potion, then add attack modifier sum
        int temp = 0;
        for (int i = 0; i < activeSpells.size(); i++) {
            if (activeSpells.get(i) instanceof PotionSpell) {
                temp += ((PotionSpell) activeSpells.get(i)).getAttackModifier();
            }
        }
        this.attackBuff = temp;
    }

    public void setHealthBuff() {
        int temp = 0;
        for (int i = 0; i < activeSpells.size(); i++) {
            if (activeSpells.get(i) instanceof PotionSpell) {
                temp += ((PotionSpell) activeSpells.get(i)).getHealthModifier();
            }
        }
        this.healthBuff = temp;
    }

    public int getFinalAttack() {
        return this.attack + this.attackBuff;

    }
    public int getFinalHealth() {
        return this.health + this.healthBuff;
    }

    public boolean isDead() {
        return (this.health == 0);
    }
}