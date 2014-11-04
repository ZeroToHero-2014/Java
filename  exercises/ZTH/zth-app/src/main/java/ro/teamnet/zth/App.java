package ro.teamnet.zth;

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
    private static  final String USERNAME="ZTH_04";
    private static  final String PASSWORD="passw0rd";
    public static void main( String[] args )  throws SQLException

    {
        System.out.println("Starting jdbc Tutorial");
        Connection con = DatabaseManager.getConnection(USERNAME,PASSWORD);
        DatabaseManager.checkConnection(con);
        HashMap<String,String> hs= new HashMap<String, String>();
        hs.put("Id","int");
        hs.put("Nume","varchar(10)");
        hs.put("Prenume","varchar(10)");
        DatabaseManager.create(con,"Tabel",hs);
        DatabaseManager.drop(con,"Tabel");

        System.out.println( "Hello World!" );
    }
}
