package ro.teamnet.zth.utils;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;


import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
/**
 * Created by user on 11/3/2014.
 */
public class DatabaseManager {

    public static Connection getConnection(String username, String password) {



        Connection con = null;

        Properties prop = new Properties();
        prop.put("user",username);
        prop.put("password",password);

        try {
            DriverManager.registerDriver( new OracleDriver() );

            OracleDataSource ods = new OracleDataSource();
            ods.setServerName("10.6.33.102");
            ods.setDriverType("thin");
            ods.setPortNumber(1521);
            ods.setDatabaseName("orcl");
            ods.setUser(username);
            ods.setPassword(password);

            con = ods.getConnection(); //putem folosi dataSource la conectare sau DriverManager-ul

                  //  DriverManager.getConnection("jdbc:oracle:thin:@10.6.33.102:1521:orcl", prop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
        //ta varianta mai buna cu proprietati din map
    }

    public static void checkConnection(Connection con) {
        PreparedStatement st = null;

        try {



            st = con.prepareStatement("Select Sysdate from dual"  );
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Date currentDAte = rs.getDate(1);
                System.out.println("Current Date from Oracle is : " + currentDAte);
            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void checkConnection2(Connection con){
    PreparedStatement st = null;

        try {
            st = con.prepareStatement("Select * FROm Employees");
            ResultSet rs = st.executeQuery();

            if(rs.next()){
           for(int i=1;i<rs.getMetaData().getColumnCount();i++)
           {
               System.out.print(rs.getString(i) + " ");
           }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {
    PreparedStatement st = null;

        try {

            String createTable = "Create Table " + tableName + " (";
            StringBuilder sqlStatement = new StringBuilder();

            sqlStatement.append(createTable);

            Integer columnsCount = columnData.keySet().size();

            for(String columnName : columnData.keySet()){

                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName)+ (columnsCount !=0? ", ":")");
                sqlStatement.append(columnString);
            }


            st = con.prepareStatement(sqlStatement.toString());
            st.execute();

            System.out.println("Table created " + tableName);

        //mutat inchiderea statement-ului in block de finally
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void drop(Connection con, String table) {
                PreparedStatement ps = null;
        try {

            //st.executeUpdate("Drop Table " + table);
            ps = con.prepareStatement("Drop Table "  + table);
            ps.execute();
            System.out.println("Dropped table " + table);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {

            ps.close();;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void closeConnection(Connection con) {

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
