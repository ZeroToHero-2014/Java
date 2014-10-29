package ro.teamnet.zerotohero.gc;

/**
 * Created by Ilai Hawkeye on 10/27/2014.
 */
public class DemoObject {
    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;



    public DemoObject() {
        this.objectRef = this.toString();
        StringBuilder s= new StringBuilder();
        for (int i=0;i<bufferSize;i++){
            s.append("a");
        }
        temp = s.toString();
        count++;
        System.out.println("Crestere: "+count);
    }
    @Override
    protected void finalize() throws Throwable {
        count--;
        System.out.println("Scadere: "+count);
    }


}
