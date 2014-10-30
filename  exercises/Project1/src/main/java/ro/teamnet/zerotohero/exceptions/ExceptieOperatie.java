package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Mihai on 10/30/2014.
 */
//1 exceptie definita
public class ExceptieOperatie extends  Exception {

    public ExceptieOperatie(char op,int a,int b) {
                super("Eroare atunci cand se incearca " + a + op + b);
    }
}
