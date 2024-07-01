public class Level {
    private int levelnumber;
    private Tile[][] tiles;
    private Enemy[] enemies;

    public Level(int levelnumber) {
        this.levelnumber = levelnumber;
        this.tiles = new Tile[10][10];
        this.enemies = new Enemy[5];
    }

    public int getLevel() {
        return levelnumber;
    }


}
