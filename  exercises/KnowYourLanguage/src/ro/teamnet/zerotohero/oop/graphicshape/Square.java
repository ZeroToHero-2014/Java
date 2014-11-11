package ro.teamnet.zerotohero.oop.graphicshape;

public class Square extends Shape{

    private int side;

    public Square(int side){
        this.side = 2;
    }

    @Override
    public double area() {
        return side * side;
    }
}