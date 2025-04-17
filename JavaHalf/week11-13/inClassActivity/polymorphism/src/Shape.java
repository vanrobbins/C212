/**
 * Abstract base class for all shapes.
 * Provides a common structure for shape properties and methods.
 */
public abstract class Shape {
    private String color;


    //Constructs a Shape with the specified color.
    public Shape(String color) {
        this.color = color;
    }

    // Getter and setter for color.
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    //Abstract method to calculate the area of the shape.
    public abstract double area();

    //Abstract method to calculate the perimeter of the shape.
    public abstract double perimeter();

    //Returns a string representation of the shape.
    @Override
    public String toString() {
        return "Shape- color: " + color + "]";
    }
}