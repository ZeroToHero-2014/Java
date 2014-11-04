package ro.teamnet.zth;


import ro.teamnet.zth.utils.DatabaseManager;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class App {

    public static final String userName = "ZTH_14";
    public static final String pass = "passw0rd";


    public static void main(String[] args) {


        Connection con = DatabaseManager.getConnection(userName, pass);


        DatabaseManager.checkConnection(con);
        DatabaseManager.checkConnection2(con);

        boolean creazaTabel = false,
                stergeTabel = false;
        String tabelCreare = "TabelTestJava7",
                tabelStergere = "TabelTestJava6";
        if (creazaTabel) {
            HashMap<String, String> coloane = new HashMap<String, String>();

            coloane.put("col1", "Varchar2(30)");
            coloane.put("col2", "Varchar2(30)");
            coloane.put("col3", "Varchar2(30)");


            DatabaseManager.create(con, tabelCreare, coloane);
        }
        if(stergeTabel){

        DatabaseManager.drop(con, tabelStergere);}
        DatabaseManager.closeConnection(con);

    }


}
