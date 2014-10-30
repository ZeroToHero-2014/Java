package ro.teamnet.zerotohero.threads.counter;

public class CounterInc {
    public static void main(String[] args){

        final CounterClass c=new CounterClass();

        Thread t= new Thread(){
            public void run(){
                c.increment();
                c.increment();
            }
        };

        Thread t1= new Thread(){
            public void run(){
                c.increment();
                c.increment();
            }
        };

        t.start();
        t1.start();
    }
}
