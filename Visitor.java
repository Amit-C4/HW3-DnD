import Units.Enemy;
import Units.Player;

public interface Visitor {
    void visit(Player player);
    void visit(Enemy enemy);
}
