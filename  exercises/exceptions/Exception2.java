package exceptions;

/**
 * Created by andrei.dobre on 28.10.2014.
 */
public class Exception2 {

    public static void main(String[] args) throws myException{

        Exception2 a = new Exception2();
        a.throw1();
    }

    public void throw1() throws myException{
        throw2();

    }

    public void throw2() throws myException

    {
        throw3();
    }

        public void throw3() throws myException{
        throw new myException("text");
    }

    }
