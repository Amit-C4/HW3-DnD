public class Mage extends Player {
    private int mana;
    private int manaCost;
    private int spellPower;
    private int hitCount;
    private int range;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitCount, int range) {
        super(name, health, attack, defense);
        this.mana = manaPool;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
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
    
    public char getCharacter() {
        return this.character;
    }
}
