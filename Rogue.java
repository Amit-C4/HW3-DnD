public class Rogue extends Player {
    private Energy energy;
    private int energyCost;

    public Rogue(String name, int health, int attack, int defense, int energyCost) {
        super(name, health, attack, defense);
        this.energy = new Energy();
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

    @Override
    public char getCharacter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCharacter'");
    }

    @Override
    public Vector2 getPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }
}
