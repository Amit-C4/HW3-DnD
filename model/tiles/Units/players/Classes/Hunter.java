package model.tiles.Units.players.Classes;

import utils.Callbacks.MSG_Callback;
import model.tiles.Units.players.Player;
import model.tiles.Units.Enemies.Enemy;
import control.InputType;
import java.util.List;

public class Hunter extends Player {
    private static final int ARROW_GAIN = 10;
    private static final int UPDATE_FREQ = 10;
    private int arrows;
    private int range;
    private int ticks = 0;

    public Hunter(int playerID, String name, int health, int attack, int defense, int range, MSG_Callback m) {
        super(playerID, name, health, attack, defense, m);
        arrows = 10;
        this.range = range;
        this.playerID = playerID;
    }
    
    public void levelUp() {
        super.levelUp();
        arrows += arrow_gain();

        msg.send(name + " reached level" + level + ": +" + healthGain() + " HP, +" + attackGain() + " Attack, +" + defenseGain() + " Defense");
    }

    @Override
    public int attack() {
        return (super.attack() + 2) * level;
    }

    @Override
    public int defenseGain() {
        return (super.defenseGain() + 1) * level;
    }

    private int arrow_gain() {
        return ARROW_GAIN * level;
    }

    @Override
    public String toString() {
        return super.toString() + "    Arrows: " + arrows + "    Range: " + range;
    }

    public void castAbility() {
        if (arrows > 0) {
            arrows--;
            List<Enemy> enemies = helper.getEnemiesInRange(range, this.position);
            int damage = att;
            Enemy closest = enemies.get(0);
            msg.send(name + " fired an arrow at " + closest.getName());
            battle(closest, damage);

            if(!(closest.isAlive())){
                gainExperience(closest.experienceValue());
                closest.onDeath(this);
            }
        }
    }

    public void onTick(InputType input) {
        super.onTick(input);
        if (ticks == UPDATE_FREQ) {
            arrows += arrow_gain();
            ticks = 0;
        }
        else {
            ticks++;
        }
    }
}
