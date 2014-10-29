package ro.teamnet.zerotohero.oop.graphicshape;

import  static java.lang.Math.PI;

/**
 * Created by Bogdan on 10/27/2014.
 */
public class Circle extends Shape
{
    int xPos;
    int yPos;
    int radius;

    public Circle (int radius)
    {
        this.radius = radius;
    }
    public Circle (int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public Circle (int xPos, int yPos, int radius)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public Circle()
    {
        this(3,4,5);
    }

    public double area()
    {
        return PI * radius * radius;
    }

    public void fillColour()
    {
        System.out.println(super.color);
    }

    public void fillColor(int color)
    {
        super.color = color;
        System.out.println("The circle color is now: " + super.color);
    }

    public void fillColor(float saturtion)
    {
        super.saturation = saturation;
        System.out.println(super.saturation);
    }

    public String toString()
    {
        return "center = ( " + xPos + ", " + yPos + " ) and radius = " + radius;
    }
}
