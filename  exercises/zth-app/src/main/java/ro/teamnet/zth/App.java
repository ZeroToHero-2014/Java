package ro.teamnet.zth;

import java.sql.Connection;
import java.util.HashMap;

import ro.teamnet.zth.utils.DatabaseManager;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final String USERNAME = "ZTH_01";
    private static final String PASSWORD = "passw0rd";
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Connection con = null;

        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("id", "number primary key");
        hashMap.put("first_name", "varchar2(40) not null");
        hashMap.put("last_name", "varchar2(40) not null");
        hashMap.put("phone_number", "varchar2(35)");

        con = DatabaseManager.getConnection(USERNAME,PASSWORD);
        DatabaseManager.checkConnection(con);
        DatabaseManager.getFirstRow(con);
//        DatabaseManager.create(con,"test_jdbc",hashMap);
//        DatabaseManager.drop(con,"test_jdbc");
        DatabaseManager.closeConnecction(con);

    }
}
