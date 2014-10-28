package ro.teamnet.zerotohero.oop.graphicshape;

import static java.lang.Math.PI;

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
        //this.xPos = xPos;
        this.radius=xPos;
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

    public double area() {

        return PI * radius * radius;


    }
    public String toString(){

      return "center = ("+xPos+","+yPos+") and radius = "+radius;

    }

    public void  fillColour(){
    System.out.println(super.color);
    }
    public void fillColour(int par){
    super.color=par;
    System.out.println("The circle color is now "+super.color);

    }
    public void  fillColour(float par){
    super.saturation=par;

    }
}
