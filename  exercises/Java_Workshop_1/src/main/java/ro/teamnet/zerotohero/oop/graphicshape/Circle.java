package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;


public class Circle extends Shape {
    private int xPos;
    private int yPos;
    private int radius;



    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getArea(){
         return (PI*radius*radius);
     }

    public Circle(int a){
        this.xPos=a;

    }

    public Circle(int a,int b){
        this.xPos=a;
        this.yPos=b;

    }

    public Circle(int a,int b,int c){
        this.xPos=a;
        this.yPos=b;
        this.radius=c;
    }

    public String toString(){
        return String.format("Center=(%d , %d) and radius= %d", this.xPos, this.yPos,this.radius);
    }

    public void fillColour(){
        System.out.println("The color is:"+this.color);
    }

    public void fillColour(int color){
        super.setColor(color);
        System.out.println("The color is now: "+color);
    }

    public void fillColour(float saturation){
        super.setSaturation(saturation);
        System.out.println("Saturation is now: "+saturation);

    }
}
