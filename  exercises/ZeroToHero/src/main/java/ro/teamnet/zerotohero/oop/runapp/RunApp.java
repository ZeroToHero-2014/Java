package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.oop.graphicshape.Circles;

/**
 * Created by user on 10/27/2014.
 */
public class RunApp {
    public static void main(String[]args){
        Circles c= new Circles();
        c.getAreaDef();
        System.out.println("The default circle area is"+ c.getAreaPub());
    }
}
