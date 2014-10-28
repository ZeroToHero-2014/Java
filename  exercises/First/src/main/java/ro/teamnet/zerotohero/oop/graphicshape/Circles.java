package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by George on 10/27/2014.
 */
public class Circles {
    public double getAreaPub(){
        Circle circle = new Circle();
        return circle.area();
    }

    public void getAreaDef(){
        Circle circle = new Circle();
        circle.fillColour();
        circle.fillColour(10);
        circle.fillColour(15f);
    }


}
