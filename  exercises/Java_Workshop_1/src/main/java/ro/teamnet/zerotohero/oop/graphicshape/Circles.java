package ro.teamnet.zerotohero.oop.graphicshape;

public class Circles {

    public double getAreaPub() {
        Circle circle = new Circle(2,2,2);
        return circle.getArea();

    }

    public void getAreaDef(){
        Circle circle2=new Circle(3,3,3);
        circle2.fillColour();
        circle2.fillColour(6);
        circle2.fillColour(6f);

    }
}

