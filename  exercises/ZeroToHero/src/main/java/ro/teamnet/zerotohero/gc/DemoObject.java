package ro.teamnet.zerotohero.gc;

/**
 * Created by user on 10/27/2014.
 */
public class DemoObject {
    private static final int bufferSize = 10000;
    private String temp;
    private String objectRef;
    private static int count=0;

    public DemoObject() {
        this.objectRef = this.toString();
        StringBuilder stb = new StringBuilder(bufferSize);


        for (int i = 0; i <bufferSize; i++) {
            stb.append('a');


        }
        count++;
        if(count>5)
            System.gc();

        System.out.println("Increment:"+count);
        this.temp=stb.toString();
        this.objectRef=stb.toString();
    }

    protected void finalize() throws Throwable {

            super.finalize();
            count--;
            System.out.println("Decrement"+count);

    }
}