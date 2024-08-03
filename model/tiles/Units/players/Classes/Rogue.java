package model.tiles.Units.players.Classes;

import utils.Callbacks.MSG_Callback;
import model.tiles.Units.players.Player;
import model.game.Board;

public class Rogue extends Player {
    private static final int MAX_ENERGY = 100;
    private int cost;
    private int energy;

    public Rogue(int playerID, String name, int health, int attack, int defense, int cost, MSG_Callback m) {
        super(playerID, name, health, attack, defense, m);
        this.cost = cost;
        this.energy = 100;
    }
    
    public void levelUp() {
        super.levelUp();
        energy = MAX_ENERGY;
    }

    @Override
    public int attack() {
        return super.attack() + 3 * level;
    }

    @Override
    public String toString() {
        return super.toString() + "    Energy: " + energy + "/" + MAX_ENERGY;
    }

    public void castAbility() {

    }

    @Override
    public void onTick(Board board){
        energy = Math.min(energy + 10, MAX_ENERGY);
    }
}
