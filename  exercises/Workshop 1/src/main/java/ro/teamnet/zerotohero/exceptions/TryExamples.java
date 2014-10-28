package ro.teamnet.zerotohero.exceptions;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryExamples {


    public static void main(String[] args) {
        try (BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Ifrim\\IdeaProjects\\Workshop 1\\text.txt"))) {
         System.out.println(br.readLine());
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}