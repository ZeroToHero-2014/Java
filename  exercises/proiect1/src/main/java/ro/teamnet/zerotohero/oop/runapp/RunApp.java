package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.canvas.Canvas;

/**
 * Created by Miha on 10/27/2014.
 */
public class RunApp {
    public static void main(String [] args){
        Circles cercuri = new Circles();
        System.out.println("The default circle are is " + cercuri.getAreaPub());
        cercuri.getAreaDef();

        Canvas canvasObj = new Canvas();
        //canvasObj.getArea();  nu ma lasa, pt ca nu e in acelasi pachet (are modificatorul default)

        Shape forma1 = new Circle(10);
        System.out.println(forma1.area());
        ShapeBehaviour forma2 = new Square(10);
        System.out.println(forma2.area());

        Object p1 = new Point(10,20);
        Object p2 = new Point(50,100);
        Object p3 = new Point(10,20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }
}
