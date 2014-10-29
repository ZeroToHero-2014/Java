package ro.teamnet.zerotohero.threads.thread_creation;

/**
 * Created by user on 10/27/2014.
 */
public class Program {

    public static void main(String[] args) {
        Thread impR = new Thread(new ClasaImplementareRunnable() );
        ClasaMostenireThread mostenireThread = new ClasaMostenireThread() ;



        System.out.println(impR); // afiseasa Thread[ numele, prioritatea si grupul de care apartine


        impR.setName("Thread ce implementeaza Runnable");
        impR.setPriority(2);
        System.out.println("Thread runnable inainte de schimbare nume " + impR);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread schimbare nume si priorirtate") ;
            }
        });

        System.out.println(t1);

        t1.setName("Nume thread");
        t1.setPriority(4);

        System.out.println(t1);
        t1.start();
        impR.start();
        mostenireThread.start();

    }

   private static int counter = 0;

//    public static  synchronized int getCounter() {
//        return counter;
//    }
//
//    public static synchronized void setCounter(int counter) {
//        Program.counter = counter;
//    }
}
