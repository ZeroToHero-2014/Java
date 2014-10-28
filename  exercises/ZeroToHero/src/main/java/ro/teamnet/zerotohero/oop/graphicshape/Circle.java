package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;

/**
 * Created by user on 10/27/2014.
 */
public class Circle extends Shape{
    private int xPos, yPos, radius;

//public String toString();

    public Circle(){
       this.xPos=3;
       this.yPos=4;
       this.radius=5;
    }
    public Circle(int xPos){
        this.xPos=3;
        this.yPos=4;
        this.radius=5;

    }

    public Circle(int xPos, int yPos){
        this.xPos=3;
        this.yPos=4;
        this.radius=5;

   }

    public Circle(int xPos, int yPos, int radiius){
        this.xPos=3;
        this.yPos=4;
        this.radius=5;

    }

    public void fillColour(){

    }

    public void fillColour(int color){
        System.out.println("The default color is"+ color);
    }

    public void fillColour(float colors){

    }
    public double area(){

        return 0;
    }

}
