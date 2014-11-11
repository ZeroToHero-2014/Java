package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

public class RunApp {

    public static void main(String[] args) {
        Circles cercuri = new Circles();
        System.out.println("The default circle area is " + cercuri.getAreaPub());
        cercuri.getAreaDef();

        Canvas canv = new Canvas();
        System.out.println("Canvas, method getArea " + canv.getArea(3));

        Shape shape = new Circle(10);
        System.out.println("Shape object area " + shape.area());

        ShapeBehavior sb = new Square(10);
        System.out.println("ShapeBehavior object area " + sb.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));
    }
}
