package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Dumitru on 27.10.2014.
 */
public class Shape extends AbstractShape implements ShapeBehaviour {

    int color;
    float saturation;

    public double area() {
        return 1;
    }

    protected void setColor(int color) {
        this.color = color;
    }

    protected void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}
