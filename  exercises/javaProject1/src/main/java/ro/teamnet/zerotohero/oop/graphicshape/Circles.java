package ro.teamnet.zerotohero.oop.graphicshape;


public class Circles {

    public double getAreaPub() {


        Circle cerc = new Circle();
        return cerc.area();

    }
    public void getAreaDef(){
        Circle cerc = new Circle();
        cerc.fillColour();
        cerc.fillColour(3);
        cerc.fillColour(6);
    }
}
