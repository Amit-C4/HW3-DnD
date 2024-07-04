public class Rogue extends Player {
    private int cost;
    private int energy;

    public Rogue(String name, int health, int attack, int defense, int cost) {
        super(name, health, attack, defense);
        this.cost = cost;
        this.energy = 100;
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
