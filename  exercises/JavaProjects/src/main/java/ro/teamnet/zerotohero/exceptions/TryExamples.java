package ro.teamnet.zerotohero.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class TryExamples {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("I:\\[From][Zero][To][Hero]\\day7.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}