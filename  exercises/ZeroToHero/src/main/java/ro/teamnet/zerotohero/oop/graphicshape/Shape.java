package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 10/27/2014.
 */


public class Shape implements ShapeBehaviour {


  protected int color;
  protected float saturation;

    public double area(){
        return 0;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation){
        this.saturation=saturation;
    }
}
