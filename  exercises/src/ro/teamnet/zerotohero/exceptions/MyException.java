package ro.teamnet.zerotohero.exceptions;

public class MyException extends Exception{
    public MyException(){
        super();
    }

    public MyException(String exc){
        super(exc);
    }

    public static void main(String[] args){
        try{
            throw new MyException("exceptie 1");
        }
        catch(MyException e){
            e.printStackTrace();
        }
        }
    public MyException(Exception e){
        super(e);
    }
}
