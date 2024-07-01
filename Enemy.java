public abstract class Enemy extends Unit {
    protected int xp;

    @Override
    public abstract void attack(Unit unit);

    @Override
    public abstract void move(String key);

    @Override
    public abstract void onTick();

    @Override
    public abstract void display(String message);
}
