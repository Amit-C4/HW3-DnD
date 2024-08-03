package model.tiles.Units.players.Classes;
import utils.Callbacks.MSG_Callback;
import model.tiles.Units.players.Player;
import model.game.Board;

public class Mage extends Player {
    private static final int MANA_POOL_GAIN = 25;
    private static final int SPELL_POWER_GAIN = 10;

    private int manaPool;
    private int mana;
    private int manaCost;
    private int spellPower;
    private int hitCount;
    private int range;

    public Mage(int playerid, String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitCount, int range, MSG_Callback m) {
        super(playerid,name, health, attack, defense, m);
        this.manaPool = manaPool;
        this.mana = manaPool;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitCount = hitCount;
        this.range = range;
    }

    public void levelUp() {
        super.levelUp();
        manaPool += mana_pool_gain();
        mana = Math.min(manaPool, mana + manaPool/4);
        spellPower += spell_power_gain();
    }

    private int mana_pool_gain() {
        return MANA_POOL_GAIN * level;
    }

    private int spell_power_gain() {
        return SPELL_POWER_GAIN * level;
    }

    @Override
    public String toString() {
        return super.toString() + "    Mana: " + mana + "/" + manaPool + "    Spell Power: " + spellPower;
    }

    public void castAbility() {
        
    }

    @Override
    public void onTick(Board board) {
        mana = Math.min(manaPool, mana + level);
    }
}
