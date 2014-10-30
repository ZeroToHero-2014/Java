package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

public class RunApp {

    public static void main(String[] args){

        Circles cercuri = new Circles();
        cercuri.getAreaDef();

        System.out.println(cercuri.getAreaPub());

        Canvas can = new Canvas();
        can.getArea(4);

        Shape x = new Circle(10);
        System.out.println(x.area());

        ShapeBehavior sb = new Square(10);
        System.out.println(sb.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }
}