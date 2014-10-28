package ro.teamnet.zerotohero.Exceptions;

/**
 * Created by ovy on 10/28/2014.
 */
public class Exceptions extends Exception {
    public Exceptions(){
        super();
    }
    public Exceptions(String s){
        super(s);
    }
    public Exceptions(Exception e){
        super(e);
    }
    public static void main(String args[]){
        try{
          throw new Exceptions("Exceptie!");
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println(e);
        }
    }
}
