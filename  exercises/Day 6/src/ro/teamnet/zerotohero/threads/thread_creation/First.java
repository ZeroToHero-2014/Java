import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Ilai Hawkeye on 10/28/2014.
 */
public class First implements Runnable {

        public static long count = 0;

        public void increment(){
            First.count++;
            System.out.println(First.count + " ");
        }
        public void run() {
        System.out.println("In run method; thread name is: " +
        Thread.currentThread().getName());
        increment();
        increment();
        increment();
        }
        public static void main(String args[]) throws Exception {
            Thread First = new Thread(new First());
            Thread First1 = new Thread(new First());
            Thread First2 = new Thread(new First());
            First.start();
            First1.start();
            First2.start();
            Thread t = new Thread(new First());
            t.setName("First Thread");
            t.setPriority(Thread.MIN_PRIORITY);
            System.out.println(t);
            System.out.println("In main method; thread name is: " +
            Thread.currentThread().getName());
        }
    }

