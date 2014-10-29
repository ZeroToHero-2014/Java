package ro.teamnet.zerotohero.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Bogdan on 10/28/2014.
 */
public class TryExamples
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("F:\\ZeroToHero\\Workshop1\\1.txt")))
        {
            System.out.println(br.readLine());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
