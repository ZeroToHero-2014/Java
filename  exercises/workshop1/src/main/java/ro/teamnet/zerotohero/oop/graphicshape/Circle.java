package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by Andrei on 10/27/2014.
 */
public class Circle extends Shape {
    private int xPos;
    private int yPos;
    private int radius;
    public Circle(){
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 1;
    }
    public Circle(int xPos){
        this.xPos = xPos;
        this.yPos = 0;
        this.radius = 1;
    }
    public Circle(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 1;
    }
    public Circle(int xPos, int yPos, int radius){
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }
    @Override
    public String toString(){
        return ("center = ("+xPos+"," +yPos+") and radius = "+radius);

    }
    public double area(){
        return 2*PI*radius;
    }
    public void fillColour(){
        System.out.println(color);
    }
    public void fillColour(int color){
        this.color = color;
        System.out.println("You have set color to" + color);
    }
    public void fillColour(float saturation){
        this.saturation = saturation;
        System.out.println("You have set saturation to" + saturation);
        System.out.println();
    }
}
