package ro.teamnet.zerotohero.oop.runapp;
import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.oop.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.Square;
import ro.teamnet.zerotohero.oop.graphicshape.Point;
import ro.teamnet.zerotohero.oop.graphicshape.Immutable;
public class RunApp  {
    public static void main(String[] args){
        Circles circle1=new Circles();

        System.out.println("The default circle area is "+circle1.getAreaPub());

        circle1.getAreaDef();

        Canvas canvas1=new Canvas();
        canvas1.getArea2();

        Circle circle_1 = new Circle(10);
        Shape shape_1 = circle_1;
        System.out.println("The area is: "+shape_1.getArea());


        Shape shape_2 = new Square(10);

        Object p1 = new Point(10,20);
        Object p2= new Point(50,100);
        Object p3= new Point(10,20);


        System.out.println("p1 equals p2 is "+p1.equals(p2));
        System.out.println("p1 equals p3 is"+p1.equals(p3));

        Immutable imu_1 = Immutable.createInstance(2,2);

        System.out.println("Immutable values are:"+imu_1.getFirstInt()+" AND "+ imu_1.getSecondInt());
    }
}
