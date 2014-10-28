package ro.teamnet.zerotohero.oop.graphicshape;

import static java.lang.Math.PI;
/**
 * Created by Juvie on 27.10.2014.
 */
public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        xPos = 1;
        yPos = 2;
        radius = 3;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
        yPos = 2;
        radius = 3;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        radius = 3;
    }

    Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area(){
        return PI*radius*radius;
    }

    public void fillColour () {
        System.out.println(super.color);
    }

    public void fillColour (int color) {
        super.color = color;
        System.out.println("The circle color is now " + color);
    }

    public void fillColour (float saturation) {
        super.setSaturation(saturation);
        System.out.println("The circle color is now " + saturation);
    }

    @Override
    public String toString() {
        return "center = (" + xPos + "," + yPos + ") and radius = " + radius;
    }

}
