package tiles.Units.Enemies;
public class Boss extends Monster {
    private int abilityFrequency;
    private int combatTicks;

    public Boss(char symbol, String name, int health, int attack, int defense, int visionRange, int xp, int abilityFrequency) {
        super(symbol,name, health, attack, defense, visionRange, xp);
        this.abilityFrequency = abilityFrequency;
        this.combatTicks = 0;
    }

}
