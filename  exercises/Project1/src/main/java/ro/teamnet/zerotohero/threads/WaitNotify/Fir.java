package ro.teamnet.zerotohero.threads.WaitNotify;

/**
 * Created by Mihai on 10/29/2014.
 */
public class Fir implements  Runnable{

    public static synchronized int getI() {
        return i;
    }

    public static synchronized void incrementI() {
        Fir.i++;
    }

    static int i = 0;
    static final int limita = 100;
    static Object o  = new Object();
    int r;

    public Fir(int id, int r) {
        this.id = id;
        this.r = r;
    }

    int id;

    public Fir(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (o){


            while(getI()<limita) {

                if(getI()%2==r) {
                    incrementI();
                    System.out.println("Thread " + id + " : " + getI());
                    o.notify();
                }
                while(getI()%2!=r  && getI()<limita ){
                    try {

                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


      }

        }
    }
}
