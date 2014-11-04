package ro.teamnet.zth.utils;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.HashMap;

/**
 * Created by Buli on 04.11.2014.
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
            ResultSet rs = null;
            rs = statement.executeQuery("SELECT SYSDATE from DUAL");

            if (rs.next()) {
                Date currentDate = rs.getDate(1);
                System.out.println("Current date from oracle is : " + currentDate);
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

    public static void getFirstRow(Connection con) {

        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet rs = null;
            rs = statement.executeQuery("SELECT * from EMPLOYEES WHERE employee_id = 1");

            if (rs.next()) {

                System.out.println("Current date from oracle is : " + rs.getString(1) + "");
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

        Statement stat = null;

        try {
            stat = con.createStatement();
            String createTableString = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for(String columnName : columnData.keySet()){
                columnsCount --;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            stat.executeUpdate(sqlStatement.toString());

            System.out.println("Created table " + tableName + " in database...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void drop(Connection con, String tableName) {

        Statement stmt = null;

        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sqlStatement = "DROP TABLE " + tableName;
            stmt.executeUpdate(sqlStatement);
            System.out.println("Droped table " + tableName + "from database...");
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

    public static void closeConnecction(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
