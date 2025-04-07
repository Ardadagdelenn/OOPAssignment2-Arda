import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> shapes;

    public ShapeList() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Cannot add a null shape.");
        }
        shapes.add(shape);
    }

    public void removeShape(int index) {
        if (index < 0 || index >= shapes.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        shapes.remove(index);
    }

    public Shape getShape(int index) {
        if (index < 0 || index >= shapes.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return shapes.get(index);
    }

    public void translateAll(int dx, int dy) {
        if (shapes.isEmpty()) {
            System.out.println("No shapes available to translate.");
            return;
        }
        for (Shape shape : shapes) {
            shape.translate(dx, dy);
        }
    }

    public void scaleAll(int factor, boolean sign) {
        if (shapes.isEmpty()) {
            System.out.println("No shapes available to scale.");
            return;
        }
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be positive.");
        }
        for (Shape shape : shapes) {
            shape.scale(factor, sign);
        }
    }

    public void displayAll() {
        if (shapes.isEmpty()) {
            System.out.println("No shapes available.");
            return;
        }
        for (Shape shape : shapes) {
            shape.display();
        }
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}