package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by Computer on 10/27/2014.
 */
 public class Circle extends Shape {
    private int xPos;
    private int yPos;
    private int radius;

    public Circle ()
    {
        this.xPos=10;
        this.yPos=20;
        this.radius= 10;
    }
    public Circle (int xPos)
    {
        this.xPos=xPos;
    }
    public Circle (int xPos, int yPos)
    {
        this.xPos=xPos;
        this.yPos=yPos;
    }
    public Circle (int xPos, int yPos, int radius)
    {
        this.xPos=xPos;
        this.yPos=yPos;
        this.radius=radius;
    }
    public double area ()
    {
       double area;
       area=Math.PI*radius*radius;
       System.out.println("Circle square "+ area);
       return area;
    }
    public String toString()
    {
       return ("center=("+ xPos+"," +yPos+") and radius="+radius);
    }
    void fillColor()
    {
System.out.println("color: "+color);
    }
    void fillColor(int color)
    {
        super.setColor(color);
        System.out.println("The circle color now is 2 ");
    }
    void fillColor(float saturation)
    {
        super.setSaturation(saturation);
            }
}
