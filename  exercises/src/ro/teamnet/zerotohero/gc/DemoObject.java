package ro.teamnet.zerotohero.gc;

public class DemoObject {

    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject() {
        this.objectRef = this.toString();
        for (int i=0; i<bufferSize; i++) {
            count++;
            temp=temp.concat("a");
        }
    }
    protected void finalize(DemoObject dem){
        count--;
    }
}
