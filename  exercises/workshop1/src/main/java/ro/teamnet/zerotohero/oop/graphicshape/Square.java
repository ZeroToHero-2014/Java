package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei on 10/27/2014.
 */
public class Square extends Shape {
    int side;

    public Square(int side){
        this.side = side;
    }
    public double area(){
        return side*side;
    }
}
