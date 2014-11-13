package ro.teamnet.zth.utils;

import java.sql.*;
import java.util.HashMap;

public class DatabaseManager {

    public static Connection getConnection(String username, String password) {

        Connection con = null;
        try {

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.6.33.102:1521:orcl",
                    username,
                    password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void checkConnection(Connection con) {

        Statement statement = null;
        PreparedStatement stmt = null;
        try {
           // statement = con.createStatement();
            stmt = con.prepareStatement("SELECT SYSDATE FROM DUAL");
           // ResultSet res = statement.executeQuery("SELECT SYSDATE FROM DUAL");
            ResultSet res = stmt.executeQuery("SELECT SYSDATE FROM DUAL");
            if(res.next()) {
                Date currentDate = res.getDate(1);
                System.out.println("Current Date from Oracle is " + currentDate);
            }
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
              //  statement.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {

        Statement stmt = null;
        PreparedStatement statement = null;

        try {
            stmt = con.createStatement();
            String createTableString = "CREATE TABLE " + tableName + "(";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for(String columnName: columnData.keySet()) {
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? "," : ")");
                sqlStatement.append(columnString);
            }
            System.out.println(sqlStatement.toString());
            stmt.executeUpdate(sqlStatement.toString());

            System.out.println("Created table " + tableName + " in database ...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void drop(Connection con, String tableName) {

        Statement stmt = null;


        try {
            stmt = con.createStatement();
            String dropTableStatement = "DROP TABLE " + tableName;
            stmt.executeUpdate(dropTableStatement);

            System.out.println("Dropped table " + tableName + " from database ...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
