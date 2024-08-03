package model.tiles.Units.players;

import model.game.Board;
import utils.Callbacks.MSG_Callback;
import model.tiles.Units.Unit;
import model.tiles.Units.Enemies.Enemy;
import model.tiles.Units.HeroicUnit;

public abstract class Player extends Unit implements HeroicUnit{
    public static final char PLAYER_TILE = '@';
    protected static final int LEVEL_REQUIREMENT = 50;
    protected static final int HEALTH_GAIN = 10;
    protected static final int ATTACK_GAIN = 4;
    protected static final int DEFENSE_GAIN = 1;


    protected int experience;
    protected int level;
    protected int playerID;
    
    public Player(int playerID, String name, int health, int attack, int defense, MSG_Callback m) {
        super(PLAYER_TILE,name, health, attack, defense, m);
        this.level = 1;
        this.experience = 0;
        this.playerID = playerID;
    }

    public void levelUp() {
        experience -= levelRequirement();
        level++;
        hp.increaseMax(healthGain());
        hp.heal(healthGain());
        att += attackGain();
        dp += defenseGain();
        
    }

    public void gainExperience(int experience) {
        this.experience += experience;
        while (this.experience >= LEVEL_REQUIREMENT) {
            levelUp();
            
        }
    }

    protected int levelRequirement() {
        return LEVEL_REQUIREMENT*level;
    }

    protected int healthGain() {
        return HEALTH_GAIN*level;
    }

    protected int attackGain() {
        return ATTACK_GAIN*level;
    }

    protected int defenseGain() {
        return DEFENSE_GAIN*level;
    }

    public int ID(){
        return playerID;
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    public void visit(Player p){
        // Do nothing
    }

    public void visit(Enemy e){
        battle(e);
        if(!e.isAlive()){
            gainExperience(e.experienceValue());
            e.onDeath();
        }
    }

    @Override
    public String toString() {
        return super.toString() + "    Level: " + level + "    Experience: " + experience + "/" + levelRequirement();
    }

    public void onDeath() {
        //TODO: Implement onDeath
    }

    public void castAbility() {
        //TODO: Implement castAbility
    }

    public void onTick(Board board){
        
    }
    
}
