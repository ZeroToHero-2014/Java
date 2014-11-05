package ro.teamnet.zth;

import oracle.jdbc.pool.OracleDataSource;
import ro.teamnet.zth.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String USERNAME ="ZTH_15";
    private static final String PASSWORD="passw0rd";

    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
       Connection con = DatabaseManager.getConnection(USERNAME,PASSWORD);
      DatabaseManager.checkConnection(con);
       DatabaseManager.checkConnection2(con);

        HashMap <String,String> createTableLocation = new HashMap<String, String>();

//           createTableLocation.put("location_id", "Varchar2 (2) Primary Key");
//           createTableLocation.put("location_name", "Varchar2 (20)");
//           DatabaseManager.create(con, "location", createTableLocation);
             DatabaseManager.drop(con,"LOCATION");


        DatabaseManager.closeConnection(con);
    }
}
