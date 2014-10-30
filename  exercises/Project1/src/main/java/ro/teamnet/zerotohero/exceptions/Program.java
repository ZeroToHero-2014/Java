package ro.teamnet.zerotohero.exceptions;

import java.io.*;

/**
 * Created by Mihai on 10/30/2014.
 */
public class Program {


    public static void main(String[] args) {


        try {
            evalueaza('\\', 2, 3);
        } catch (ExceptieOperatie exceptieOperatie) {
            exceptieOperatie.printStackTrace();
        }
        try {
            evalueaza('+', 2, 3);
        } catch (ExceptieOperatie exceptieOperatie) {
            exceptieOperatie.printStackTrace();
        }


        try {
            evalueaza('\\', 5, 0);
        } catch (RuntimeException | ExceptieOperatie exceptieOperatie) { //multicatch
            exceptieOperatie.printStackTrace();
        }


        try {
            evalueaza2('\\', 7, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //pt exemplificare bloc try finally
        System.out.println("Rezultatul adunarii 2 si 3 este " + adunare(2,3));




        //try catch finally si try with resources - folosirea unui buffered reader pt preluarea date din fisier csv
        System.out.println("Preluare date csv folosind Try Catch Finally : ");
        BufferedReader br = null;
        String cale = "src\\main\\java\\ro\\teamnet\\zerotohero\\exceptions\\date.csv";
        try {
            br = new BufferedReader(new FileReader(cale));
            String linie;
            int j = 0;
            while ((linie = br.readLine()) != null) {
                System.out.print("\n Linia " + ++j + ": ");
                String[] val = linie.split(",");
                for (int i = 0; i < val.length; i++) {
                    System.out.print(val[i] + " ");
                }
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        System.out.println("\n Try with resources ");
        //BufferedReader implementeaza interfata AutoCloseable asa ca poate fi folsoit de try with resources (nu mai trebuie sa-l inchidem noi)
            try (BufferedReader br2 =
                     new BufferedReader(new FileReader(cale))) {
            String linie;
            int j = 0;
            while ((linie = br2.readLine()) != null) {
                String[] val = linie.split(",");
                System.out.print("\n Linia " + ++j + " : ");
                for (int i = 0; i < val.length; i++)
                    System.out.print(val[i] + " ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        //3 - Exemplu -  propagare a exceptie - impartire - e aruncata, nu e prinsa in evalueaza si ajunge in main
    static void evalueaza(char op,int a,int b) throws ExceptieOperatie {
    if(op=='\\')
        System.out.println("Rezultatul impartirii lui " + a + " la " + b +  "este " + impartire(a,b));
        else
        System.out.println("Operatie Necunoscuta");
    }

    static double impartire(int a, int b) throws ExceptieOperatie {
    if(b!=0)
        return (float)a/b;
        else
        throw new  ExceptieOperatie('\\',a,b); //2 - Exeemplu aruncare exceptie
    }


    //4 - Exceptie Nested
    static void evalueaza2(char op,int a,int b) throws Exception {


    if(op=='\\')
        try {
            System.out.println("Rezultatul impartirii lui " + a + " la " + b +  "este " + impartire(a,b));
        } catch (ExceptieOperatie exceptieOperatie) {
            throw new Exception("Impartire la 0!",exceptieOperatie);        }
    else
            System.out.println("Operatie Necunoscuta");}


    //try finally
static long adunare(int a,int b){
try{
    return a+b;

}finally {
    System.out.println("Blocul de finally (din adunare) se executa!");
}
}

    }
