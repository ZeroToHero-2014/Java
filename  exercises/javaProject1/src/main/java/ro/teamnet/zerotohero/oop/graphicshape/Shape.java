package ro.teamnet.zerotohero.oop.graphicshape;


public class Shape extends AbstractShape implements ShapeBehaviour {

    protected int color;
    protected float saturation;

    public Shape(int color, float saturation) {
        this.color = color;
        this.saturation = saturation;
    }

    public Shape(){

    }
    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public double area() {

        return 0;
    }

}
