package ro.teamnet.zerotohero.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;

public class TryExamples {
    public void main(String[] args)throws Exception{
        try(BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\Andrey\\IdeaProjects\\src\\src\\ro\\teamnet\\zerotohero\\exceptions\\exceptie.txt"))) {
            System.out.println(br.readLine());
        }
    }
}