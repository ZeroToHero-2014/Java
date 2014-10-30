package ro.teamnet.zerotohero.oop.graphicshape;

public class Circles {

    public double getAreaPub(){
        Circle cerc = new Circle();
        return (cerc.area());
    }

    public void getAreaDef(){
        Circle cerc2 = new Circle();
        cerc2.fillColor();
        cerc2.fillColor(2);
        cerc2.fillColor(-5);
    }
}
