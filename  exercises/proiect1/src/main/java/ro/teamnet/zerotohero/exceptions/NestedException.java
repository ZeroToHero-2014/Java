package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Miha on 10/28/2014.
 */
public class NestedException {
    public static void main(String[] args) throws MyException {
        try{
            throw new Exception("Exceptie imbricata!");
        }catch(Exception e){
            e.printStackTrace();
            throw new MyException(e);  //trimit exceptia mai departe in MyException
        }
    }
}
