package ro.teamnet.zth.utils;

import java.sql.*;
import java.util.HashMap;
<<<<<<< HEAD
import java.util.Properties;

/**
 * Created by Dumitru on 04.11.2014.
 */
public class DatabaseManager {

    public static Connection getConnection(String username, String password) {
=======

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class DatabaseManager {
    public static Connection getConnection(String username, String password) {

>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.6.33.102:1521:orcl",
                    username,
<<<<<<< HEAD
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
=======
                    password);

>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void checkConnection(Connection con) {

<<<<<<< HEAD
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
=======
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
            if (rs.next()) {
                Date currentDate = rs.getDate(1); // get first column returned
                System.out.println("Current Date from Oracle is : " + currentDate);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {
<<<<<<< HEAD

        //execute a query
        PreparedStatement pstmt = null;
        try {
            String createTable = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTable);
            Integer columnsCount = columnData.keySet().size();

            for(String columnName : columnData.keySet()) {
=======
        Statement stmt;
        try {
            stmt = con.createStatement();
            String createTableString = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for (String columnName : columnData.keySet()) {
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

<<<<<<< HEAD
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
=======
            stmt.executeUpdate(sqlStatement.toString());
            stmt.close();
            System.out.println("Created table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
        }
    }

    public static void drop(Connection con, String tableName) {
<<<<<<< HEAD
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
=======
        Statement stmt;
        try {
            stmt = con.createStatement();
            String dropTableStatement = "DROP TABLE " + tableName;
            stmt.executeUpdate(dropTableStatement);
            stmt.close();
            System.out.println("Dropped table " + tableName + " from database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
        }
    }
}
