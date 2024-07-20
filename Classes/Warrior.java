package Classes;

import tiles.Units.Players.Player;

public class Warrior extends Player {
    private int cooldown;
    private int currCooldown;

    public Warrior(String name, int health, int attack, int defense, int cooldown) {
        super(name, health, attack, defense);
        this.cooldown = cooldown;
    }

    public void levelUp() {
        super.levelUp();
        currCooldown = 0;
        att += 2 * level;
        dp += 1 * level;
        hp.increaseMax(5 * level);
        hp.heal();
    }
}
