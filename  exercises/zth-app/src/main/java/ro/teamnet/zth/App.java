package ro.teamnet.zth;


import ro.teamnet.zth.utils.DatabaseManager;


import java.sql.Connection;
import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    private static final String USER = "ZTH_16";
    private static final String PASS = "passw0rd";


    public static void main(String[] args) {
        Connection con = DatabaseManager.getConnection(USER, PASS);


      //  DatabaseManager.checkConnection(con);


        HashMap<String, String> mapTest = new HashMap<String, String>();

        mapTest.put("TEST1", "VARCHAR2(10) PRIMARY KEY");
        mapTest.put("TEST2", "NUMBER(6)");
        mapTest.put("TEST3", "NUMBER(6)");

       // DatabaseManager.create(con, "TEST", mapTest);

        // DatabaseManager.drop(con,"TEST");


        DatabaseManager.closeConnection(con);
    }
}
