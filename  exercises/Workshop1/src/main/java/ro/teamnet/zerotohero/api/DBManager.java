package ro.teamnet.zerotohero.api;


import ro.teamnet.zerotohero.model.Employee;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Bogdan on 10/28/2014.
 */
public class DBManager
{
    public static void insertEntity(Object o) throws Exception {
        Class c = o.getClass();
        Annotation a = c.getAnnotation(Table.class);

        if(a == null )
        {
            throw new Exception("illegal argument");
        }
        System.out.println(((Table)a).tableName());
        for (Field field : c.getDeclaredFields())
        {
            System.out.println(field.get(o));
        }

    }

    public static void main(String[] args)
    {
        Employee e = new Employee();
        e.job = "Manager";
        e.name = "Gigel";

       try
       {
           insertEntity(e);
       }
       catch (Exception ex)
       {
           ex.printStackTrace();
       }
    }
}
