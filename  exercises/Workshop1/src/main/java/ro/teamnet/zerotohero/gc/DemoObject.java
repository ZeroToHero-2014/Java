package ro.teamnet.zerotohero.gc;

/**
 * Created by Bogdan on 10/27/2014.
 */
public class DemoObject
{
    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject()
    {
        this.objectRef = this.toString();
        StringBuilder sb = new StringBuilder();
        count++;
        for (int i=0; i < bufferSize; i++)
        {
            sb.append("e");
            temp = sb.toString();
        }
        System.out.println("Construct" +count);

    }

    @Override
    protected void finalize() throws Throwable
    {
        count--;
        System.out.println("Distruct" + count);
    }
}
