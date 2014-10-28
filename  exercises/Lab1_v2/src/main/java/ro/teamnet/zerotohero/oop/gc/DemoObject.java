package ro.teamnet.zerotohero.oop.gc;

/**
 * Created by Computer on 10/27/2014.
 */
public class DemoObject {
    private static final int bufferSize=100000;
    private String temp;
    private  String objectRef;
    private static int count =0;

    public DemoObject()
    {
    this.objectRef=this.toString();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<bufferSize; i++)
        {
            sb.append('a');

        }
        temp = sb.toString();
        count++;
        System.out.println("Count created "+count);
    }

    @Override
    protected void finalize() throws Throwable {
        count--;
        System.out.println("Count destroyed "+count);
    }
}
