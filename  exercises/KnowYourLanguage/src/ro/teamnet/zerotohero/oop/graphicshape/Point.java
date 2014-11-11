package ro.teamnet.zerotohero.oop.graphicshape;

public class Point {

    public int xPos, yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    // override the equals method to perform "deep" comparison of two Point objects
    @Override
    public boolean equals(Object other) {
        if(other == null)
            return false;
        // check if the dynamic type of 'other' is Point
        // if 'other' is of any other type than 'Point', the two objects cannot be
        // equal if 'other' is of type Point (or one of its derived classes), then
        // downcast the object to Point type and then compare members for equality
        if(other instanceof Point) {
            Point anotherPoint = (Point) other;
            // two points are equal only if their x and y positions are equal
            if( (xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos) )
                return true;
        }
        return false;
    }
}
