public class Trap extends Enemy {
    private Visibility visibility;

    public Trap(String name, int health, int attack, int defense, int xp, int visibility, int invisibility) {
        super(name, health, attack, defense, xp);
        this.visibility = new Visibility(visibility, invisibility);
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
