package Shapes;
public class Triangle extends Shape{
    private int base;
    private int height;
    public Triangle(String color,int base, int height){
        super(color,base,height);
        this.base=base;
        this.height=height;
    }
    @Override
    public double area(){
        return (base*height)/2;
    }
    @Override
    public double perimeter(){
        return base + height + Math.sqrt(base * base + height * height);
    }
}
