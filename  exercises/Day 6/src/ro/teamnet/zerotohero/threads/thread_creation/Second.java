/**
 * Created by Ilai Hawkeye on 10/28/2014.
 */
public class Second extends Thread {

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
// ignore the InterruptedException - this is perhaps the one of the
// very few of the exceptions in Java which is acceptable to ignore
        }
        System.out.println("In run method; thread name is: " + getName());
    }
    public static void main(String args[]) {
        Thread Second = new Second();
        Second.start();
        System.out.println("In main method; thread name is: " +
                Thread.currentThread().getName());
    }
}



