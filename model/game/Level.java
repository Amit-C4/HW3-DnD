package model.game;

import java.util.Set;

import utils.Callbacks.MSG_Callback;
import model.tiles.Units.Enemies.Enemy;
import model.tiles.Units.players.Player;
import control.InputType;
import control.InputController;
import control.init.LevelInitializor;


public class Level {
    private Player player;
    private final String[] paths = {
        "levels_dir\\level1.txt",
        "levels_dir\\level2.txt",
        "levels_dir\\level3.txt",
        "levels_dir\\level4.txt"
    };
    private String path;
    private Board board;
    private Set<Enemy> enemies;
    private InputController inputController;

    private MSG_Callback msg_Callback; 

    public Level(int level, Player player, MSG_Callback msg_Callback) {
        this.player = player;
        this.path = paths[level-1];
        LevelInitializor levelInit = new LevelInitializor(msg_Callback);
        this.enemies = levelInit.getEnemies();
        this.board = new Board(levelInit.initLevel(path, player), levelInit.getWidth());
        this.msg_Callback = msg_Callback;
        this.inputController = InputController.getInstance(msg_Callback);
    }

    public void startLevel() {
        msg_Callback.send(board.toString());

        while (player.isAlive() && enemies.size() > 0) {
            Tick();
            msg_Callback.send(board.toString());
        }
    }

    public void removeEnemy (Enemy enemy) {
        enemies.remove(enemy);
    }

    private void Tick() {
        InputType action = inputController.getAction();
        switch (action) {
            case UP:
                player.moveUp(board);
                break;

            case DOWN:
                player.moveDown(board);
                break;
            
            case LEFT:
                player.moveLeft(board);
                break;

            case RIGHT:
                player.moveRight(board);
                break;
            
            case ABILITY:
                player.castAbility();
                break;
            
            case NOTHING:
                break;
        
            default:
                msg_Callback.send("Invalid input");
                action = inputController.getAltAction();
                break;
        }

    }

    
}