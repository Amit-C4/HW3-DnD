public abstract class Player extends Unit {
    protected int experience;
    protected int level;
    protected char character = '@';

    public Player(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
        experience = 0;
        level = 1;
    }
}
