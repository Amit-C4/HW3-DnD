package control.init;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import utils.BoardHelper;
import utils.Position;
import utils.Callbacks.MSG_Callback;
import model.tiles.Empty;
import model.tiles.Tile;
import model.tiles.Wall;
import model.tiles.Units.Enemies.Boss;
import model.tiles.Units.Enemies.Enemy;
import model.tiles.Units.Enemies.Monster;
import model.tiles.Units.Enemies.Trap;
import model.tiles.Units.players.Player;
import model.tiles.Units.players.Classes.Hunter;
import model.tiles.Units.players.Classes.Mage;
import model.tiles.Units.players.Classes.Rogue;
import model.tiles.Units.players.Classes.Warrior;


public class TileFactory {
    private static TileFactory instance;
    public static TileFactory getInstance(MSG_Callback message){
        msg = message;
        if(instance == null){
            return new TileFactory();
        }
        return instance;
    }

    private Player player;
    private static MSG_Callback msg;
    private static final List<Supplier<Player>> playerTypes = Arrays.asList(
            () -> new Warrior(1, "Jon Snow", 300, 30, 4, 3, msg),
            () -> new Warrior(2, "The Hound", 400, 20, 6, 5, msg),
            () -> new Mage(3, "Melisandre", 100, 5, 1, 300, 30, 15, 5, 6, msg),
            () -> new Mage(4, "Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4, msg),
            () -> new Rogue(5, "Arya Stark", 150, 40, 2, 20, msg),
            () -> new Rogue(6, "Bronn", 200, 35, 3, 50, msg),
            () -> new Hunter(7, "Ygritte", 220, 30, 2, 6, msg)
    );

    private static final Map<Character, Supplier<Enemy>> enemyTypes = Map.ofEntries(
            Map.entry('s', () -> new Monster('s',"Lannister Solider", 80, 8, 3, 3, 25, msg)),
            Map.entry('k', () -> new Monster('k', "Lannister Knight", 200, 14, 8, 4, 50, msg)),
            Map.entry('q', () -> new Monster('q', "Queen's Guard", 400, 20, 15, 5, 100, msg)),
            Map.entry('z', () -> new Monster('z', "Wright", 600, 30, 15, 3, 100, msg)),
            Map.entry('b', () -> new Monster('b',"Bear-Wright", 1000, 75, 30, 4, 250, msg)),
            Map.entry('g', () -> new Monster('g',"Giant-Wright", 1500, 100, 40, 5, 500, msg)),
            Map.entry('w', () -> new Monster('w',"White Walker", 2000, 150, 50, 6, 1000, msg)),
            Map.entry('M', () -> new Boss('M', "The Mountain", 1000, 60, 25, 6, 500, 5, msg)),
            Map.entry('C', () -> new Boss('C', "Queen Cersei", 100, 10, 10, 1, 1000, 8, msg)),
            Map.entry('K', () -> new Boss('K', "Night's King", 5000, 300, 150, 8, 5000, 3, msg)),
            Map.entry('B', () -> new Trap('B', "Bonus Trap", 1, 1, 1, 250, 1, 5, msg)),
            Map.entry('Q', () -> new Trap('Q', "Queen's Trap", 250, 50, 10, 100, 3, 7, msg)),
            Map.entry('D', () -> new Trap('D', "Death Trap", 500, 100, 20, 250, 1, 10, msg))
    );
    private TileFactory() {
        // Do nothing
    }

    public Player producePlayer(int playerID, Position p){
        Supplier<Player> supp = playerTypes.get(playerID-1);
        this.player = supp.get();
        this.player.setPosition(p);
        return this.player;
    }

    public Player producePlayer(){
        return this.player;
    }

    public Enemy produceEnemy(char tile, Position p, BoardHelper helper){
        Enemy e = enemyTypes.get(tile).get();
        e.init(p, helper);
        return e;
    }

    public Tile produceEmpty(Position p){
        return new Empty().init(p);
    }

    public Tile produceWall(Position p){
        return new Wall().init(p);
    }
}
