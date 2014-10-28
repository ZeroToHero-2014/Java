package ro.teamnet.zerotohero.imut;

/**
 * Created by Dumitru on 27.10.2014.
 */
public final class Immutable {

    private final int var;
    private final String str;

    private Immutable(int var, String str) {
        this.var = var;
        this.str = str;
    }

    //factory method -> metoda statica care intoarce o instanta a clasei native
    public static Immutable createInstance(int var, String str) {
        return new Immutable(var, str);
    }

    public int getVariable() {
        return this.var;
    }

    public String getString() {
        return this.str;
    }

    public String toString() {
        return this.var + " " + this.str;
    }
}
