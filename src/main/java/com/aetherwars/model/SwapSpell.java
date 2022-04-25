public class SwapSpell extends SpellCard implements Spell {
    public SwapSpell(String name, String type, String description, int mana, int durasi, int exp, String imagepath) {
        super(name, type, description, mana, durasi, exp, imagepath);
    }

    public void execute(CharacterCard card){
        // Cek apakah card sudah punya SwapSpell
        bool found = false;
        int i = 0;
        while (i < card.getActiveSpells.size() && !found){
        // for (int i =0; i < card.getActiveSpells().size(); i++){
            if (card.getActiveSpells().get(i).getClass().getSimpleName() == "SwapSpell"){
                // Jika sudah punya SwapSpell, maka akan menambah durasi dengan this.getSpellDuration
                int durasiAwal = card.getActiveSpells().get(i).getSpellDuration();
                card.getActiveSpells().get(i).setSpellduration(durasiAwal + this.getSpellDuration());
                found = true;
            }
        }
        // Kalo tidak found baru add dan swap hp dan atk
        if (!found){
            card.getActiveSpells().add(this);
            int health = card.getHealth();
            int attack = card.getAttack();

            
        }
    }
}
