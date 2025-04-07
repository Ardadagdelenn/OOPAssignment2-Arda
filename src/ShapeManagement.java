public class ShapeManagement {
    private ShapeList shapeList;

    public ShapeManagement() {
        shapeList = new ShapeList();
    }

    public void addShape(Shape shape) {
        if (shape == null) {
            System.out.println("Invalid shape. Cannot add a null shape.");
            return;
        }
        shapeList.addShape(shape);
        System.out.println("Shape added.");
    }

    public void removeShape(int index) {
        if (index < 0 || index >= shapeList.getShapes().size()) {
            System.out.println("Invalid index. No shape removed.");
            return;
        }
        shapeList.removeShape(index);
        System.out.println("Shape removed.");
    }

    public void displayShapes() {
        if (shapeList.getShapes().isEmpty()) {
            System.out.println("No shapes available.");
            return;
        }
        shapeList.displayAll();
    }

    public void translateShape(int index, int dx, int dy) {
        if (index < 0 || index >= shapeList.getShapes().size()) {
            System.out.println("Invalid index. No shape translated.");
            return;
        }
        Shape shape = shapeList.getShape(index);
        shape.translate(dx, dy);
        System.out.println("Shape translated.");
    }

    public void scaleShape(int index, int factor, boolean sign) {
        if (index < 0 || index >= shapeList.getShapes().size()) {
            System.out.println("Invalid index. No shape scaled.");
            return;
        }
        if (factor <= 0) {
            System.out.println("Scale factor must be positive. No shape scaled.");
            return;
        }
        Shape shape = shapeList.getShape(index);
        try {
            shape.scale(factor, sign);
            System.out.println("Shape scaled.");
        } catch (IllegalArgumentException e) {
            System.out.println("Scaling error: " + e.getMessage());
        }
    }

    public void displayShapeInfo(int index) {
        if (index < 0 || index >= shapeList.getShapes().size()) {
            System.out.println("Invalid index. No shape info available.");
            return;
        }
        Shape shape = shapeList.getShape(index);
        shape.display();
        System.out.println("Area: " + shape.getArea());
        System.out.println("Perimeter: " + shape.getPerimeter());
    }

    public void translateAllShapes(int dx, int dy) {
        if (shapeList.getShapes().isEmpty()) {
            System.out.println("No shapes available to translate.");
            return;
        }
        shapeList.translateAll(dx, dy);
        System.out.println("All shapes translated.");
    }

    public void scaleAllShapes(int factor, boolean sign) {
        if (shapeList.getShapes().isEmpty()) {
            System.out.println("No shapes available to scale.");
            return;
        }
        if (factor <= 0) {
            System.out.println("Scale factor must be positive. No shapes scaled.");
            return;
        }
        shapeList.scaleAll(factor, sign);
        System.out.println("All shapes scaled.");
    }
}