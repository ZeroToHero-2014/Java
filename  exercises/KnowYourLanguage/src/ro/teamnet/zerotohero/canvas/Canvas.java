package ro.teamnet.zerotohero.canvas;

import static java.lang.Math.PI;

import ro.teamnet.zerotohero.oop.graphicshape.Circle;

public class Canvas {

    public double getArea(int radius) {
        return radius * radius * PI / 2;
    }
}