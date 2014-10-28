package ro.teamnet.zerotohero.gc;

import java.awt.*;

/**
 * Created by ovy on 10/27/2014.
 */
public class DemoObject {

    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject() throws Throwable {
        this.objectRef = this.toString();
        StringBuilder tm = new StringBuilder();
        for (int i = 0; i < bufferSize; i++) {
            tm.append("c");
        }
        temp=tm.toString();
        count++;
        System.out.println(count);
        if(count ==5 ){
            this.finalize();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        count--;
    }
}
