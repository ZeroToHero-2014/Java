package ro.teamnet.zerotohero.reflection.api;

import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.annotation.Annotation;

/**
 * Created by ovy on 10/28/2014.
 */
public class Insert {
   // public static void main (String args[]){
        public void  insertobj () throws Exception{
            Employee ep = new Employee();
            ep.nume = "eu";
            ep.job="tamplar";
            Class ec=ep.getClass();
            Annotation as = ec.getAnnotation(Table.class);
              // ep.getAnnotations();
            if(ec==null) {
                throw new Exception("invalid");
            }
            else {
                System.out.println(((Table)as).nume());
            }


        }
    public static void main(String args[]) throws Exception{
        Insert in= new Insert();
        in.insertobj();
    }
}
