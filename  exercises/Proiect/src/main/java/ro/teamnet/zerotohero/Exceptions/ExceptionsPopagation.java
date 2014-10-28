package ro.teamnet.zerotohero.Exceptions;

/**
 * Created by ovy on 10/28/2014.
 */
public class ExceptionsPopagation {
    public void throw1() throws Exceptions{
        throw2();
    }
    public void throw2() throws Exceptions{
        throw3();
    }
    public void throw3() throws Exceptions{
        throw new Exceptions("Exceptie propagara!!!");
    }
    public static void main(String args[]) throws Exceptions{
        ExceptionsPopagation tr =new ExceptionsPopagation();
        tr.throw1();
    }
}
