package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 10/26/2014.
 */


import static java.lang.Math.PI;

public class Circle extends Shape{
    private int xPos;
    private int  yPos;
    private int radius;

    public Circle(int yPos, int xPos) {
        this.yPos = yPos;
        this.xPos = xPos;
        this.radius = 10;
    }

    public Circle(int radius) {

        this.radius = radius;
    }

    @Override
    public String toString() {


        return "center = (" + xPos +  ", " + yPos + ") and radius = " + radius;
    }

    public Circle(int yPos, int xPos, int radius) {
        this.yPos = yPos;
        this.xPos = xPos;
        this.radius = radius;
    }

    public    Circle(){
        this.xPos = 10;
        this.yPos = 20;
        this.radius = 30;
           }


    public void fillColour(){
        System.out.println(this.getColor());}

    public void fillColour(int a){
    this.setColor(a);
        System.out.println("The circle color is now 2");
    }

    public void fillColour(float f){
        this.setSaturation(f);
        System.out.println("fiillColour cu float");
    }

    //putem folosi adnotarea daca vrem, dar nu e neaparat

    public double area(){ return (this.radius * this.radius)*PI; }




}
