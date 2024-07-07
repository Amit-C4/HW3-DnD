package Units;
public abstract class Enemy extends Unit {
    protected int xp;
    protected char character;

    public Enemy(String name, int health, int attack, int defense, int xp) {
        super(name, health, attack, defense);
        this.xp = xp;
    }

    @Override
    public abstract void attack(Unit unit);

    @Override
    public abstract void move(String key);

    @Override
    public abstract void onTick();

    @Override
    public abstract void display(String message);
}
