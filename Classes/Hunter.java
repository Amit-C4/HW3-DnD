package Classes;
import tiles.Units.Players.Player;

public class Hunter extends Player {
    private int arrows;
    private int range;

    public Hunter(String name, int health, int attack, int defense, int range) {
        super(name, health, attack, defense);
        arrows = 10;
        this.range = range;
    }

    public void levelUp() {
        super.levelUp();
        arrows += 10 * level;
        att += 2 * level;
        dp += 1 * level;
    }
}
