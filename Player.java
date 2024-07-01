import java.util.Hashtable;

public abstract class Player extends Unit {
    protected int experience;
    protected int level;
    protected Hashtable<Input,Ability> abilities;
}
