package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by Ifrim on 27.10.2014.
 */
public class Circle extends Shape {
    private int xPos, yPos, radius;

    public Circle(){
        this.xPos = 21;
        this.yPos = 25;
        this.radius = 235;
    }

    public double area() {
        System.out.println("Circle Area is:");
        return PI*radius*radius;
    }
}
