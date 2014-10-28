package ro.teamnet.zerotohero.thread.thread_creations.Counter;

/**
 * Created by ovy on 10/28/2014.
 */
public class SyncronizeCounter {
    public static void main(String args[]){

        Thread t = new Thread(){ public void run(){
            CounterT nc= new CounterT();
            nc.sy();
            nc.sy();

           /* CounterT.counter++;
            System.out.println("counter = "+CounterT.counter);
            CounterT.counter++;
            System.out.println("counter = "+CounterT.counter);

            CounterT.counter++;
            System.out.println("counter = "+CounterT.counter);
            CounterT.counter++;
            System.out.println("counter = "+CounterT.counter);;*/

        }
        };

        Thread t1 = new Thread(){ public void run(){
            /*CounterT.counter++;
            System.out.println("counter = "+CounterT.counter);
            CounterT.counter++;
            System.out.println("counter = "+CounterT.counter);

            CounterT.counter++;
            System.out.println("counter = "+CounterT.counter);
            CounterT.counter++;
            System.out.println("counter = "+CounterT.counter);;*/
            CounterT nc1= new CounterT();
            nc1.sy();
            nc1.sy();
        }
        };
        t.start();
        t1.start();
    }
}
