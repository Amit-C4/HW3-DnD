public class Vector2 {
    private int xPos;
    private int yPos;

    public int range(Vector2 vector) {
        // Implementation
        return (int) Math.sqrt(Math.pow(xPos - vector.xPos, 2) + Math.pow(yPos - vector.yPos, 2));
    }
}

