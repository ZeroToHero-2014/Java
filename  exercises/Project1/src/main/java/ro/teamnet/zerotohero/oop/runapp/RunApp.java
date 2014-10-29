package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by user on 10/26/2014.
 */
public class RunApp {



    public static void main(String[] args) {
        Circles c = new Circles();

        System.out.println("The default circle area is " + c.getAreaPub());
        c.getAreaDef();

        Canvas cv = new Canvas();


//ne da eroare - ne spune ca getArea nu e publica si nu poate fi accesata din afara pachetului
//ne sugereaza sa of acem publica

//       System.out.println( cv.getArea());

        Shape sh = new Circle(10);
        System.out.println("sh area = " + sh.area());

        ShapeBehaviour sb = new Square(10);

        System.out.println("sb area = " + sb.area());


        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));


    }}
