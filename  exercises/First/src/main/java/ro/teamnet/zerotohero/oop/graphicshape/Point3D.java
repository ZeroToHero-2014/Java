package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by George on 10/27/2014.
 */
public class Point3D extends Point {
    private int zPos;

    public Point3D(int xPos, int yPos, int zPos){
        super(xPos, yPos);
        this.zPos = zPos;
    }

    @Override
    public String toString(){
        return ("Point3D: (" + super.xPos + ", " + super.yPos + ", " + this.zPos + ")");
    }
}
