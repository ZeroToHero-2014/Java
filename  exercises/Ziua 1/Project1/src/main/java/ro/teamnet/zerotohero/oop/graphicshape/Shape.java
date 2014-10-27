package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 10/26/2014.
 */
public class Shape extends  AbstractShape
        implements  ShapeBehaviour  {

//fisiere java (clase.. ) - doar in folderul java


    protected int color;
    protected float saturation;



    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getSaturation() {
        return saturation;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public double area(){ return 0; }



}
