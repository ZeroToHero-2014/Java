package exceptions;

/**
 * Created by andrei.dobre on 28.10.2014.
 */
public class Exception3 {
    public static void main(String[] args) throws myException {

        try{
            throw new myException("text");
        }

        catch(Exception e){
            e.printStackTrace();
            throw new myException(e);
        }

        
    }
}
