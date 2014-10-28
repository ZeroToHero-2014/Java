package ro.teamnet.zerotohero.threads.serialization;
import java.io.*;

/**
 * Created by user on 10/28/2014.
 */
public class USPresident implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private String period;
    private String term;


    public String toString() {
        return "US President [name=" + name + ", period=" + period + ", term=" + term + "]";
    }
    public USPresident(String name, String period, String term) {
        this.name = name;
        this.period = period;
        this.term = term;
    }

}
