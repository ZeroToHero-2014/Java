package ro.teamnet.zerotohero.oop;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Andrei on 10/27/2014.
 */
public class RunApp {
    public  static void main(String[] args){
        Circles c = new Circles();
        System.out.println("The default circle area is:" + c.getAreaPub() );
        c.getAreaDef();
        Shape shape = new Circle(10);
        System.out.println("The circle area is:" + shape.area() );
        ShapeBehaviour square = new Square(10);
        System.out.println("The square area is:" + square.area() );

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));


    }
}
