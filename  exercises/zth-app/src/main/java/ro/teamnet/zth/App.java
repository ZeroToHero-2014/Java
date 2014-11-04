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
    private static final String USERNAME = "ZTH_10";
    private static final String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {

        System.out.println( "Starting ZTH JDBC Tutorial" );

        //Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
        Connection con = DatabaseManager.getConnectionClassforName(USERNAME, PASSWORD);
        //Connection con = DatabaseManager.getConnectionRegisterDriver(USERNAME, PASSWORD);

        DatabaseManager.checkConnection(con);

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("String", "varchar(244)");
        map.put("Numar", "number(10)");


        //DatabaseManager.create(con, "NewMap", map);

        DatabaseManager.drop(con, "NewMap");
    }
}
