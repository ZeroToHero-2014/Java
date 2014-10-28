package ro.teamnet.zerotohero.reflection.api.model;

import ro.teamnet.zerotohero.reflection.api.Table;

import java.lang.annotation.Annotation;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class DBmanager {

    Object obj;
    public Object insert() throws Exception {

        Employee emp = new Employee();
        emp.fName = "ceva";
        emp.lName = "alt";
        emp.job = "bucatar";
        emp.department = "10";

        Class cls = emp.getClass();
        Annotation an = cls.getAnnotation(Table.class);

        if(an == null) {
            throw new Exception("Invalid insert!");
        } else {
            System.out.println(an);
        }

        return obj;
    }

    public static void main(String[] args) throws Exception {

        DBmanager db = new DBmanager();
        db.insert();
    }
}
