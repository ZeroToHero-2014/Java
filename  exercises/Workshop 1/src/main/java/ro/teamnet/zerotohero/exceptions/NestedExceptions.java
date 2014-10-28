package ro.teamnet.zerotohero.exceptions;


public class NestedExceptions {
    public static void main(String[] args) throws MyException{
        try {
            throw new Exception("Mesaj (nested)");
        }

        catch(Exception e) {
            e.printStackTrace();
            throw new MyException(e);
        }
    }
}
