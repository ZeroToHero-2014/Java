package ro.teamnet.zerotohero.reflection.api;

import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.annotation.Annotation;

public class DbManager {

    public void insertObject (Object o) throws Exception {
        Class c = o.getClass();
        Annotation a = c.getAnnotation(Table.class);
        if ( a == null ) {
            throw new Exception("Invalid insert");
        }

        Employee emp = new Employee();
        emp.nume = "Daniel";
        emp.job = "Student";
    }

    public static void main(String[] args) {
        DbManager manag = new DbManager();
        Employee emp = new Employee();
    }
}
