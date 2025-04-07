public class Circle extends Shape {
    private double radius;

    public Circle(Coordinates position, double radius) {
        super(position, 0);
        if (radius <= 0) throw new IllegalArgumentException("Radius must be positive.");
        this.radius = radius;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive.");
        radius = sign ? radius * factor : radius / factor;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void display() {
        System.out.println("Circle: Center (" + position.getX() + ", " + position.getY() + "), Radius: " + radius);
    }
}