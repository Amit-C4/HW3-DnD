import java.util.Hashtable;

public abstract class Player extends Unit {
    protected int experience;
    protected int level;

    public Player(String name, int health, int attack, int defense) {
        this.name = name;
        this.hp = new Health(health);
        this.ap = attack;
        this.dp = defense;
        this.experience = 0;
        this.level = 1;
    }

}
