/**
 * Represents a Circle shape with a radius.
 * Extends the abstract Shape class.
 */
public class Circle extends Shape {
    private int radius;

    //Constructs a Circle with the specified color and radius.
    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    //Calculates and returns the area of the circle.
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }


    //Calculates and returns the perimeter (circumference) of the circle.
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    //Returns a string representation of the circle.
    @Override
    public String toString() {
        return "Circle- color: " + getColor() + " radius: " + radius;
    }

    //Getter and setter for radius.
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

