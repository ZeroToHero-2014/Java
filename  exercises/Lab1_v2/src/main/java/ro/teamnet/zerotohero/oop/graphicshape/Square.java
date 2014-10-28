package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Computer on 10/27/2014.
 */
public class Square extends Shape {
private int side;

    public Square (int side)
    {
        this.side=side;
    }
    public double area()
    {
        double squareArea;
        squareArea=side*side;
        System.out.println ("Square area"+ squareArea);
        return (squareArea);
    }
}
