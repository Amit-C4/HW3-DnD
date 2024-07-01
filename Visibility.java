public class Visibility {
    private int visibilityTime;
    private int invisibilityTime;
    private int ticksCount;
    private boolean visible;

    public void tick() {
        visible = ticksCount < visibilityTime;
        if (ticksCount == visibilityTime + invisibilityTime) {
            ticksCount = 0;
        } else {
            ticksCount++;
            
        }
    }

    public boolean getCurrent() {
        return visible;
    }
}
