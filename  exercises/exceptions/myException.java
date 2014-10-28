package exceptions;

/**
 * Created by andrei.dobre on 28.10.2014.
 */
public class myException extends Exception {

    public myException()
    {
        super();
    }



    public myException(String x) {
        super(x);
    }

    public myException(Exception e){
        super(e);

    }

    public static void main() {
        try {
           throw new myException("text");
        }
        catch(myException e) {
            e.printStackTrace();
        }
    }
}
