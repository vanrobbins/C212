/**
 * Represents a Rectangle shape with a height and width.
 * Extends the abstract Shape class.
 */
public class Rectangle extends Shape {
    private int height;
    private int width;

    //Constructs a Rectangle with the specified color, height, and width.
    public Rectangle(String color, int height, int width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    //Calculates and returns the area of the rectangle.
    @Override
    public double area() {
        return height * width;
    }

    //Calculates and returns the perimeter of the rectangle.
    @Override
    public double perimeter() {
        return 2 * (height + width);
    }

    //Returns a string representation of the rectangle.
    @Override
    public String toString() {
        return "Rectangle- color: " + getColor() + " height: " + height + " width: " + width;
    }

    // Getters and setters for height and width.
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
