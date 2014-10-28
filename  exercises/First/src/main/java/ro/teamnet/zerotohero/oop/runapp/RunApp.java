package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

import java.util.prefs.Preferences;

/**
 * Created by George on 10/27/2014.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles circles = new Circles();
        System.out.println("Area: " + circles.getAreaPub());

        Circle circle = new Circle(1, 2, 10);
        System.out.println(circle);

        circles.getAreaDef();

        /*
        Canvas canvas = new Canvas();
        canvas.getArea();
        */

        Shape shape = new Circle(10);
        System.out.println("Area of shape: " + shape.area());

        ShapeBehaviour shapeBehaviour = new Square(10);
        System.out.println(shapeBehaviour.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

        Point3D point3D = new Point3D(1, 2, 3);
        System.out.println(point3D);


    }
}
