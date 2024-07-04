public class Warrior extends Player {
    private int cooldown;

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
}
