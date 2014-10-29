package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by Ilai Hawkeye on 10/27/2014.
 */
public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle(){

       xPos = 1;
       yPos = 1;
       radius = 2;
    }
    public Circle(int posX) {
        this.xPos = posX;
        this.yPos = 3;
        this.radius = 6;
    }
    public Circle(int posX, int posY){
        this.xPos = posX;
        this.yPos = posY;
        this.radius = 7;
    }
    public Circle(int posX, int posY, int rad){
        this.xPos = posX;
        this.yPos = posY;
        this.radius = rad;
    }
    public double area(){

        return Math.PI*radius*radius;
    }
    public String toString(){
        return "center = ("+xPos+","+yPos+") and radius = "+radius;
    }
    void fillColor() {
        System.out.println("color: " + color);
    }
    public void fillColor (int color) {
        super.setColor(color);
        System.out.println("The circle color is now " + color);
    }
    public void fillColor (float saturation) {
        super.setSaturation(saturation);
        System.out.println("The circle color saturation is now " + saturation);
    }
    public void getAreaDef(){
        Circle c1 = new Circle();
        c1.fillColor();
        c1.fillColor(2);
        c1.fillColor(10);
    }
}




