package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Ilai Hawkeye on 10/27/2014.
 */
public class Point3D extends Point {

    private int zPos;

    public Point3D(int x, int y, int z){

        super(x,y);
        this.zPos = z;
    }
    public String toString(){

    return "Point3D with position x="+xPos+" "+" position y="+yPos+" and position z="+zPos;
}
}
