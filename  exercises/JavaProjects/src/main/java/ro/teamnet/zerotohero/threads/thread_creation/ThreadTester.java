package ro.teamnet.zerotohero.threads.thread_creation;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class ThreadTester {

    public static void main(String[] args) {

        MyFirstThread mft = new MyFirstThread();
        mft.setName("Ronaldo");

        // 1 slab / 10 important
        mft.setPriority(10);

        mft.start();
        //datele despre thread
        System.out.println(mft);
    }
}