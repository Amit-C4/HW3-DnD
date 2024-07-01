public class Wall implements Tile {
    private char character = '#';
    private Vector2 position;

    @Override
    public char getCharacter() {
        return character;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }
}
