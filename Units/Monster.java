package Units;
public class Monster extends Enemy {
    private int visionRange;

    public Monster(String name, int health, int attack, int defense, int visionRange, int xp) {
        super(name, health, attack, defense, xp);
        this.visionRange = visionRange;
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

    public char getCharacter() {
        return this.character;
    }
}
