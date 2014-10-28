package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;

/**
 * Created by George on 10/27/2014.
 */
public class Circle extends Shape  {
    private int xPos, yPos, radius;

    public Circle(){
        this.xPos = 1;
        this.yPos = 2;
        this.radius = 10;
    }

    public Circle(int xPos){
        this.xPos = xPos;
    }

    public Circle(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Circle(int xPos, int yPos, int radius){
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area(){
        return PI * (radius * radius);
    }

    @Override
    public String toString(){
        return "center = (" + xPos + ", " + yPos + ") and radius = "  + radius;
    }

    public void fillColour(){
        System.out.println("The circle color is: " + super.color);
    }


    public void fillColour(int x){
        super.color = x;
        System.out.println("The circle color is now " + x);
    }

    public void fillColour(float x){
        super.saturation = x;
        System.out.println("The circle saturation is now " + x);
    }

}
