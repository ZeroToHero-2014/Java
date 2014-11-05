package ro.teamnet.zth.utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Dumitru on 04.11.2014.
 */
public class DatabaseManager {

    public static Connection getConnection(String username, String password) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.6.33.102:1521:orcl",
                    username,
                    password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnectionClassForName(String username, String password) {

        //register JDBC driver for Oracle
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println(cls.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //define connection URL
        Connection con = null;
        try {
            String URL = "jdbc:oracle:thin:@10.6.33.102:1521:orcl";
            Properties info = new Properties();
            info.put("user", username);
            info.put("password", password);

            con = DriverManager.getConnection(URL, info);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static Connection getConnectionDriverRegister(String username, String password) {

        //register JDBC driver for Oracle
        Driver driver = null;
        try {
            driver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(driver);
            //System.out.println(driver.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //define connection URL
        Connection con = null;
        try {
            String URL = "jdbc:oracle:thin:@10.6.33.102:1521:orcl";
            Properties info = new Properties();
            info.put("user", username);
            info.put("password", password);

            con = DriverManager.getConnection(URL, info);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void checkConnection(Connection con) {

        //execute a query
        PreparedStatement pstmt = null;
        try {
            String comanda = "SELECT SYSDATE FROM DUAL";
            pstmt = con.prepareStatement(comanda);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Date currentDate = rs.getDate(1);
                System.out.println("Current date from Oracle is: " + currentDate);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //close the connection
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {

        //execute a query
        PreparedStatement pstmt = null;
        try {
            String createTable = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTable);
            Integer columnsCount = columnData.keySet().size();

            for(String columnName : columnData.keySet()) {
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            pstmt = con.prepareStatement(sqlStatement.toString());
            pstmt.executeUpdate();

            System.out.println("Create table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //close the connection
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void drop(Connection con, String tableName) {
        //execute a query
        PreparedStatement pstmt = null;
        try {
            String dropTableStatement = "DROP TABLE " + tableName;

            pstmt = con.prepareStatement(dropTableStatement);
            pstmt.executeUpdate();

            System.out.println("Drop table " + tableName + " from database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //close the connection
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
