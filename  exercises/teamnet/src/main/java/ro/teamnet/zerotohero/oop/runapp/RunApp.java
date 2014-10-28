package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.canvas.Canvas;

/**
 * Created by Buli on 27.10.2014.
 */
public class RunApp {

    public static void main(String[] args){
        Circles myCircles = new Circles();
        System.out.println("The default circle area is " + myCircles.getAreaPub());

        System.out.print("getAreaDef result: ");
        myCircles.getAreaDef();

        Canvas myCanvas = new Canvas();
        //myCanvas.getArea();

        Shape myShape = new Circle(10);
        System.out.println("New circle area: " + myShape.area());

        ShapeBehaviour myShapeB = new Square(10);
        System.out.println("New square area: " + myShapeB.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

        //ImmutableClass newObject = new ImmutableClass(2,2.3);
        ImmutableClass newObj = ImmutableClass.createNewInstance(2,(float) 2.3);
        System.out.println("Field immutable: " + newObj.getField());
        System.out.println("Field2 immutable: " + newObj.getField2());


    }

}
