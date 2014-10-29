package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei on 10/27/2014.
 */
public class Point3D extends Point {
    private int zPos;

    public Point3D(int xPos, int yPos, int zPos){
            super(xPos, yPos);
            this.zPos = zPos;
    }
}
