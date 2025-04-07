public class Triangle extends Shape {
    private Coordinates vertex2;
    private Coordinates vertex3;

    public Triangle(Coordinates vertex1, Coordinates vertex2, Coordinates vertex3) {
        super(vertex1, 3);
        if (isSamePoint(vertex1, vertex2) || isSamePoint(vertex1, vertex3) || isSamePoint(vertex2, vertex3))
            throw new IllegalArgumentException("Vertices must be distinct.");
        if (calculateArea(vertex1, vertex2, vertex3) == 0)
            throw new IllegalArgumentException("Vertices must not be collinear.");
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    private boolean isSamePoint(Coordinates a, Coordinates b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

    private double calculateArea(Coordinates a, Coordinates b, Coordinates c) {
        return 0.5 * Math.abs(a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY()));
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive.");
        int dx2 = vertex2.getX() - position.getX();
        int dy2 = vertex2.getY() - position.getY();
        int dx3 = vertex3.getX() - position.getX();
        int dy3 = vertex3.getY() - position.getY();
        if (sign) {
            vertex2 = new Coordinates(position.getX() + dx2 * factor, position.getY() + dy2 * factor);
            vertex3 = new Coordinates(position.getX() + dx3 * factor, position.getY() + dy3 * factor);
        } else {
            vertex2 = new Coordinates(position.getX() + dx2 / factor, position.getY() + dy2 / factor);
            vertex3 = new Coordinates(position.getX() + dx3 / factor, position.getY() + dy3 / factor);
        }
    }

    @Override
    public double getArea() {
        double a = position.distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(position);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return position.distance(vertex2) + vertex2.distance(vertex3) + vertex3.distance(position);
    }

    @Override
    public void display() {
        System.out.println("Triangle: Vertex1 (" + position.getX() + ", " + position.getY() +
                "), Vertex2 (" + vertex2.getX() + ", " + vertex2.getY() +
                "), Vertex3 (" + vertex3.getX() + ", " + vertex3.getY() + ")");
    }
}