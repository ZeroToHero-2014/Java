package ro.teamnet.zerotohero.pc;

/**
 * Created by user on 10/27/2014.
 */
public class DemoObject {
    private static final int bufferSize=10000;
    private String temp;
    private String objectRef;
    private static int count=0;


    public DemoObject(){

        this.objectRef=this.toString();

        StringBuilder anyString=new StringBuilder();

        for(int i=0;i<bufferSize;i++){
            anyString.append("AA");
        }
        this.count++;
        this.temp=anyString.toString();

        if(count>5){
            System.gc();
            System.out.println("GC A RULAT");
        }
    }

    protected void finalize() throws Throwable{
        super.finalize();
        count--;
        System.out.println("Count: "+count);
    }
}
