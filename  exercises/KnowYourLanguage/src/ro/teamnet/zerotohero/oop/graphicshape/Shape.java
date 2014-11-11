package ro.teamnet.zerotohero.oop.graphicshape;

public class Shape extends AbstractShape implements ShapeBehavior{

    protected int color;
    protected float saturation;

    public double area() {
        return 0;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}
