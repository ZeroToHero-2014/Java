package ro.teamnet.zerotohero.gc;

/**
 * Created by Juvie on 28.10.2014.
 */
public class DemoObject {
    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject(){
            StringBuilder sb = new StringBuilder(bufferSize);
            for (int i=0; i<bufferSize; i++){
                sb.append('M');
            }
            this.temp = sb.toString();
            this.count++;
            System.out.println("S-a creat a noua instanta! Acum sunt " + this.count);
            this.objectRef = this.toString();
            if(this.count >=5)
                System.gc();
    }

    @Override
    protected void finalize() throws Throwable { //e apelata cand ruleaza GC pe instanta respectiva
        super.finalize();
        this.count--;
        System.out.println("O instanta a murit! Acum sunt " + this.count);
    }
}