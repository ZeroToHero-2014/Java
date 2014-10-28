package ro.teamnet.zerotohero.reflection.api;


import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.reflect.Field;

public class DBManager {

    public static void insert(Object obj) throws IllegalAccessException {
        if (obj.getClass().getAnnotation(Table.class) == null) throw new IllegalArgumentException();


        System.out.println(((Table) (obj.getClass().getAnnotation(Table.class))).someValue());

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field f : fields) {
            System.out.println(((Column) (f.getAnnotation(Column.class))).someValue());
            System.out.println(f.get(obj));
    }

    }

    public static void main(String[] args) throws IllegalAccessException {

        Employee emp = new Employee();
        emp.name = "Numele";
        emp.job = "nume job";
        DBManager.insert(emp);
    }
}
