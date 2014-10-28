package ro.teamnet.zerotohero.reflection.api;

import com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationException;
import ro.teamnet.zerotohero.reflection.model.Employee;

import java.lang.reflect.Field;

/**
 * Created by George on 10/28/2014.
 */
public class DBManager {

    public static void insert(Object o){
        if (o.getClass().getAnnotation(Table.class) == null)
            throw new IllegalArgumentException();

        // afisare nume tabela - trebuie sa ii facem cast la TABLE
//        System.out.println(((Table) o.getClass().getAnnotation(Table.class)).nameTable());
        ((Table) o.getClass().getAnnotation(Table.class)).nameTable();

        // lista cu toate field-urile obiectului "o"
        Field[] fields =  o.getClass().getFields();

        // luam anotarile fiecarui field si ii afisam valorile
        // trebuie sa ii facem cast la Column
        for(Field f : fields){
//            System.out.println(((Column)f.getAnnotation(Column.class)).nameColumn());
            ((Column)f.getAnnotation(Column.class)).nameColumn();

            try {
                //
                System.out.println(f.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.name = "Employee" + i;
            emp.job = "job" + i;
            insert(emp);
        }
    }
}
