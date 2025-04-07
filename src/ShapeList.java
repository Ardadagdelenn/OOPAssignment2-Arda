import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> shapes;

    public ShapeList() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(int index) {
        if (index < 0 || index >= shapes.size())
            throw new IndexOutOfBoundsException("Invalid index");
        shapes.remove(index);
    }

    public Shape getShape(int index) {
        if (index < 0 || index >= shapes.size())
            throw new IndexOutOfBoundsException("Invalid index");
        return shapes.get(index);
    }

    public void translateAll(int dx, int dy) {
        for (Shape shape : shapes) {
            shape.translate(dx, dy);
        }
    }

    public void scaleAll(int factor, boolean sign) {
        for (Shape shape : shapes) {
            shape.scale(factor, sign);
        }
    }

    public void displayAll() {
        for (Shape shape : shapes) {
            shape.display();
        }
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}