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
    private final static String USERNAME = "ZTH_18";
    private final static String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {
        Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
       // DatabaseManager.checkConnection(con);

      //create table
        HashMap<String, String> createTableTest = new HashMap<String, String>();

            createTableTest.put("coloana1", "VARCHAR2(10) PRIMARY KEY");
            createTableTest.put("coloana2", "NUMBER(10)");
      // create table
      //  DatabaseManager.create(con, "Test", createTableTest);
      // drop table
      //  DatabaseManager.drop(con, "Test");
      // close conncection
        DatabaseManager.closeConnection(con);
    }




}
