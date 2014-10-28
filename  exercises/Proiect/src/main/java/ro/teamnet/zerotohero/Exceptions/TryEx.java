package ro.teamnet.zerotohero.Exceptions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by ovy on 10/28/2014.
 */
public class TryEx {
    public static void main(String args[]){
        try{
            BufferedReader br =new BufferedReader(new FileReader("C:\\Users\\ovy\\Desktop\\nuuia.txt"));
            System.out.println(br.readLine());
        }
        catch(Exception e){

        }
    }
}
