package ro.teamnet.zerotohero.gc;

/**
 * Created by user on 10/26/2014.
 */

    public class DemoObject {

        private static final int bufferSize = 100000;
        private String temp;
        private String objectRef;
        private static int count = 0;

        public DemoObject() {

            StringBuilder sb = new StringBuilder(); //bufferSize);

            for(int i=0;i<bufferSize;i++)
                sb.append('a');
            this.temp = sb.toString();
            this.objectRef = this.toString();
            count++;
//            System.out.println("Nr obiecte : " + count);
//            if(count>5){
//            System.gc();
//            }
        }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        count--;
        System.out.println("Nr obiecte : " + count);
    }


}
