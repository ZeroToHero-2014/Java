package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Bogdan on 10/28/2014.
 */
public class NestedExceptions
{
    public static void main(String[] args) throws MyException {
        try
        {
            throw new Exception("Exceptie!!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new MyException(e);
        }
    }
}
