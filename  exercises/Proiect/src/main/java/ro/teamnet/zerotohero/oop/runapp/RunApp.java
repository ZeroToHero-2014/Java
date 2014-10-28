package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.oop.graphicshape.Circles;
import ro.teamnet.zerotohero.oop.graphicshape.Circle;
import ro.teamnet.zerotohero.canvas.Canvas;
import sun.plugin2.util.SystemUtil;
import ro.teamnet.zerotohero.oop.graphicshape.Shape;
import ro.teamnet.zerotohero.oop.graphicshape.Square;
import ro.teamnet.zerotohero.oop.graphicshape.Point;
import ro.teamnet.zerotohero.oop.graphicshape.Point3D;


/**
 * Created by ovy on 10/27/2014.
 */
public class RunApp {
    public static void main(String[] args){
        Circles cerc = new Circles();
       System.out.println("The default circle area is " + cerc.getAreaPub());
        Circle cer= new Circle();
        System.out.println(cer);
        Canvas can= new Canvas();
        System.out.println(can.getArea());
        Shape sh= new Circle(10);
        System.out.println(sh);
        Shape sh1= new Square(10);
        System.out.println(sh1);
        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));
        Point3D point = new Point3D(2,4,5);
        System.out.println(point.xPos);

    }
}
