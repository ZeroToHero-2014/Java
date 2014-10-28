package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class ExceptionPropagation {

    // propagam exceptia
    public void throw1() throws MyException {
        throw2();
    }
    public void throw2() throws MyException {
        throw3();
    }
    public void throw3() throws MyException {
        throw new MyException("Dar si Amalia are mere!");
    }

    public static void main(String[] args) throws MyException {

        ExceptionPropagation ep = new ExceptionPropagation();
        /* facem throws sau try-catch:
        try {
            ep.throw1();
        }
        catch(MyException e) {
            e.printStackTrace();
        }*/
        ep.throw1();
    }
}