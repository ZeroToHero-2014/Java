package ro.teamnet.zerotohero.reflection.api;
import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.annotation.Annotation;

public class DbManager {
    public void insertobject (Object obj) throws Exception{
        Class c = obj.getClass();
        Annotation a = c.getAnnotation(Table.class);
        if (a == null){
            throw new Exception("Invalid");
        }
        Employee emp = new Employee();
        emp.nume="John";

    }

    public static void main(String[] args) {
        DbManager q = new DbManager();
        Employee employee = new Employee();
    }
}