public class Mage extends Player {
    private Mana mana;
    private int manaCost;
    private int spellPower;
    private int hitCount;
    private int range;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int speelPower, int hitCount, int range) {
        super(name, health, attack, defense);
        this.mana = new Mana(manaPool);
        this.manaCost = manaCost;
        this.spellPower = speelPower;
        this.hitCount = hitCount;
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
