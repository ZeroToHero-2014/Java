package ro.teamnet.zerotohero.gc;

/**
 * Created by Dumitru on 27.10.2014.
 */
public class DemoObject {

    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject() {
        this.objectRef = this.toString();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bufferSize; i++){
            sb.append("A");
        }
        this.temp = sb.toString();
        this.count++;
        System.out.println("INC " + this.count);
    }

    /* rulat automat cand GC isi face treaba */
    @Override
    protected void finalize() {
        this.count--;
        System.out.println("DEC " + this.count);
    }
}
