package ro.teamnet.zerotohero.oop.graphicshape;
/**
 * Created by Dumitru on 27.10.2014.
 */
public class Point3D extends Point {

    private int zPos;
    Point3D(int xPos, int yPos, int zPos) {

        super(xPos, yPos);
        this.zPos = zPos;
    }
}
