package ro.teamnet.zerotohero.oop.graphicshape;

public class Shape extends AbstractShape implements ShapeBehaviour {
    protected int color;
    protected float saturation;

    public double area() {
        double var = 1.1;
        return var;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}
