import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeManagement management = new ShapeManagement();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Shape Management Menu ===");
            System.out.println("1. Add Shape");
            System.out.println("2. Remove Shape");
            System.out.println("3. Display Shape Info");
            System.out.println("4. Display All Shapes");
            System.out.println("5. Translate Shape");
            System.out.println("6. Scale Shape");
            System.out.println("7. Translate All Shapes");
            System.out.println("8. Scale All Shapes");
            System.out.println("9. Quit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Select shape type:");
                    System.out.println("1. Circle");
                    System.out.println("2. Square");
                    System.out.println("3. Rectangle");
                    System.out.println("4. Triangle");
                    System.out.print("Choice: ");
                    int type = scanner.nextInt();
                    Shape newShape = null;
                    try {
                        switch(type) {
                            case 1:
                                System.out.print("Enter center x: ");
                                int cx = scanner.nextInt();
                                System.out.print("Enter center y: ");
                                int cy = scanner.nextInt();
                                System.out.print("Enter radius: ");
                                double radius = scanner.nextDouble();
                                newShape = new Circle(new Coordinates(cx, cy), radius);
                                break;
                            case 2:
                                System.out.print("Enter corner x: ");
                                int sx = scanner.nextInt();
                                System.out.print("Enter corner y: ");
                                int sy = scanner.nextInt();
                                System.out.print("Enter side length: ");
                                double side = scanner.nextDouble();
                                newShape = new Square(new Coordinates(sx, sy), side);
                                break;
                            case 3:
                                System.out.print("Enter corner x: ");
                                int rx = scanner.nextInt();
                                System.out.print("Enter corner y: ");
                                int ry = scanner.nextInt();
                                System.out.print("Enter width: ");
                                double width = scanner.nextDouble();
                                System.out.print("Enter length: ");
                                double length = scanner.nextDouble();
                                newShape = new Rectangle(new Coordinates(rx, ry), width, length);
                                break;
                            case 4:
                                System.out.print("Enter vertex1 x: ");
                                int v1x = scanner.nextInt();
                                System.out.print("Enter vertex1 y: ");
                                int v1y = scanner.nextInt();
                                System.out.print("Enter vertex2 x: ");
                                int v2x = scanner.nextInt();
                                System.out.print("Enter vertex2 y: ");
                                int v2y = scanner.nextInt();
                                System.out.print("Enter vertex3 x: ");
                                int v3x = scanner.nextInt();
                                System.out.print("Enter vertex3 y: ");
                                int v3y = scanner.nextInt();
                                newShape = new Triangle(new Coordinates(v1x, v1y), new Coordinates(v2x, v2y), new Coordinates(v3x, v3y));
                                break;
                            default:
                                System.out.println("Invalid shape type.");
                                break;
                        }
                        if (newShape != null) {
                            management.addShape(newShape);
                        }
                    } catch(Exception e) {
                        System.out.println("Error adding shape: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter shape index to remove: ");
                    int removeIndex = scanner.nextInt();
                    management.removeShape(removeIndex);
                    break;
                case 3:
                    System.out.print("Enter shape index to display info: ");
                    int infoIndex = scanner.nextInt();
                    management.displayShapeInfo(infoIndex);
                    break;
                case 4:
                    management.displayShapes();
                    break;
                case 5:
                    System.out.print("Enter shape index to translate: ");
                    int transIndex = scanner.nextInt();
                    System.out.print("Enter dx: ");
                    int dx = scanner.nextInt();
                    System.out.print("Enter dy: ");
                    int dy = scanner.nextInt();
                    management.translateShape(transIndex, dx, dy);
                    break;
                case 6:
                    System.out.print("Enter shape index to scale: ");
                    int scaleIndex = scanner.nextInt();
                    System.out.print("Enter scale factor: ");
                    int scaleFactor = scanner.nextInt();
                    System.out.print("Scale up? (true/false): ");
                    boolean sign = scanner.nextBoolean();
                    management.scaleShape(scaleIndex, scaleFactor, sign);
                    break;
                case 7:
                    System.out.print("Enter dx: ");
                    int allDx = scanner.nextInt();
                    System.out.print("Enter dy: ");
                    int allDy = scanner.nextInt();
                    management.translateAllShapes(allDx, allDy);
                    break;
                case 8:
                    System.out.print("Enter scale factor: ");
                    int allScaleFactor = scanner.nextInt();
                    System.out.print("Scale up? (true/false): ");
                    boolean allSign = scanner.nextBoolean();
                    management.scaleAllShapes(allScaleFactor, allSign);
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Exiting Shape Management. Goodbye!");
    }
}