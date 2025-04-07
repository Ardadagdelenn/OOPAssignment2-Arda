public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public double distance(Coordinates p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void scale(int factor, boolean sign) {
        if (factor == 0) {
            throw new IllegalArgumentException("Scale factor must not be zero.");
        }
        if (sign) {
            x *= factor;
            y *= factor;
        } else {
            x /= factor;
            y /= factor;
        }
    }

    public void display() {
        System.out.println("Coordinates: (" + x + ", " + y + ")");
    }
}