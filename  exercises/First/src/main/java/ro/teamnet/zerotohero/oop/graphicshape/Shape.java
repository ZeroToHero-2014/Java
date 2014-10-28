package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by George on 10/27/2014.
 */
public class Shape extends AbstractShape implements ShapeBehaviour{
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
