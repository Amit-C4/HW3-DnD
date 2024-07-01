public abstract class Ability {
    protected Enum<ClassType> Class;
    protected Enum<Input> key;

    public abstract void display(String message);
}
