package Units;
import Helpers.Position;

public class Wall implements Tile {
    private char character = '#';
    private Position position;

    
    public char getCharacter() {
        return this.character;
    }
}
