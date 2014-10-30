package ro.teamnet.zerotohero.oop.graphicshape;

import static java.lang.Math.PI;

public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle(){
        this.xPos=1;
        this.yPos=1;
        this.radius=1;
    }

    public Circle(int radius){
        this.radius=10;
    }

    public Circle(int xPos,int yPos){
        this.xPos=3;
        this.yPos=5;
    }

    public Circle(int xPos,int yPos, int radius){
        this.xPos=xPos;
        this.yPos=yPos;
        this.radius=radius;
    }

    public double area(){
        return radius*radius*PI/2;
    }

    public String toString(String x){
         x= "center = (" + xPos + "," + yPos + ") and radius = " + radius;
        return x;
    }

    public void fillColor(){
        System.out.println("Culoarea este "+ color);
    }

    public void fillColor(int x){
        super.color=x;
        System.out.println("The circle color is now " + color);
    }

    public void fillColor(float y){
        super.saturation=y;
    }
}
