package ro.teamnet.zerotohero.Exceptions;

/**
 * Created by ovy on 10/28/2014.
 */
public class NestedExceptions {

    public static void main(String args[])throws Exceptions{
        try{
            throw new Exception("Exce!!");
        }
        catch(Exception e){
            e.printStackTrace();
            throw new Exceptions(e);
        }
    }
}
