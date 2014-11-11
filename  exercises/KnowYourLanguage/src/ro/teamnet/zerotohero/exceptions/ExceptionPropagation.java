package ro.teamnet.zerotohero.exceptions;

public class ExceptionPropagation {

    public static void main(String[] args) throws MyException{
        ExceptionPropagation prop= new ExceptionPropagation();
        prop.throw1();
    }
    public void throw1() throws MyException{
        throw2();
    }
    public void throw2() throws MyException{
        throw3();

    }
    public void throw3() throws MyException{
        throw new MyException("exceptie 3");
    }
}