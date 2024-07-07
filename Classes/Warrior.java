package Classes;

import Units.Player;
import Units.Unit;

public class Warrior extends Player {
    private int cooldown;
    private int currCooldown;

    public Warrior(String name, int health, int attack, int defense, int cooldown) {
        super(name, health, attack, defense);
        this.cooldown = cooldown;
    }
    @Override
    public void attack(Unit unit) {
        // Implement attack logic
    }

    @Override
    public void move(String key) {
        // Implement move logic
    }

    @Override
    public void onTick() {
        // Implement onTick logic
    }

    @Override
    public void display(String message) {
        // Implement display logic
    }

    public char getCharacter() {
        return this.character;
    }

    public void levelUp() {
        super.levelUp();
        currCooldown = 0;
        ap += 2 * level;
        dp += 1 * level;
        hp.increaseMax(5 * level);
        hp.heal();
    }
}
