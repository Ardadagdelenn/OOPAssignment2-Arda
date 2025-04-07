public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(Coordinates position, double width, double length) {
        super(position, 4);
        if (width <= 0 || length <= 0) throw new IllegalArgumentException("Width and length must be positive.");
        this.width = width;
        this.length = length;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive.");
        if (sign) {
            width *= factor;
            length *= factor;
        } else {
            width /= factor;
            length /= factor;
        }
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void display() {
        System.out.println("Rectangle: Corner (" + position.getX() + ", " + position.getY() + "), Width: " + width + ", Length: " + length);
    }
}