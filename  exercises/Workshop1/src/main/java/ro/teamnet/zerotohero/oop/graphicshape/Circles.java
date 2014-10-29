package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Bogdan on 10/27/2014.
 */
public class Circles
{
    public double getAreaPub()
    {
        return new Circle().area();
    }

    public void getAreaDef()
    {
        Circle circle = new Circle();

        circle.fillColour();
        circle.fillColor(2);
        circle.fillColor(3.00f);
    }
}
