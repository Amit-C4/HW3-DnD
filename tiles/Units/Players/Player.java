package tiles.Units.Players;

import tiles.Units.Unit;

public abstract class Player extends Unit {
    public static final char PLAYER_TILE = '@';
    protected static final int LEVEL_REQUIREMENT = 50;
    protected static final int HEALTH_GAIN = 10;
    protected static final int ATTACK_GAIN = 4;
    protected static final int DEFENSE_GAIN = 1;


    protected int experience;
    protected int level;
    
    public Player(String name, int health, int attack, int defense) {
        super(PLAYER_TILE,name, health, attack, defense);
        this.level = 1;
        this.experience = 0;
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
}
