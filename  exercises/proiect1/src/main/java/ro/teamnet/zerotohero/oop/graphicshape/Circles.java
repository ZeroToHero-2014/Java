package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Miha on 10/27/2014.
 */
public class Circles {
    public double getAreaPub(){
        Circle cerc = new Circle();
        return cerc.area();
    }

    public void getAreaDef(){
        Circle cerc = new Circle();
        cerc.fillColour();
        cerc.fillColour(11);
        cerc.fillColour(12.4f);  //cerc.fillColour(Float.parseFloat("12.4"));
    }
}
