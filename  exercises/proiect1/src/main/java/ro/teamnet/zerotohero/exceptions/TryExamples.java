package ro.teamnet.zerotohero.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Miha on 10/28/2014.
 */
public class TryExamples {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Miha\\IdeaProjects\\proiect1\\src\\main\\java"))){
            System.out.println(br.readLine());
        }catch(Exception e){

        }finally{

        }
    }
}
