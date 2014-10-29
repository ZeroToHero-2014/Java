package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 10/26/2014.
 */
public class Square extends Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {


        return (side * side );
    }
}