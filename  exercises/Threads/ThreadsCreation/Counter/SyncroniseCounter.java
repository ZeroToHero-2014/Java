package Threads.ThreadsCreation.Counter;

/**
 * Created by andrei.dobre on 28.10.2014.
 */
public class SyncroniseCounter {

    public static void main(String arg[]){

        final CounterClass a1 = new CounterClass();

        Thread t1 = new Thread(){



            public void run(){
/*
                int count = 0;
                count++;
                System.out.println("numarul la care a ajuns counter-ul este: " + count);
                count++;
                System.out.println("numarul la care a ajuns counter-ul este: " + count);

*/

                a1.increment();
                a1.increment();



            }
        };

        Thread t2 = new Thread(){

            public void run(){

   /*             int count = 0;
                count++;
                System.out.println("numarul la care a ajuns counter-ul este: " + count);
                count++;
                System.out.println("numarul la care a ajuns counter-ul este: " + count);
*/

                a1.increment();
                a1.increment();
            }
        };

        t1.start();
        t2.start();
    }
}
