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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Tile init(Position position) {
        this.position = position;
        return this;
    }

    public String view() {
        return String.valueOf(symbol);
    }


    public abstract void accept(Unit unit);
}
