public abstract class Shape {
    protected Coordinates position;
    protected int sides;

    public Shape(Coordinates position, int sides) {
        this.position = position;
        this.sides = sides;
    }

    public Coordinates getCoordinates() { return position; }
    public int getSides() { return sides; }
    public void setCoordinates(Coordinates position) { this.position = position; }

    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    public abstract void scale(int factor, boolean sign);
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void display();
}