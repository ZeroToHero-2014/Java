package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by andrei.dobre on 27.10.2014.
 */
public class Circles {

    public double getAreaPub(){
        Circle shape1 = new Circle();
        System.out.println("The default circle area is" + shape1.area());
        return 0;
    }

    void getAreaDef(){
        Circle shape3 = new Circle();
        shape3.fillColour();
        shape3.fillColour(3);
        shape3.fillColour(4.2f);
    }
}
