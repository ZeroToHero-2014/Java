package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class NestedExceptions {

    public static void main(String[] args) throws MyException {

        try {
            throw new Exception("Let's do this!");
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new MyException(e);
        }
    }
}