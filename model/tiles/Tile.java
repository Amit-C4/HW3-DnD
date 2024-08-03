package model.tiles;

import utils.Position;
import model.tiles.Units.Unit;

public abstract class Tile {
    protected char symbol;
    protected Position position;

    public Tile(char symbol) {
        this.symbol = symbol;
    }

    public Tile(Position position) {
        this.position = position;
    }

    public void setPosition(Position position) {
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
        //TODO: update the position of the tile in the board
    }

    public String view() {
        return String.valueOf(symbol);
    }

    public Position getPosition() {
        return position;
    }

    public abstract void accept(Unit unit);
}
