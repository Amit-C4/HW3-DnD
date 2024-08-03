package model.tiles.Units.players.Classes;

import utils.Callbacks.MSG_Callback;
import model.tiles.Units.players.Player;
import model.game.Board;

public class Warrior extends Player {
    private int cooldown;
    private int currCooldown;

    public Warrior(int playerID, String name, int health, int attack, int defense, int cooldown, MSG_Callback m) {
        super(playerID, name, health, attack, defense, m);
        this.cooldown = cooldown;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        currCooldown = 0;
    }

    @Override
    public int attack() {
        return super.attack() + 2 * level;
    }

    @Override
    public int healthGain() {
        return super.healthGain() + 5 * level;
    }

    @Override
    public int defenseGain() {
        return super.defenseGain() + 1 * level;
    }


    @Override
    public String toString() {
        return super.toString() + "    Cooldown: " + currCooldown + "/" + cooldown;
    }

    public void castAbility() {
        
    }

    @Override
    public void onTick(Board board){
        if(currCooldown > 0){
            currCooldown--;
        }
    }
}
