package init;

import tiles.Units.Enemies.Boss;
import tiles.Units.Enemies.Enemy;
import tiles.Units.Players.Player;
import tiles.Empty;
import tiles.Units.Enemies.Monster;
import tiles.Tile;
import tiles.Units.Enemies.Trap;
import tiles.Wall;

import Classes.Warrior;
import Classes.Mage;
import Classes.Rogue;
import Classes.Hunter;

import Helpers.Position;
import Helpers.Callbacks.DEATH_Callback;
import Helpers.Callbacks.MSG_Callback;
import Helpers.Generators.Generator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class tileFactory {
    private Player p;
    private static final List<Supplier<Player>> playerTypes = Arrays.asList(
            () -> new Warrior("Jon Snow", 300, 30, 4, 3),
            () -> new Warrior("The Hound", 400, 20, 6, 5),
            () -> new Mage("Melisandre", 100, 5, 1, 300, 30, 15, 5, 6),
            () -> new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4),
            () -> new Rogue("Arya Stark", 150, 40, 2, 20),
            () -> new Rogue("Bronn", 200, 35, 3, 50),
            () -> new Hunter("Ygritte", 220, 30, 2, 6)
    );

    private static final Map<Character, Supplier<Enemy>> enemyTypes = Map.ofEntries(
            Map.entry('s', () -> new Monster('s',"Lannister Solider", 80, 8, 3, 3, 25)),
            Map.entry('k', () -> new Monster('k', "Lannister Knight", 200, 14, 8, 4, 50)),
            Map.entry('q', () -> new Monster('q', "Queen's Guard", 400, 20, 15, 5, 100)),
            Map.entry('z', () -> new Monster('z', "Wright", 600, 30, 15, 3, 100)),
            Map.entry('b', () -> new Monster('b',"Bear-Wright", 1000, 75, 30, 4, 250)),
            Map.entry('g', () -> new Monster('g',"Giant-Wright", 1500, 100, 40, 5, 500)),
            Map.entry('w', () -> new Monster('w',"White Walker", 2000, 150, 50, 6, 1000)),
            Map.entry('M', () -> new Boss('M', "The Mountain", 1000, 60, 25, 6, 500, 5)),
            Map.entry('C', () -> new Boss('C', "Queen Cersei", 100, 10, 10, 1, 1000, 8)),
            Map.entry('K', () -> new Boss('K', "Night's King", 5000, 300, 150, 8, 5000, 3)),
            Map.entry('B', () -> new Trap('B', "Bonus Trap", 1, 1, 1, 250, 1, 5)),
            Map.entry('Q', () -> new Trap('Q', "Queen's Trap", 250, 50, 10, 100, 3, 7)),
            Map.entry('D', () -> new Trap('D', "Death Trap", 500, 100, 20, 250, 1, 10))
    );
    public tileFactory(){
    }

    public Player producePlayer(int playerID){
        Supplier<Player> supp = playerTypes.get(playerID-1);
        this.p = supp.get();
        return this.p;
    }

    public Player producePlayer(){
        return this.p;
    }

    public Enemy produceEnemy(char tile, Position p, DEATH_Callback c, Generator g, MSG_Callback m){
        Enemy e = enemyTypes.get(tile).get();
        e.init(p, g, c, m);
        return e;
    }

    public Tile produceEmpty(Position p){
        return new Empty().init(p);
    }

    public Tile produceWall(Position p){
        return new Wall().init(p);
    }
}
