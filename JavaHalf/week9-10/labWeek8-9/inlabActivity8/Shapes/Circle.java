package Shapes;
public class Circle extends Shape {
    private int radius;
    public Circle(String color, int radius){
        super(color, radius, radius);
        this.radius=radius;
    }
    @Override
    public double area(){
        return Math.PI*radius*radius;
    }
    @Override
    public double perimeter(){
       return 2 * Math.PI * radius;
    }
}

