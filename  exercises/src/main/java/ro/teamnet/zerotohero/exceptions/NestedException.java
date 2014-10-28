package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Juvie on 28.10.2014.
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