package Shapes;
public class Shape {
    private String color;
    private int length;
    private int width; 
    public Shape(String color, int length, int width){
        this.color=color;
        this.length=length;
        this.width=width;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }
    public double area(){
        return -1.0;
    }
    public double perimeter(){
        return -1.0;
    }
}