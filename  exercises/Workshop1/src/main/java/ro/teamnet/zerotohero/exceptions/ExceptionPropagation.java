package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Bogdan on 10/28/2014.
 */
public class ExceptionPropagation
{
    public void throw1() throws MyException
    {
        throw2();
    }

    public void throw2() throws MyException
    {
        throw3();
    }

    public void throw3() throws MyException
    {
        throw new MyException("Starting point");
    }
    public static void main(String[] args)
    {
        ExceptionPropagation ep = new ExceptionPropagation();
        try
        {
            ep.throw1();
        }
        catch (MyException e)
        {
            e.printStackTrace();
        }
    }
}
