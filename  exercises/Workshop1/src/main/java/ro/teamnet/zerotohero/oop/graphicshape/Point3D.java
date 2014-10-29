package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Bogdan on 10/27/2014.
 */
public class Point3D extends Point
{
    private int zPos;

    public Point3D (int x, int y, int zPos)
    {
        super(x,y);
        this.zPos = zPos;
    }
}
