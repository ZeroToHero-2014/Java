package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Dumitru on 27.10.2014.
 */
public class Square extends Shape{

    private int side;
    public Square(int side) {

        side = this.side;
    }

    @Override
    public double area() {
        double a;
        a = this.side * this.side;
        return a;
    }
}
