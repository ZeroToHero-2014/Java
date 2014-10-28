package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Juvie on 27.10.2014.
 */
public class Circles {

    public double getAreaPub () {
        double a;
        Circle c = new Circle();
        a = c.area();
        return a;
    }

    public void getAreaDef () {
        Circle c = new Circle();
        c.fillColour();
        c.fillColour(2);
        c.fillColour(2.2f);
    }
}
