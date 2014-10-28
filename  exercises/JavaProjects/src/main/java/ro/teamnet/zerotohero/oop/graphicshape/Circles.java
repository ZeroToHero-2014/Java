package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Dumitru on 27.10.2014.
 */
public class Circles {

    public double getAreaPub() {

        Circle c = new Circle();
        return c.area();
    }

    public void getAreaDef() {

        Circle c = new Circle();
        System.out.println(c.fillColour());
        System.out.println(c.fillColour(4));
        System.out.println(c.fillColour(5));
    }
}
