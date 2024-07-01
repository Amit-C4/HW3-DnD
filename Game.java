
public class Game {
    private Level level;
    private Player player;
    private CLI cli;

    public Game(int level, int player) {
        this.level = new Level(level);
        switch (player) {
            case 1:
                this.player = new JON_SNOW();
                break;

            case 2:
                this.player = new THE_HOUND();
                break;

            case 3:
                this.player = new MELISANDRE();
                break;

            case 4:
                this.player = new THOROS_OF_MYR();
                break;
            case 5:
                this.player = new ARYA_STARK();
                break;
            case 6:
                this.player = new BRONN();
                break;
            case 7:
                this.player = new YGRITTE();
                break;
            
        
            default:
                break;
        }
        this.cli = new CLI();
    }

}
