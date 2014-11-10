package ro.teamnet.zth.utils;

import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Created by George on 11/4/2014.
 */
public class DatabaseManager {
    public static Connection getConnection(String username, String password){
        Connection con = null;

        try{
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.6.33.102:1521:orcl",
                    username,
                    password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void checkConnection(Connection con){
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select sysdate from dual");

            if (rs.next()){
                Date currentDate = rs.getDate(1);
                System.out.println("Current Date from Oracle is: " + currentDate);
            }

            // if no need rs - close()
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void create(Connection con, String tableName, HashMap<String, String> columnData){
        PreparedStatement stmt = null;
        try {
            String createTableString = "Create Table " + tableName + "( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for (String columnName : columnData.keySet()){
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) +
                        (columnsCount != 0 ? ", " : ")");
                sqlStatement.append(columnString);
            }

            stmt = con.prepareStatement(sqlStatement.toString());

            stmt.executeUpdate();
            System.out.println("Created table " + tableName + " in database...");

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

    public static void drop(Connection con, String tableName){
        PreparedStatement stmt = null;

        try {
            String dropTableStatement = "DROP TABLE " + tableName;
            stmt = con.prepareStatement(dropTableStatement);
            stmt.executeUpdate();
            System.out.println("Dropped table " + tableName + " from database...");

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
