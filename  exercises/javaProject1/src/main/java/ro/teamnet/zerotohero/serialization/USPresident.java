package ro.teamnet.zerotohero.serialization;


import java.io.Serializable;

public class USPresident implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String period;
    private transient String term;

    @Override
    public String toString() {
        return "US President [name=" + name + ", period=" + period + ", term=" + term + "]";
    }

    public USPresident(String name, String period, String term) {
        this.name = name;
        this.period = period;
        this.term = term;
    }

}
