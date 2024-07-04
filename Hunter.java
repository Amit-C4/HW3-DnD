public class Hunter extends Player {
    private int arrows;
    private int range;

    public Hunter(String name, int health, int attack, int defense, int range) {
        super(name, health, attack, defense);
        arrows = 10;
        this.range = range;
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
