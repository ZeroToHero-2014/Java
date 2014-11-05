package ro.teamnet.zth.utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Ifrim on 04.11.2014.
 */
public class DatabaseManager {

    public static Connection getConnection(String username, String password) {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.6.33.102:1521:orcl",
                    username,
                    password
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnectionClassForName(String username, String password) {

        Class c = null;
        try
        {
            c = Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Connection con = null;
        try
        {
            String URL = "jdbc:oracle:thin:@10.6.33.102:1521:orcl";
            Properties info = new Properties();
            info.put("user", username);
            info.put("password", password);

            con = DriverManager.getConnection(URL, info);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static Connection getConnectionDriverRegister(String username, String password) {

        Driver driver = null;
        try
        {
            driver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(driver);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = null;
        try
        {
            String URL = "jdbc:oracle:thin:@10.6.33.102:1521:orcl";
            Properties info = new Properties();
            info.put("user", username);
            info.put("password", password);

            con = DriverManager.getConnection(URL, info);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }


    public static void checkConnection(Connection con) {

        PreparedStatement prep = null;
        try
        {
            String sysdate = "SELECT SYSDATE FROM DUAL";
            prep = con.prepareStatement(sysdate);
            ResultSet rs = prep.executeQuery();
            if(rs.next()) {
                Date currentDate = rs.getDate(1);
                System.out.println("Current date from Oracle is: " + currentDate);
            }
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {

            try
            {
                prep.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {

        PreparedStatement prep = null;
        try
        {
            String createTable = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTable);
            Integer columnsCount = columnData.keySet().size();

            for(String columnName : columnData.keySet()) {
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            prep = con.prepareStatement(sqlStatement.toString());
            prep.executeUpdate();

            System.out.println("Create table " + tableName + " in database...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

            try {
                prep.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void drop(Connection con, String tableName)
    {
        PreparedStatement prep = null;
        try
        {
            String dropTableStatement = "DROP TABLE " + tableName;

            prep = con.prepareStatement(dropTableStatement);
            prep.executeUpdate();

            System.out.println("Drop table " + tableName + " from database...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

            try {

                prep.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void closeConnection(Connection x) {
        try {
            x.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}