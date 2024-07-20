package Classes;

import tiles.Units.Players.Player;

public class Mage extends Player {
    private int manaPool;
    private int mana;
    private int manaCost;
    private int spellPower;
    private int hitCount;
    private int range;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitCount, int range) {
        super(name, health, attack, defense);
        this.manaPool = manaPool;
        this.mana = manaPool;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitCount = hitCount;
        this.range = range;
    }

    public void levelUp() {
        super.levelUp();
        manaPool += 25 * level;
        mana = Math.min(manaPool, mana + manaPool/4);
        spellPower += 10 * level;
    }
}
