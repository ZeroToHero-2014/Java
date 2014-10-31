package ro.teamnet.zerotohero.threads.thread;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Andrei on 10/30/2014.
 */
public class Main {
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
    static String error1(String path)  {
    try{
        throw new IOException();
        throw  new Exception();
    }catch(IOException e){
        System.out.println(e);
     }
     catch(Exception e){
         System.out.println(e);
     }finally {
        System.out.println("Se executa indiferent ce");
    }


    }
    public static void main(String[] args){

        MyExceptionTest myExceptionTest = new MyExceptionTest();

        try {
            myExceptionTest.myTException();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new Exception();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        //Numarator sincronizat
        Thread thread1 = new Class1();
        Thread thread12 = new Class1();
        Thread thread13 = new Class1();

        thread1.start();
        thread12.start();
        thread13.start();

        thread1.setName("firstThread");
        thread1.setPriority(Thread.MAX_PRIORITY);
        Thread thread2 = new Thread(new Class2());
        thread2.start();
    }


}
class MyExceptionTest{
    public  void myTException () throws Exception{

        throw  new Exception();
    }
}
