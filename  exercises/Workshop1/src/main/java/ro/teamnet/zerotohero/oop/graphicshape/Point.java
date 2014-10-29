package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Bogdan on 10/27/2014.
 */
public class Point
{
    int xPos;
    int yPos;

    public Point()
    {
        this(2,3);
    }

    public Point (int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object other)
    {

        if ( other == null)
            return false;
        if (other instanceof Point)
        {
            Point anotherPoint = (Point) other;
            if((xPos == anotherPoint.xPos)&& (yPos == anotherPoint.yPos))
                return true;
        }
        return false;
    }
}
