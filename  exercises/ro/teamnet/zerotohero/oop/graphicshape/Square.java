package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by andrei.dobre on 27.10.2014.
 */
public class Square extends Shape {

    private int side;

    public Square() {
        this.side = 10;
    }

    public double area(int side){

        return side * side;

    }
}
