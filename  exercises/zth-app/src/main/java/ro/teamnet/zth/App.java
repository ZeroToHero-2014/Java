package ro.teamnet.zth;

import ro.teamnet.zth.utils.DatabaseManager;

import java.sql.Connection;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App
{
    private static final String USERNAME = "ZTH_13";
    private static final String PASSWORD ="passw0rd";


    public static void main( String[] args )
    {

        System.out.println( "Whats the date?" );


        DatabaseManager dbm = new DatabaseManager();
        Connection connection=dbm.getConnection(USERNAME,PASSWORD);
        dbm.checkConnection(connection);
        dbm.getFirst(connection);


        HashMap<String,String> myMap = new HashMap<String, String>();
        myMap.put("random_name_1","VARCHAR2(10) PRIMARY KEY");
        myMap.put("random_name_2","VARCHAR2(35) NOT NULL");

        //dbm.create(connection, "MYTABLE", myMap);
        dbm.drop(connection,"MYTABLE");


        dbm.closeConnection(connection);

    }
}
