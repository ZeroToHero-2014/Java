package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Miha on 10/27/2014.
 */
public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public double area(){
        return this.side * this.side;
    }
}