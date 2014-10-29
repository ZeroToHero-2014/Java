package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.oop.canvas.Canvas;

/**
 * Created by Ilai Hawkeye on 10/27/2014.
 */
public class RunApp {



    public static void main(String[] arg){
        Circles c = new Circles();
        Circle c2 = new Circle();
        Canvas cv = new Canvas();
        Shape s = new Circle(10);
        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        Point3D p4 = new Point3D(4,5,6);
        System.out.println(p4);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));
        ShapeBehaviour sb = new Square(10);
        System.out.println("The square's data is "+ sb.area());
        System.out.println("The circle's data is "+ s);
        System.out.println("The default circle area is " + c.getAreaPub());
        c2.getAreaDef();
        cv.getArea();
    }
}
