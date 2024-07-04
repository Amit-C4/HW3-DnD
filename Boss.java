public class Boss extends Monster {
    private int abilityFrequency;
    private int combatTicks;

    public Boss(String name, int health, int attack, int defense, int visionRange, int xp, int abilityFrequency) {
        super(name, health, attack, defense, visionRange, xp);
        this.abilityFrequency = abilityFrequency;
        this.combatTicks = 0;
    }

    @Override
    public void attack(Unit unit) {
        // Implementation
    }

    @Override
    public void move(String key) {
        // Implementation
    }

    @Override
    public void onTick() {
        // Implementation
    }

    @Override
    public void display(String message) {
        // Implementation
    }
}
