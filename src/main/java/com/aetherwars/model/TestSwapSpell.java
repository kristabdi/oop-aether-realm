// import com.aetherwars.model.*;

public class TestSwapSpell {
    public static void main(String[] args) {
        CharacterCard charCard = new CharacterCard("Sheep", CharacterCard.Type.OVERWORLD, "Deskripsi", "imgPath", 10, 5, 1, 1, 1);
        SpellCard  spellCard = new SwapSpell("Swap", "Spell", "Deskripsi", 1, 1, 1, "imgPath");
        System.out.println("Health Sebelum: " + charCard.getHealth());
        System.out.println("Attack Sebelum: " + charCard.getAttack());
        spellCard.execute(charCard);
        System.out.println("Health Sesudah: " + charCard.getHealth());
        System.out.println("Attack Sesudah: " + charCard.getAttack());
        System.out.println("Durasi: " + charCard.getActiveSpells().get(0).getSpellDuration());
        SpellCard newSwap = new SwapSpell("Swap", "Spell", "Deskripsi", 1, 4, 1, "imgPath");
        newSwap.execute(charCard);
        System.out.println("Health Sesudah: " + charCard.getHealth());
        System.out.println("Attack Sesudah: " + charCard.getAttack());
        System.out.println("Durasi: " + charCard.getActiveSpells().get(0).getSpellDuration());
    }
}
