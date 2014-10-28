package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Ifrim on 27.10.2014.
 */
public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public double area() {
        System.out.println("Square Area is:");
        return side * side;
    }
}
