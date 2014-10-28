package ro.teamnet.zerotohero.oop.graphicshape;
import javax.lang.model.element.NestingKind;

import static java.lang.Math.PI;
/**
 * Created by andrei.dobre on 27.10.2014.
 */
public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        this.xPos = 10;
        this.yPos = 10;
        this.radius = 5;
    }

    public Circle(int x) {
        this.xPos = x;
        this.yPos = 10;
        this.radius = 5;
    }

    public Circle(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.radius = 5;
    }

    public Circle(int x, int y, int rad) {
        this.xPos = x;
        this.yPos = y;
        this.radius = rad;
    }

    public double area(int radius){

        return PI * radius * radius;

    }

    public String toString(){

       return "center = (" + xPos + "," + yPos + ") and radius = " + radius;

    }

    public String fillColour(){
        System.out.println("super classes color primitive variable are: " + color + "and " + saturation );
        return "text";
    }

    public String fillColour(int col){
        color = col;
        System.out.println("super classes color primitive variable is: " + color);
        return "The circle color is now 2";
    }

    public String fillColour(float sat){
        saturation = sat;
        System.out.println("super classes color primitive variable is: " + saturation);
        return "text";
    }
}
