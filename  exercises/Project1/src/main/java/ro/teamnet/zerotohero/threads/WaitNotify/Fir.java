package ro.teamnet.zerotohero.threads.WaitNotify;

/**
 * Created by Mihai on 10/29/2014.
 */
public class Fir implements  Runnable{

    static int i = 0;
    static int limita = 100;
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


            while(i<limita) {

                if(i%2==r) {
                    i++;
                    System.out.println("Thread " + id + " : " + i);
                    o.notify();
                }
                while(i%2!=r  && i<limita ){
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
