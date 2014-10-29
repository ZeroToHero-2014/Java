package ro.teamnet.zerotohero.threads.WaitNotify;

/**
 * Created by Mihai on 10/29/2014.
 */
public class Program {

    public static void main(String[] args) {

        //primul parametru e numele threadulu, al doilea e restul la impartirea la 2 pt care sa incrementeze
        new Thread(new Fir(1,0)).start();
        new Thread(new Fir(2,1)).start();
        System.out.println("a");

        //Fiecare thread il mareste pe i doar atunci cand are restul potrivit la impartirea cu 2 si apoi cedeaza celuilalt thread
        /* Practic fiecare thread va incremeneta cu o unitate numarul si apoi va ceda accesul.
        De exemplu pt limita de 10 vom aveam:
                    Thread 1 : 1
                    Thread 2 : 2
                    Thread 1 : 3
                    Thread 2 : 4
                    Thread 1 : 5
                    Thread 2 : 6
                    Thread 1 : 7
                    Thread 2 : 8
                    Thread 1 : 9
                    Thread 2 : 10


         */


    }
}
