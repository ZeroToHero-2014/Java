package ro.teamnet.zerotohero.oop.graphicshape;

import com.sun.org.apache.xpath.internal.SourceTree;
/**
 * Created by Ilai Hawkeye on 10/27/2014.
 */
public class Shape extends AbstractShape implements ShapeBehaviour {

    protected int color;
    protected float saturation;


    public double area(){

       return 0;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}

