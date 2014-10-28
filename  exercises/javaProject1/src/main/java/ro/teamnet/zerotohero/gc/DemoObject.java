package ro.teamnet.zerotohero.gc;

public class DemoObject {

    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject() {
        this.objectRef = this.toString();
        StringBuilder aux = new StringBuilder();
        count++;
        for (int a = 0; a < bufferSize; a++) {
            aux.append("a");
            temp = aux.toString();
        }

        System.out.println("c"+count);
    }



    protected void finalize() throws Throwable {
        count--;
        System.out.println("d"+count);
    }
}