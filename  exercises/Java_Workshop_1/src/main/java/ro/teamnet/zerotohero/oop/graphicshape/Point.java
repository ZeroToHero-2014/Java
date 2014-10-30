package ro.teamnet.zerotohero.oop.graphicshape;

public class Point {
    int xPos;
    int yPos;

    public Point(int a,int b){
        this.xPos=a;
        this.yPos=b;

    }


    public boolean equals(Object other){
        if(other==null){
            return false;
        }

        if(other instanceof Point) {
            Point anotherPoint = (Point) other;


            if ((xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos)) {
                return true;
            }
        }
        return false;
    }
}
