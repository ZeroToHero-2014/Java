package ro.teamnet.zerotohero.exceptions;


public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String s) {
        super(s);
    }

    public static void main(String[] args) {
        try {
            throw new MyException("Exceptie:");
        }

        catch (MyException e) {
            e.printStackTrace();
        }
    }

    public MyException(Exception e){
        super (e);
    }
}

