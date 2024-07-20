package Classes;

import tiles.Units.Players.Player;

public class Rogue extends Player {
    private int cost;
    private int energy;

    public Rogue(String name, int health, int attack, int defense, int cost) {
        super(name, health, attack, defense);
        this.cost = cost;
        this.energy = 100;
    }
    
    public void levelUp() {
        super.levelUp();
        att += 3 * level;
        energy = 100;
    }
}
