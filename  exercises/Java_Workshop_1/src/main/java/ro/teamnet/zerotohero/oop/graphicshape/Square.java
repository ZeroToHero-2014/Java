package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 10/27/2014.
 */
public class Square extends Shape {
    private int side;

    public Square(int a){
        this.side=a;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public double getArea(){
        return(side*side);
    }
}
