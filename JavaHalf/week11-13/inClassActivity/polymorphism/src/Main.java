/**
 * Main class to demonstrate polymorphism with different shapes.
 */
public class Main {
    public static void main(String[] args) {
        // Create an array of shapes with different types.
        Shape[] shapes = {
            new Circle("Red", 4),
            new Rectangle("Blue", 3, 3),
            new Triangle("Green", 2, 4)
        };

        // Print information about each shape.
        System.out.println("--Shape Info--");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].toString());
        }

        // Print the area of each shape.
        System.out.println("--Area of Shapes--");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].area());
        }

        // Print the perimeter of each shape.
        System.out.println("--Perimeter of Shapes--");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].perimeter());
        }
    }
}
