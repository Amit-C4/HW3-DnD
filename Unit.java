public abstract class Unit implements Tile {
    protected String name;
    protected Health hp;
    protected int ap;
    protected int dp;

    public Unit(String name, int health, int attack, int defense) {
        this.name = name;
        this.hp = new Health(health);
        this.ap = attack;
        this.dp = defense;
    }

    public abstract void attack(Unit unit);
    public abstract void move(String key);
    public abstract void onTick();
    public abstract void display(String message);
}
