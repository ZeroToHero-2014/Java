package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by andrei.dobre on 28.10.2014.
 */
public class TryExemples {

    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\andre_000\\Desktop\\ZeroToHero\\marti\\test.txt"))) {
            System.out.println(br.readLine());
        }

         catch(IOException e) {
            e.printStackTrace();
        }

    }
}


