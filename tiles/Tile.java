package tiles;

import Helpers.Position;

public abstract class Tile {
    protected char symbol;
    protected Position position;

    public Tile(char symbol) {
        this.symbol = symbol;
    }

    public Tile(Position position) {
        this.position = position;
    }

    public Tile init(Position position) {
        this.position = position;
        return this;
    }

    public void swapPosition(Tile other) {
        Position temp = this.position;
        this.position = other.position;
        other.position = temp;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    public Position getPosition() {
        return position;
    }
}
