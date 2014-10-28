package ro.teamnet.zerotohero.oop.graphicshape;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Shape extends AbstractShape implements ShapeBehaviour {

    protected int color;
    protected float saturation;

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public double area() {
        System.out.println("");
        return 0;
    }


}
