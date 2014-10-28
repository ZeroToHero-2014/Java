package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by ovy on 10/27/2014.
 */
public class Square extends Shape {
    private int side;



    public Square(int x){
        this.side=x;
    }
    @Override
    public double are() {
        return this.side*this.side;
    }

}
