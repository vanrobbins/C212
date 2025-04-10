package Shapes;
public class Rectangle extends Shape {

    private int height;
    private int width;
    public Rectangle(String color, int height, int width){
        super(color, height, width);
        this.height=height;
        this.width=width;
    }
    @Override
    public double area(){
        return height*width;
    }
    @Override
    public double perimeter(){
        return 2*(height+width);
    }
}
