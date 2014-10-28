package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Miha on 10/28/2014.
 */
public class MyException extends Exception {
    public MyException(){
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Exception e){
        super(e);
    }

    public static void main(String[] args) {
        try{
            throw new MyException("Exceptie aruncata!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
