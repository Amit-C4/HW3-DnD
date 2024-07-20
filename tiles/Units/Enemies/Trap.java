package tiles.Units.Enemies;
import Helpers.Visibility;

public class Trap extends Enemy {
    private Visibility visibility;

    public Trap(char symbol, String name, int health, int attack, int defense, int xp, int visibility, int invisibility) {
        super(symbol, name, health, attack, defense, xp);
        this.visibility = new Visibility(visibility, invisibility);
    }

    
 
    public char getCharacter() {
        return this.character;
    }
}
