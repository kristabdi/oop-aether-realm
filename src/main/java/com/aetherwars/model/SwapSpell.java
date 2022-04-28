package com.aetherwars.model;
public class SwapSpell extends SpellCard implements Spell {
    public SwapSpell(String name, String type, String description, int mana, int durasi, int exp, String imagepath) {
        super(name, type, description, mana, durasi, exp, imagepath);
    }

    public void execute(CharacterCard card){
        System.out.println("EXECUTE SWAP SPELL TERHADAP CARD");
        System.out.println(card);
        // Cek apakah card sudah punya SwapSpell
        boolean found = false;
        int i = 0;
        while (i < card.getActiveSpells().size() && !found){
            if (card.getActiveSpells().get(i).getClass().getSimpleName() == "SwapSpell"){
                // Jika sudah punya SwapSpell, maka akan menambah durasi dengan this.getSpellDuration
                int durasiAwal = card.getActiveSpells().get(i).getSpellDuration();
                card.getActiveSpells().get(i).setSpellDuration(durasiAwal + this.getSpellDuration());
                // System.out.println("Durasi: " + card.getActiveSpells().get(i).getSpellDuration());
                // System.out.println("Durasi this: " + this.getSpellDuration());
                found = true;
            }
        }
        // Kalo tidak found baru add dan swap hp dan atk
        if (!found){
            card.getActiveSpells().add(this);
            int health = card.getHealth();
            int attack = card.getAttack();
            // swap health dan attack
            card.setHealth(attack);
            card.setAttack(health);

        }
    }
    
}
