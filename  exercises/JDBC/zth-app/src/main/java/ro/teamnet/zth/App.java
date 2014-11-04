package ro.teamnet.zth;

import ro.teamnet.zth.utils.DatabaseManager;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String USERNAME = "ZTH_07";
    public static final String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {

        System.out.println("Starting ZTH JDBC Turorial!" );
        //Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
        //Connection con = DatabaseManager.getConnectionClassForName(USERNAME, PASSWORD);
        Connection con = DatabaseManager.getConnectionDriverRegister(USERNAME, PASSWORD);
        DatabaseManager.checkConnection(con);

        /*HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("FirstName", "varchar2(32 BYTE)");
        hm.put("LastName", "varchar2(32 BYTE)");
        hm.put("ID", "NUMBER");
        String tableName = "NAMES";
        //DatabaseManager.create(con, tableName, hm);
        DatabaseManager.drop(con, tableName);*/
    }
}
