package ro.teamnet.zerotohero.reflection.api;

import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.reflect.Field;

/**
 * Created by user on 10/28/2014.
 */
public class DBManager {

    public static void insert (Object ins) throws IllegalAccessException {

        if (ins.getClass().getAnnotation(Table.class) == null) {
            throw new IllegalArgumentException();
        }

        ((Table) ins.getClass().getAnnotation(Table.class)) .tabel();
        System.out.println(((Table) ins.getClass().getAnnotation(Table.class)) .tabel());

       Field[] fields= ins.getClass().getFields();

        for(Field field: fields) {
            ((Column) field.getAnnotation(Column.class)) .coloana();
            System.out.print(((Column) field.getAnnotation(Column.class)).coloana()+" ");
            System.out.println(field.get(ins));
        }


    }


    public static void main(String[]args){
        Employee employee=new Employee();
        employee.name="Jon";
        employee.job="Driver";

        try {
            insert(employee);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
