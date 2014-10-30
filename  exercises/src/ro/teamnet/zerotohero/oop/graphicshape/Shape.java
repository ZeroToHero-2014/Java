package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.graphicshape.AbstractShape;
import ro.teamnet.zerotohero.oop.graphicshape.ShapeBehavior;

public class Shape extends AbstractShape
    implements ShapeBehavior {

    protected int color;
    protected float saturation;

    public void setColor(int color) {

        this.color = color;
    }

    public void setSaturation(float saturation) {

        this.saturation = saturation;
    }

    public double area(){

        return 0;
    }

}
