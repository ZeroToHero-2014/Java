package ro.teamnet.zth.utils;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class DatabaseManager {
    public static Connection getConnection(String username, String password) {

        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.6.33.102:1521:orcl",
                    username,
                    password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void checkConnection(Connection con) {

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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String createTableString = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for (String columnName : columnData.keySet()) {
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            stmt.executeUpdate(sqlStatement.toString());
            stmt.close();
            System.out.println("Created table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void drop(Connection con, String tableName) {
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
        }
    }
}
