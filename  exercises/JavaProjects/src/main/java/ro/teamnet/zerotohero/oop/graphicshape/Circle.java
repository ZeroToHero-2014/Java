package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;

/**
 * Created by Dumitru on 27.10.2014.
 */
public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {

        this.xPos = 2;
        this.yPos = 3;
        this.radius = 2;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
        this.radius = 1;
    }

    public Circle(int xPos, int yPos) {

        this.xPos = xPos;
        this.yPos = yPos;
    }
    public Circle(int xPos, int yPos, int radius) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area() {
        double a;
        a = (PI * this.radius * this.radius) / 2;
        return a;
    }

    @Override
    public String toString(){

         return "center(" + xPos + ", " + yPos + ") and radius = " + radius;
    }


    public String fillColour() {
        Shape s = new Shape();
        return "The circle color is " + s.color;
    }

    public String fillColour(int color) {
        Shape s = new Shape();
        s.setColor(color);
        return "The circle color is now " + s.color;
    }

    public String fillColour(float saturation) {
        Shape s = new Shape();
        s.setSaturation(saturation);
        return "The circle saturation is now " + s.saturation;
    }



}
