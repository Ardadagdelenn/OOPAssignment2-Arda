import java.util.Scanner;
import java.util.function.DoublePredicate;

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

            int choice = getValidInt(scanner, "Select an option: ");

            switch (choice) {
                case 1:
                    System.out.println("Select shape type:");
                    System.out.println("1. Circle");
                    System.out.println("2. Square");
                    System.out.println("3. Rectangle");
                    System.out.println("4. Triangle");
                    int type = getValidInt(scanner, "Choice: ");
                    Shape newShape = null;
                    try {
                        switch (type) {
                            case 1:
                                int cx = getValidInt(scanner, "Enter center x: ");
                                int cy = getValidInt(scanner, "Enter center y: ");
                                double radius = getValidDouble(scanner, "Enter radius: ",
                                        d -> d > 0, "Radius must be positive.");
                                newShape = new Circle(new Coordinates(cx, cy), radius);
                                break;
                            case 2:
                                int sx = getValidInt(scanner, "Enter corner x: ");
                                int sy = getValidInt(scanner, "Enter corner y: ");
                                double side = getValidDouble(scanner, "Enter side length: ",
                                        d -> d > 0, "Side length must be positive.");
                                newShape = new Square(new Coordinates(sx, sy), side);
                                break;
                            case 3:
                                int rx = getValidInt(scanner, "Enter corner x: ");
                                int ry = getValidInt(scanner, "Enter corner y: ");
                                double width = getValidDouble(scanner, "Enter width: ",
                                        d -> d > 0, "Width must be positive.");
                                double length = getValidDouble(scanner, "Enter length: ",
                                        d -> d > 0, "Length must be positive.");
                                newShape = new Rectangle(new Coordinates(rx, ry), width, length);
                                break;
                            case 4:
                                int v1x = getValidInt(scanner, "Enter vertex1 x: ");
                                int v1y = getValidInt(scanner, "Enter vertex1 y: ");
                                int v2x = getValidInt(scanner, "Enter vertex2 x: ");
                                int v2y = getValidInt(scanner, "Enter vertex2 y: ");
                                int v3x = getValidInt(scanner, "Enter vertex3 x: ");
                                int v3y = getValidInt(scanner, "Enter vertex3 y: ");
                                // Extra validation: All vertices cannot share the same x or y coordinate
                                if ((v1x == v2x && v1x == v3x) || (v1y == v2y && v1y == v3y)) {
                                    System.out.println("Error: All vertices cannot have the same x or same y coordinate.");
                                    break;
                                }
                                newShape = new Triangle(
                                        new Coordinates(v1x, v1y),
                                        new Coordinates(v2x, v2y),
                                        new Coordinates(v3x, v3y)
                                );
                                break;
                            default:
                                System.out.println("Invalid shape type.");
                                break;
                        }
                        if (newShape != null) {
                            management.addShape(newShape);
                        }
                    } catch (Exception e) {
                        System.out.println("Error adding shape: " + e.getMessage());
                    }
                    break;
                case 2:
                    int removeIndex = getValidInt(scanner, "Enter shape index to remove: ");
                    management.removeShape(removeIndex);
                    break;
                case 3:
                    int infoIndex = getValidInt(scanner, "Enter shape index to display info: ");
                    management.displayShapeInfo(infoIndex);
                    break;
                case 4:
                    management.displayShapes();
                    break;
                case 5:
                    int transIndex = getValidInt(scanner, "Enter shape index to translate: ");
                    int dx = getValidInt(scanner, "Enter dx: ");
                    int dy = getValidInt(scanner, "Enter dy: ");
                    management.translateShape(transIndex, dx, dy);
                    break;
                case 6:
                    int scaleIndex = getValidInt(scanner, "Enter shape index to scale: ");
                    int scaleFactor = getValidInt(scanner, "Enter scale factor: ");
                    boolean sign = getValidBoolean(scanner, "Scale up? (true/false): ");
                    management.scaleShape(scaleIndex, scaleFactor, sign);
                    break;
                case 7:
                    int allDx = getValidInt(scanner, "Enter dx: ");
                    int allDy = getValidInt(scanner, "Enter dy: ");
                    management.translateAllShapes(allDx, allDy);
                    break;
                case 8:
                    int allScaleFactor = getValidInt(scanner, "Enter scale factor: ");
                    boolean allSign = getValidBoolean(scanner, "Scale up? (true/false): ");
                    management.scaleAllShapes(allScaleFactor, allSign);
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please select a number between 1 and 9.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Exiting Shape Management. Goodbye!");
    }

    private static int getValidInt(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // clear invalid input
            }
        }
        return value;
    }

    private static double getValidDouble(Scanner scanner, String prompt,
                                         DoublePredicate validator, String errorMsg) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                if (validator.test(value)) {
                    break;
                } else {
                    System.out.println(errorMsg);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }
        return value;
    }

    private static boolean getValidBoolean(Scanner scanner, String prompt) {
        boolean value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextBoolean()) {
                value = scanner.nextBoolean();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter true or false.");
                scanner.nextLine(); // clear invalid input
            }
        }
        return value;
    }
}