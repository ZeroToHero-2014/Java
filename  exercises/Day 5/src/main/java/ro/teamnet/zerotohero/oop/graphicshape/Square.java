package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Ilai Hawkeye on 10/27/2014.
 */
public class Square extends Shape {

    private int side;

    public Square(int side){
        this.side = side;
    }
    @Override
    public double area(){

        return side*side;
    }
}
