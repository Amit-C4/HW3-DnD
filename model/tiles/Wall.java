package model.tiles;

import model.tiles.Units.Unit;

public class Wall extends Tile {
    private static final char WALL_TILE = '#';

    public Wall() {
        super(WALL_TILE);
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }
}
