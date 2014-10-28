package ro.teamnet.zerotohero.oop.graphicshape.runapp;

import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.oop.graphicshape.Point;
import ro.teamnet.zerotohero.oop.graphicshape.Shape;

import java.awt.*;

public class RunApp {

    public static void main(String[] args) {

        Circles cerc = new Circles();

        cerc.getAreaDef();
        System.out.println("The default circle area is: " + cerc.getAreaPub());

        Shape obj = new Circle(10);
        ShapeBehaviour obj1 = new Square(10);

        System.out.println(obj.area());
        System.out.println(obj1.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));




    }
}
