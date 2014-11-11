package ro.teamnet.zerotohero.oop.graphicshape;

import static java.lang.Math.PI;

public class Circle extends Shape{

    private int xPos, yPos, radius;

    public Circle() {
        this.xPos = 1;
        this.yPos = 1;
        this.radius = 1;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Circle (int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area() {

        return radius * radius * PI / 2;
    }

    @Override
    public String toString() {
        return "center = (" + xPos + "," + yPos + ") and radius = " + radius;
    }

    public void fillColour() {
        System.out.println("Culoarea este: " + color);
    }

    public void fillColour(int x) {
        super.color = x;
        System.out.println("The circle color is now: " + color);
    }

    public void fillColour(float y) {
        super.saturation = y;
    }
}
