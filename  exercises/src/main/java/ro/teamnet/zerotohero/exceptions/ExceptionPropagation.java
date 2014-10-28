package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Juvie on 28.10.2014.
 */
public class ExceptionPropagation extends Exception {
    public void throw1() throws MyException{
        throw2();
    }

    public void throw2() throws MyException{
        throw3();
    }

    public void throw3() throws MyException{
        throw new MyException("Exceptie propagata!");
    }

    public static void main(String[] args) {
        ExceptionPropagation excp = new ExceptionPropagation();
        try{
            excp.throw1();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}