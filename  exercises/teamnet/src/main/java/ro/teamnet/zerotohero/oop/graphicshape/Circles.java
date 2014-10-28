package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Buli on 27.10.2014.
 */
public class Circles {

    public Circles() {
    }

    public double getAreaPub(){
        Circle circle1 = new Circle();
        return circle1.area();
    }

    public void getAreaDef(){
        Circle myCircle = new Circle();
        myCircle.fillColour();
        myCircle.fillColour(2);
        myCircle.fillColour((float) 21.2);
    }

}
