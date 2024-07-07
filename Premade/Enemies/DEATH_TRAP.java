package Premade.Enemies;
import Units.Trap;

public class DEATH_TRAP extends Trap {
    public DEATH_TRAP() {
        super("Death Trap", 500, 100, 20, 250, 1, 10);
        this.character = 'D';
    }
}
