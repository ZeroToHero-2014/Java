package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by user on 10/27/2014.
 */
public class Manager {


    public static void main(String[] args) {
   /*     Employ t = new Employ();

        Class e = t.getClass();

        Annotation[] an = e.getAnnotations();

        for (int i=0;i <an.length;i++){
            System.out.println(an[i].toString());
            Table tb = (Table)an[i];
            System.out.println(tb.name());
        }

        Annotation[] an2 = e.getDeclaredAnnotations();

        for (int i=0;i <an.length;i++){
            System.out.println(an2[i]);
        }

       Field[] mf = e.getDeclaredFields();

        for(int i=0;i < mf.length;i++)
        {
            Annotation[] c = mf[i].getAnnotations();
            for(int j=0;j<c.length;j++)
            System.out.println(c[j]);}

        System.out.println("\n \n \n");
*/
        Employ a = new Employ("Marius","Sofer");

        Class clasa = a.getClass();

        String tabel;
        String[] col,valori;
       Table tr;

       tabel =  ((Table)clasa.getAnnotation(Table.class)).name();
        Field[] campuri =clasa.getDeclaredFields();
       col = new String[campuri.length];
        valori = new String[col.length];

        for(int i=0;i<campuri.length;i++){
          col[i] = ((Column)campuri[i].getAnnotation(Column.class)).name();
            try {
                valori[i] = (String)campuri[i].get(a);
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

        StringBuilder statement =new StringBuilder( " Insert into " + tabel + " (");
        //System.out.println("Nume tabel: " + tabel);

        for(int i=0;i<col.length;i++) {
          statement.append( col[i]);
//            System.out.println("Nume coloane: " + col[i]);
            if(i!=col.length-1)
                statement.append(",");

        }

        statement.append(") Values ( ");

        for(int i=0;i<valori.length;i++)
        {
               statement.append( valori[i]);
                if(i!=valori.length-1)
                    statement.append(",");
            }

        statement.append(")");

        System.out.println(statement);

    }
}
