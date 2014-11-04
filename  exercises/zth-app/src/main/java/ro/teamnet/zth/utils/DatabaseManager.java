package ro.teamnet.zth.utils;

import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.util.*;
import java.util.Date;

/**
 * Created by Bogdan on 11/4/2014.
 */
public class DatabaseManager
{
    public static Connection getConnection(String username, String password)
    {
        Connection con = null;

        try
        {
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.6.33.102:1521:orcl",username,password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }

    public static void checkConnection(Connection con)
    {
        Statement statement = null;
        try
        {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
            if(rs.next())
            {
                Date currentDate = rs.getDate(1);
                System.out.println("Current Date from Oracle is : " + currentDate);
            }
            rs.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                statement.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void create(Connection con, String tableName, HashMap<String,String> columnData) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String createTableString = "CREATE TABLE " + tableName + " (";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for (String columnName : columnData.keySet()) {
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            stmt.executeUpdate(sqlStatement.toString());

            System.out.println("Created table " + tableName + " in database...");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void drop (Connection con, String tableName)
    {
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            String dropTableStatement = "DROP TABLE " + tableName;
            stmt.executeUpdate(dropTableStatement);
            System.out.println("Dropped table " + tableName + " from database...");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
