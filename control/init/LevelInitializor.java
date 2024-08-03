package control.init;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

import java.util.HashSet;

import utils.Position;
import utils.Callbacks.MSG_Callback;
import model.tiles.Tile;
import model.tiles.Units.Enemies.Enemy;
import model.tiles.Units.players.Player;



public class LevelInitializor {
    private HashSet<Enemy> enemies;
    private int width;

    private TileFactory tf;

    public LevelInitializor( MSG_Callback msg_callback){
        this.enemies = new HashSet<Enemy>();
        this.tf = TileFactory.getInstance(msg_callback);
    }
    
    public HashSet<Enemy> getEnemies(){
        return this.enemies;
    }

    public int getWidth(){
        return this.width;
    }


    public Player getPlayer(){
        return tf.producePlayer();
    }

    public List<Tile> initLevel(String levelPath, Player player){
        List<String> lines;
        List<Tile> tiles = new ArrayList<Tile>();
        try {
            lines = Files.readAllLines(Paths.get(levelPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.width = lines.get(0).length();

        int y = 0;
        for(String line : lines){
            int x = 0;
            for(char c : line.toCharArray()){
                switch(c) {
                    case '.':
                        Tile emptyTile = tf.produceEmpty(new Position(x, y));
                        tiles.add(emptyTile);
                        break;
                    case '#':
                        Tile wallTile = tf.produceWall(new Position(x, y));
                        tiles.add(wallTile);
                        break;
                    case '@':
                        player.setPosition(new Position(x, y));
                        tiles.add(player);
                        break;
                    default:
                        Enemy enemyTile = tf.produceEnemy(c, new Position(x, y));
                        tiles.add(enemyTile);
                        enemies.add(enemyTile);
                        break;
                }
                x++;
            }
            y++;
        }
        return tiles;
    }
}
