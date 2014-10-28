package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by ovy on 10/27/2014.
 */
public class Circle extends Shape {
    int xPos,yPos,radius;
    public Circle(){
        this.xPos=2;
        this.yPos=3;
        this.radius=5;
    }
    public  Circle(int x){
        this.xPos=x;
    }
    public  Circle(int x,int y){}
    public  Circle(int x,int y,int r){}

    @Override
    public double are() {

        return PI*(this.radius*this.radius);
    }
    public void fillColour() {
        System.out.println(super.color);
    }
        public void fillColour(int a){
            super.color=a;
            System.out.println("The circle color is now"+super.color);
    }
        public void fillColour(float a){
            super.saturation=a;
        }

    public String toString(){
        return "centre=("+this.xPos+","+this.yPos+")"+"and radius="+this.radius;
    }
}
