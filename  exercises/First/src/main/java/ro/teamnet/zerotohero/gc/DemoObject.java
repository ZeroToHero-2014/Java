package ro.teamnet.zerotohero.gc;

/**
 * Created by George on 10/27/2014.
 */
public class DemoObject {
    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject() {
        this.objectRef = this.toString();

        StringBuilder myString = new StringBuilder();
        for (int i = 0; i < bufferSize; i++)
            myString.append(i);

        this.temp = myString.toString();

        // 5.	Update variable count
        count++;
        System.out.println("Count: " + count);

        // 7.	Force GC to run after more than 5 instances of DemoObject are created.
        if (count > 5)
            System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        count--;
    }
}
