package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Buli on 27.10.2014.
 */
public class Point {

    private int xPos, yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object other){
        if(other == null){
            return false;
        }

        if(other instanceof Point){
            Point anotherPoint = (Point) other;
            if((xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos) )
                return true;
        }

        return false;
    }
}
