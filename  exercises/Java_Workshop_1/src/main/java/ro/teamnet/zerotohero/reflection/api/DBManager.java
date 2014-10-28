package ro.teamnet.zerotohero.reflection.api;

import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.reflect.Field;

/**
 * Created by user on 10/28/2014.
 */
public class DBManager {
    static void insert(Object o){
       if( o.getClass().getAnnotation(Table.class)==null){
           throw new IllegalArgumentException();
       }
        System.out.println(((Table) o.getClass().getAnnotation(Table.class)).someValue()+":");
        Field[] fields= o.getClass().getFields();

        for(Field f:fields){
        System.out.print(((Column) f.getAnnotation(Column.class)).anotherValue()+": ");

            try {
                System.out.println(f.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println("\n");

        }


    }

    public static void main(String[] args){
        Employee emp = new Employee();
        emp.name="Ben";
        emp.job="AAA";

        Employee emp1= new Employee();
        emp1.name="George";
        emp1.job="BBB";

        insert(emp);
        insert(emp1);

    }
}
