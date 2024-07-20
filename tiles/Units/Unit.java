package tiles.Units;
import tiles.Tile;
import Helpers.Health;
import Helpers.Generators.RandomGenerator;
import Helpers.Generators.Generator;
import Helpers.Position;
import Helpers.Callbacks.DEATH_Callback;
import Helpers.Callbacks.MSG_Callback;


public abstract class Unit extends Tile {
    protected String name;
    protected Health hp;
    protected int att;
    protected int dp;

    protected Generator generator = new RandomGenerator();
    protected DEATH_Callback deathCallback;
    protected MSG_Callback msgCallback;

    public Unit(char symbol, String name, int health, int attack, int defense) {
        super(symbol);
        this.name = name;
        this.hp = new Health(health);
        this.att = attack;
        this.dp = defense;
    }

    public Unit init (Position position, Generator generator,  DEATH_Callback deathCallback, MSG_Callback msgCallback) {
        super.init(position);
        this.generator = generator;
        this.deathCallback = deathCallback;
        this.msgCallback = msgCallback;
        return this;
    }

    public int attack(){
        return generator.generate(att);
    }
    public int defend(){
        return generator.generate(dp);
    }

    public boolean isAlive(){
        return hp.isAlive();
    }

    public void battle(Unit enemy){
        int attack = this.attack();
        int defense = enemy.defend();
        enemy.hp.takeDamage(attack - defense);
    }

    public void onDeath(){
        deathCallback.onDeath();
    }
}
