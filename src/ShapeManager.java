public class ShapeManager {
    private ShapeList shapeList;

    public ShapeManager() {
        shapeList = new ShapeList();
    }

    public void addShape(Shape shape) {
        shapeList.addShape(shape);
        System.out.println("Shape added.");
    }

    public void removeShape(int index) {
        try {
            shapeList.removeShape(index);
            System.out.println("Shape removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. No shape removed.");
        }
    }

    public void displayShapes() {
        shapeList.displayAll();
    }

    public void translateShape(int index, int dx, int dy) {
        try {
            Shape shape = shapeList.getShape(index);
            shape.translate(dx, dy);
            System.out.println("Shape translated.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. No shape translated.");
        }
    }

    public void scaleShape(int index, int factor, boolean sign) {
        try {
            Shape shape = shapeList.getShape(index);
            shape.scale(factor, sign);
            System.out.println("Shape scaled.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. No shape scaled.");
        } catch (IllegalArgumentException e) {
            System.out.println("Scaling error: " + e.getMessage());
        }
    }

    public void displayShapeInfo(int index) {
        try {
            Shape shape = shapeList.getShape(index);
            shape.display();
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. No shape info available.");
        }
    }

    public void translateAllShapes(int dx, int dy) {
        shapeList.translateAll(dx, dy);
        System.out.println("All shapes translated.");
    }

    public void scaleAllShapes(int factor, boolean sign) {
        shapeList.scaleAll(factor, sign);
        System.out.println("All shapes scaled.");
    }
}