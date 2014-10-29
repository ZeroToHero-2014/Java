package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Bogdan on 10/27/2014.
 */
public class RunApp
{
    public static void main(String[] args)
    {
        Circles circles = new Circles();
        Canvas canvas = new Canvas();
        Shape shape = new Circle(10);
        ShapeBehaviour sBeh = new Square(10);

        System.out.println("The default circle area is " + circles.getAreaPub());
        circles.getAreaDef();
        System.out.println(shape);
        System.out.println(sBeh);


        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));


    }
}
