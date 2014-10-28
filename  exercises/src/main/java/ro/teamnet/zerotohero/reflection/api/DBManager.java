package ro.teamnet.zerotohero.reflection.api;

import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.annotation.Annotation;

/**
 * Created by Juvie on 28.10.2014.
 */
public class DBManager {

    public void insertObject (Object o) throws Exception {
        Class c = o.getClass();
        Annotation a =  c.getAnnotation(Table.class);
        if ( a == null){
            throw new Exception("Invalid insert");
        }
        Employee e = new Employee();
        e.name = "Andrei";
        e.salary = 2.2f;

    }

    public static void main(String[] args) throws Exception {
        DBManager dbm = new DBManager();
        Employee e = new Employee();
        dbm.insertObject(e);

    }
}
