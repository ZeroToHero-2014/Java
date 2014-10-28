package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Miha on 10/27/2014.
 */
public class Circle extends Shape{
    private int xPos, yPos, radius;

    public Circle() {
        this.radius = 80;
        this.xPos = 110;
        this.yPos = 90;
    }
    public double area(){
        return this.radius * this.radius * java.lang.Math.PI;
    }

    public Circle(int rad) {
        this.radius = rad;
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
    public String toString() {
        return "center = (" + this.xPos + "," + this.yPos + ") and radius=" + this.radius;
    }

    public void fillColour(){
        System.out.println("The color is " + super.color);
    }

    public void fillColour(int param1){
        super.color = param1;
        System.out.println("The circle color is now " + param1);
    }

    public void fillColour(float param2){
        super.saturation = param2;
        System.out.println("The circle saturation is now " + param2);
    }
}
