package tiles.Units.Enemies;
public class Monster extends Enemy {
    private int visionRange;

    public Monster(char symbol, String name, int health, int attack, int defense, int visionRange, int xp) {
        super(symbol, name, health, attack, defense, xp);
        this.visionRange = visionRange;
    }


    
}
