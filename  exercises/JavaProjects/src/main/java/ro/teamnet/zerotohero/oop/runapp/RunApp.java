package ro.teamnet.zerotohero.oop.runapp;
import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.oop.canvas.Canvas;

/**
 * Created by Dumitru on 27.10.2014.
 */
public class RunApp {

    public static void main(String[] args) {

        /*Circles c = new Circles();
        Canvas cv = new Canvas();
        Shape sp = new Circle(10);
        System.out.println(sp.area());
        ShapeBehaviour sb = new Square(10);
        System.out.println(sb.area());
        System.out.println("The default circle area is " + c.getAreaPub());

        c.getAreaDef();

        //System.out.println(cv.getArea());*/

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }
}
