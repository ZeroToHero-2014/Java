package ro.teamnet.zerotohero.reflection.api;

import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Buli on 28.10.2014.
 */
public class DBManager {

    public static void insert(Object o){
        if(o.getClass().getAnnotation(Table.class).tableName() == null && o.getClass().getAnnotation(Column.class).columnName() == null)
                throw new IllegalArgumentException();

        Table table = o.getClass().getAnnotation(Table.class);
        System.out.println("Table name: " + table.tableName());

        Field[] columns = o.getClass().getFields();
        for(Field column:columns){

            Column c = (Column) column.getAnnotation(Column.class);
            System.out.println(c.columnName());

            try {
                System.out.println(column.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] Args){
        Employee emp = new Employee();
        emp.name = "Ion";
        emp.job = "CEO";

        insert(emp);
    }
}
