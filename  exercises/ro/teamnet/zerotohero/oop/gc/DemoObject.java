package ro.teamnet.zerotohero.oop.gc;

/**
 * Created by andrei.dobre on 27.10.2014.
 */
public class DemoObject {

    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;



    public DemoObject() {
        this.objectRef = this.toString();
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < bufferSize; i++) {
            a.append("a");
        }
        temp = a.toString();
        count++;

        System.out.println("counter-ul creste: " + count);

        }
    protected void finalize() throws Throwable {
        count--;
        System.out.println("counter-ul descreste: " + count);
    }

    }

