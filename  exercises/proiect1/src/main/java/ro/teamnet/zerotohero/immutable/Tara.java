package ro.teamnet.zerotohero.immutable;

/**
 * Created by Miha on 10/27/2014.
 */
public final class Tara {
    private final double suprafata;
    private final String nume;

    public final void scrie(){
        System.out.println("Suprafata tarii " + this.nume + " este " + this.suprafata);
    }

    public double getSuprafata() {
        return suprafata;
    }

    public String getNume() {
        return nume;
    }

    public Tara(double suprafata, String nume) {
        this.suprafata = suprafata;
        this.nume = nume;
    }
}
