package tiles.Units.Enemies;

import tiles.Units.Unit;

public abstract class Enemy extends Unit {
    protected int xp;
    protected char character;

    public Enemy(char symbol,String name, int health, int attack, int defense, int xp) {
        super(symbol ,name, health, attack, defense);
        this.xp = xp;
    }

    
}
