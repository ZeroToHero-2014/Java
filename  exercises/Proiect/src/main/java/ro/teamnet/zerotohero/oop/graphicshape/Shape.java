package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by ovy on 10/27/2014.
 */
public class Shape extends AbstractShape implements ShapeBehavior  {

    protected int color;
   protected float saturation;

    public double are(){
        return 0;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}
