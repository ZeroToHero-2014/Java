package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Buli on 27.10.2014.
 */
public class Circle extends Shape{

    private int xPos,yPos, radius;

    public Circle() {
        this.xPos = 41;
        this.yPos = 30;
        this.radius = 2;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.radius = radius;
        this.yPos = yPos;
    }

    @Override
    public double area(){
        return Math.PI * radius*radius;
    }

    @Override
    public String toString(){
        return "center = ("+ xPos + "," + yPos + ") and radius =" + radius;
    }

    public void fillColour(){
        System.out.println(super.color);
    }

    public void fillColour(int param){
        super.setColor(param);
        System.out.println("The circle color is now " + param);
    }

    public void fillColour(float param){
        super.setSaturation(param);
        System.out.println("The saturation is now " +  param);
    }
}
