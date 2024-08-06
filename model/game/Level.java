package model.game;


import utils.Callbacks.MSG_Callback;
import model.tiles.Units.Enemies.Enemy;
import model.tiles.Units.players.Player;
import control.InputController;
import control.init.LevelInitializor;
import utils.BoardHelper;


public class Level {
    private final String[] paths = {
        "levels_dir\\level1.txt",
        "levels_dir\\level2.txt",
        "levels_dir\\level3.txt",
        "levels_dir\\level4.txt"
    };
    private String path;
    private Board board;
    private InputController inputController;
    private MSG_Callback msg_Callback; 

    public Level(int level, Player player, MSG_Callback msg_Callback) {
        this.path = paths[level-1];
        BoardHelper boardHelper = new BoardHelper();
        LevelInitializor levelInit = new LevelInitializor(msg_Callback);
        
        this.board = new Board(levelInit.initLevel(path, player,  boardHelper), levelInit.getWidth(),levelInit.getEnemies(), player);
        this.msg_Callback = msg_Callback;
        boardHelper.setBoard(board);
        this.inputController = new InputController(msg_Callback);
    }

    public void startLevel() {
        msg_Callback.send(board.toString());

        while (board.getPlayer().isAlive() && board.getEnemies().size() > 0) {
            Tick();
            msg_Callback.send(board.toString());
        }
        if (!(board.getPlayer().isAlive())) {
            msg_Callback.send(board.getPlayer().toString());
            msg_Callback.send("Game Over");
        } else {
            msg_Callback.send("You won!");
        }
    }

    

    private void Tick() {
        Player player = board.getPlayer();
        msg_Callback.send(board.getPlayer().toString());
        player.onTick(inputController.getAction());
        for (Enemy enemy : board.getEnemies()) {
            enemy.onTick();
        }
    }

    
}