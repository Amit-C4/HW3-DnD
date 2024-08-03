package model.tiles.Units.Enemies;

import utils.Callbacks.MSG_Callback;

import model.tiles.Units.HeroicUnit;

public class Boss extends Monster implements HeroicUnit {
    private int abilityFrequency;
    private int combatTicks;

    public Boss(char symbol, String name, int health, int attack, int defense, int visionRange, int xp, int abilityFrequency, MSG_Callback m) {
        super(symbol,name, health, attack, defense, visionRange, xp, m);
        this.abilityFrequency = abilityFrequency;
        this.combatTicks = 0;
    }

    public void castAbility() {
        
    }
}
