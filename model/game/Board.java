package model.game;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.Position;
import model.tiles.Tile;

public class Board {
    private Map<Position, Tile> board;
    private final int width;

    public Board(List<Tile> tiles, int width){
        this.width = width;
        this.board = new TreeMap<>();
        for(Tile t : tiles) {
            if (t.getPosition() == null) {
                System.out.println("null position" + t.getClass());
            }
                
            else
                board.put(t.getPosition(), t);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Position, Tile> entry : board.entrySet()){
            sb.append(entry.getValue().view());
            if(entry.getKey().getX() == width-1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
