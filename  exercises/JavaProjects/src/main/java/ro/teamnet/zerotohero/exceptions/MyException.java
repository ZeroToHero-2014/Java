package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class MyException extends Exception {

    public MyException() {
        super();
    }

    public MyException(String str) {
        super(str);
    }

    public MyException(Exception e) {
        super(e);
    }

    public static void main(String[] args) {

        try
        {
            // aruncam exceptia
            throw new MyException("Ana are mere!");
        }
        catch (MyException e)
        {
            e.printStackTrace();
        }
    }
}