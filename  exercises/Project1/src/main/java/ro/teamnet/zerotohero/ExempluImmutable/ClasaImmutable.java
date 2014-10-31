package ro.teamnet.zerotohero.ExempluImmutable;

/**
 * Created by user on 10/29/2014.
 */
//clasa nu poate fi derivata
public final class ClasaImmutable {

    //variabile private si final (nu mai pot fi modificate o data ce au fost instantiate)
    private final int a;
    private final int b;
    private final int c;

    //valorile campurile sunt date prin constructor, nu exista setteri
    public ClasaImmutable(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "ClasaImmutable{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public int getB() {
        return b;
    } //nu poate fi folosit pentru a le modifica valoare

    public int getC() {
        return c;
    }

    //demonstram ca e imutabila - nu putem modifica obiectul fara sa cream unul nou
    public ClasaImmutable Aduna(int r) {
        //vrem ca obiectul nostru sa aiba proprietatile + r
        //singurul mod in care se poate face e prin crearea unui obiect (nu se poate schimba pt ca e imutabil)


//        this.a = a + r;  -> eroare campul e final
        return new ClasaImmutable(this.a + r, this.b + r, this.c + r);


    }

}
