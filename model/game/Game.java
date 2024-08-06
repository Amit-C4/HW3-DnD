package model.game;

import utils.Callbacks.MSG_Callback;
import model.tiles.Units.players.Player;

import view.CLI;
import view.View;

import control.InputController;

public class Game {
    private MSG_Callback msg_Callback;
    private final Player player;
    private final InputController ic;

    public Game() {
        View view = new CLI();
        this.msg_Callback = view.getCallback();
        this.ic = new InputController(msg_Callback);
        this.player = ic.choosePlayer();
    }

    public void startGame(){
        for(int i = 1; i <= 4 & player.isAlive(); i++){
            Level currentLevel = new Level(i, player, msg_Callback);
            currentLevel.startLevel();
        }
    }
}