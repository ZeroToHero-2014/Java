package ro.teamnet.zerotohero.gc;

import java.lang.management.GarbageCollectorMXBean;

/**
 * Created by Buli on 27.10.2014.
 */
public class DemoObject {

    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject() {
        this.objectRef = this.toString();
        StringBuilder s = new StringBuilder();

        for(int i=0; i<bufferSize; i++)
            s.append('a');

        temp = s.toString();

        count ++;
        System.out.println(count);

        if(count>5){
            System.gc();
        }

    }

    @Override
    public void finalize()throws Throwable{
        count --;
        System.out.println(count);
    }
}
