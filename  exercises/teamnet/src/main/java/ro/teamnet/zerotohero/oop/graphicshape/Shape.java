package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Buli on 27.10.2014.
 */
public class Shape extends AbstractShape implements ShapeBehaviour {
    protected int color;
    protected float saturation;


    public double area(){
        double value = 0;
        System.out.println("Area");
        return value;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}
