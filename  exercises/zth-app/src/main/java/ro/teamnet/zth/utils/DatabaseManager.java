package ro.teamnet.zth.utils;


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

    public static Connection getConnectionClassforName(String username, String password) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
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
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;

    }

    public static Connection getConnectionRegisterDriver(String username, String password)
    {
        try
        {
            Driver myDriver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver( myDriver );
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
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }

    public static void checkConnection(Connection con)
    {
        PreparedStatement pstmt = null;
        try
        {
            String sql = "SELECT SYSDATE FROM DUAL";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
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
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void create(Connection con, String tableName, HashMap<String,String> columnData) {
        PreparedStatement pstmt = null;
        try
        {
            String createTableString = "CREATE TABLE " + tableName + " (";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for (String columnName : columnData.keySet())
            {
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            pstmt = con.prepareStatement(sqlStatement.toString());
            pstmt.executeUpdate();

            System.out.println("Created table " + tableName + " in database...");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void drop (Connection con, String tableName)
    {
        PreparedStatement pstmt = null;

        try
        {
            String dropTableStatement = "DROP TABLE " + tableName;
            pstmt = con.prepareStatement(dropTableStatement);
            pstmt.executeUpdate();
            System.out.println("Dropped table " + tableName + " from database...");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
