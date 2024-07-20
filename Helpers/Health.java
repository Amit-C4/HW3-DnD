package Helpers;
public class Health {
    private int maxHP;
    private int currentHP;

    public Health(int maxHP) {
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }
    
    public void increaseMax(int amount) {
        this.maxHP += amount;
    }

    public void heal() {
        this.currentHP = this.maxHP;
    }

    public void heal(int amount) {
        this.currentHP += amount;
    }

    public void takeDamage(int amount) {
        this.currentHP -= amount;
    }

    public int getCurrent() {
        return this.currentHP;
    }

    public boolean isAlive() {
        return this.currentHP > 0;
    }
}

