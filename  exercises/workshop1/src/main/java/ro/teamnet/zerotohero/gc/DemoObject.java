package ro.teamnet.zerotohero.gc;

/**
 * Created by Andrei on 10/27/2014.
 */
public class DemoObject {
    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject() {
        this.objectRef = this.toString();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<bufferSize; i++){
            sb.append('a');
        }
        temp = sb.toString();
        count++;
        System.out.println(this.toString()+ ":" + count);

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        count--;
        System.out.println(this.toString() + ":" +count);
    }
}
