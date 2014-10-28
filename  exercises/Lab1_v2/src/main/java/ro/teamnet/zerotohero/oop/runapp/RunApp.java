package ro.teamnet.zerotohero.oop.runapp;
import ro.teamnet.zerotohero.Canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Computer on 10/27/2014.
 */
public class RunApp {
  public static void main(String[] args)
  {
      Circles circle1 = new Circles();
      System.out.println(circle1.getAreaPub());
      System.out.println(circle1.toString());
      circle1.getAreaDef();

      Canvas canvas=new Canvas();
      //canvas.getArea();

      Shape shape1 = new Circle(10);
      System.out.println(shape1);
      ShapeBehaviour shapeBehaviour1= new Square(10);
      System.out.println(shapeBehaviour1.area());



  }
}
