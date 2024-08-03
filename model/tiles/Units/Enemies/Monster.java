package model.tiles.Units.Enemies;

import utils.Callbacks.MSG_Callback;
import model.game.Board;

public class Monster extends Enemy {
    private int visionRange;

    public Monster(char symbol, String name, int health, int attack, int defense, int visionRange, int xp, MSG_Callback m) {
        super(symbol, name, health, attack, defense, xp, m);
        this.visionRange = visionRange;
    }

    @Override
    public String toString() {
        return super.toString() + "    Vision Range: " + visionRange;
    }

    public void onTick(Board board) {
        
    }

    public void onDeath() {
        //TODO: On Death
    }
}
