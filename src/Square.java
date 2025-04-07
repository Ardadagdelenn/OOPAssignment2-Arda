public class Square extends Shape {
    private double side;

    public Square(Coordinates position, double side) {
        super(position, 4);
        if (side <= 0) throw new IllegalArgumentException("Side must be positive.");
        this.side = side;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive.");
        side = sign ? side * factor : side / factor;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public void display() {
        System.out.println("Square: Corner (" + position.getX() + ", " + position.getY() + "), Side: " + side);
    }
}