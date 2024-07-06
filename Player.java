public abstract class Player extends Unit {
    protected int experience;
    protected int level;
    protected char character = '@';

    public Player(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
        experience = 0;
        level = 1;
    }

    public void levelUp() {
        level++;
        experience = 0;
        hp.increaseMax(10 * level);
        hp.heal();
        ap += 4 * level;
        dp += 1 * level;
    }
}
