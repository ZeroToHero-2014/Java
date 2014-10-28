package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by andrei.dobre on 27.10.2014.
 */
public class Shape extends AbstractShape implements ShapeBehaviour{
    protected int color;
    protected float saturation;

    public double area(){
        return 0;
    }

    public int getColor(){
        return color;
    }

    public float getSaturation(){
        return saturation;
    }


}
