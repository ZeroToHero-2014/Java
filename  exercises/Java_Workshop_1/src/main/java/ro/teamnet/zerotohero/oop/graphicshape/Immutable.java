package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Ciprian on 27.10.2014.
 */
public final class Immutable {
    private final int a;
    private final int b;

    private Immutable(int i,int j){
        this.a=i;
        this.b=j;
    }

    public int getFirstInt(){
        return a;
    }
    public int getSecondInt(){
        return b;
    }

    public static Immutable createInstance(int a,int b){
        return new Immutable(a,b);
    }

}
