package Shapes;
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5);
        Rectangle rectangle = new Rectangle("Blue", 4, 6);
        Triangle triangle = new Triangle("Green", 3, 7);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Triangle Area: " + triangle.area());

        System.out.println("Circle Perimeter: " + circle.perimeter());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());
    }
}
