/**
 * Represents a Triangle shape with a base and height.
 * Extends the abstract Shape class.
 */
public class Triangle extends Shape {
    private int base;
    private int height;

    //Constructs a Triangle with the specified color, base, and height.
    public Triangle(String color, int base, int height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    //Calculates and returns the area of the triangle.
    @Override
    public double area() {
        return (base * height) / 2;
    }

    /**
     * Calculates and returns the perimeter of the triangle.
     * Assumes the triangle is a right triangle.
     */
    @Override
    public double perimeter() {
        return base + height + Math.sqrt(base * base + height * height);
    }

    
    //Returns a string representation of the triangle.
    @Override
    public String toString() {
        return "Triangle- color: " + getColor() + " base: " + base + " height: " + height;
    }

    // Getters and setters for base and height.
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
