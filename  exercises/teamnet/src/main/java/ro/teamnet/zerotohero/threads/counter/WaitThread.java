package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by Buli on 28.10.2014.
 */
public class WaitThread {

    public static void main(String[] Args){

        Thread t = new Thread(){
            @Override
            public void run(){
                Counter.increment();
                Counter.increment();
                Counter.increment();
                Counter.increment();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run(){

                Counter.increment();
                Counter.increment();
                Counter.increment();
                Counter.increment();
            }
        };

        t.start();

        try {
            synchronized (t){
                t.setName("Waiting 1");
                t.wait();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();


        System.out.println(t.getName());
        try {
            synchronized (t2){
                t2.setName("Waiting 2");
                t2.wait();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t2.getName());
    }

}
