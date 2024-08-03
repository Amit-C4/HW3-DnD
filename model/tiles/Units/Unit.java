package model.tiles.Units;
import model.game.Board;
import utils.Health;
import utils.Position;
import utils.Callbacks.DEATH_Callback;
import utils.Callbacks.MSG_Callback;
import utils.Callbacks.TICK_Callback;
import utils.Generators.Generator;
import utils.Generators.RandomGenerator;
import model.tiles.Empty;
import model.tiles.Tile;
import model.tiles.Wall;
import model.tiles.Units.Enemies.Enemy;
import model.tiles.Units.players.Player;


public abstract class Unit extends Tile implements TICK_Callback, DEATH_Callback {
    protected String name;
    protected Health hp;
    protected int att;
    protected int dp;
    protected MSG_Callback msg;

    protected Generator generator = new RandomGenerator();
    protected DEATH_Callback deathCallback;
    protected MSG_Callback msgCallback;

    public Unit(char symbol, String name, int health, int attack, int defense, MSG_Callback m) {
        super(symbol);
        this.name = name;
        this.msg = m;
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

    public void battle(Unit enemy) {
        int attack = this.attack();
        int defense = enemy.defend();
        enemy.hp.takeDamage(attack - defense);
    }

    public void interact(Tile t){
        t.accept(this);
    }

    public void visit(Empty e){
        swapPosition(e);
    }

    public void visit(Wall w){
        // Do nothing
    }

    @Override
    public String toString() {
        return name + "    Health: " + hp.getCurrent() + "/" + hp.getMax() + "    Attack: " + att + "   Defense: " + dp;
    }

    public String getName(){
        return name;
    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);
}