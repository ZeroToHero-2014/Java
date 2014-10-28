package ro.teamnet.zerotohero.reflection.api;

import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Miha on 10/28/2014.
 */
public class DBManager {
    public static void insertEntity(Object o) throws Exception{
        Class clasa = o.getClass();
        Annotation a  = clasa.getAnnotation(Table.class);
        if(a == null){
            throw new Exception("Illegal argument!");
        }
        System.out.println(((Table) a).tableName());
        for(Field f: clasa.getDeclaredFields()){
            System.out.println("Campul " + f + " are valoarea " + f.get(o));
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.job = "Team-leader";
        e.varsta = 22;
        try {
            insertEntity(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
