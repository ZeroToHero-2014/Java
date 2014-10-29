package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei on 10/27/2014.
 */
public class Circles {

    public double getAreaPub(){
        Circle c = new Circle();
        return c.area();
    }
    public void getAreaDef(){
        Circle c = new Circle();
        c.fillColour();
        c.fillColour(10);
        c.fillColour(19.34f);
    }
}
