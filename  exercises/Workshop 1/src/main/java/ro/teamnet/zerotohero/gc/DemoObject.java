package ro.teamnet.zerotohero.gc;

public class DemoObject {
    private static final int bufferSize=100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject(){
        this.objectRef=this.toString();
        StringBuilder sb = new StringBuilder();
        count++;
        for (int x=1; x<bufferSize; x++)
        {
            sb.append('a');
        }
        temp = sb.toString();
    }
    @Override
    protected void finalize() throws Throwable {
        count--;
        System.out.println("Count:" + count);
    }
    }
