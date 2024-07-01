public class Quiver {
    private int currentArrows;
    private int maxArrows;

    public Quiver(int i) {
        this.maxArrows = i * 10;
        this.currentArrows = this.maxArrows;
    }

    public void addArrows() {
        this.currentArrows = this.maxArrows;
    }

    public void addArrows(int amount) {
        this.currentArrows = Math.min(this.currentArrows + amount, this.maxArrows);
    }

    public int getCurrent() {
        return this.currentArrows;
    }

    public void useArrows(int amount) {
        this.currentArrows = Math.max(this.currentArrows - amount, 0);
    }
}
