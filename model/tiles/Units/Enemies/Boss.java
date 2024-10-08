package model.tiles.Units.Enemies;

import utils.Callbacks.MSG_Callback;
import model.tiles.Units.HeroicUnit;
import model.tiles.Units.players.Player;

public class Boss extends Monster implements HeroicUnit {
    private int abilityFrequency;
    private int combatTicks;

    public Boss(char symbol, String name, int health, int attack, int defense, int visionRange, int xp, int abilityFrequency, MSG_Callback m) {
        super(symbol,name, health, attack, defense, visionRange, xp, m);
        this.abilityFrequency = abilityFrequency;
        this.combatTicks = 0;
    }

    public void castAbility() {
        combatTicks = 0;
        Player player = helper.getPlayer();
        msg.send(name + " shoots at "+ player.getName());
        battle(player, att);

        if (!player.isAlive()){
            player.onDeath(this);
        }
    }

    public void onTick() {
        if (this.position.range(helper.getPlayerPosition()) < visionRange) {
            if (combatTicks == abilityFrequency) {
                castAbility();
            }
            else {
                combatTicks++;
                super.onTick();
            }
        }
    }
}
