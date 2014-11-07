package ro.teamnet.zth.utils;

import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by Buli on 04.11.2014.
 */
public class DatabaseManager {

    public static Connection getConnection(String username, String password) {

        Properties info = new Properties();
        info.put("ORACLE_DB_USERNAME", username);
        info.put("ORACLE_DB_PASSWORD", password);
        info.put("ORACLE_DB_URL","jdbc:oracle:thin:@10.6.33.102:1521:orcl");

        Connection con = null;

        try {
            OracleDataSource ds = new OracleDataSource();
            ds.setURL(info.getProperty("ORACLE_DB_URL"));
            ds.setUser(info.getProperty("ORACLE_DB_USERNAME"));
            ds.setPassword(info.getProperty("ORACLE_DB_PASSWORD"));
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static Connection getConnection(String username, String password, String URL) {

        Properties info = new Properties();
        info.put("ORACLE_DB_USERNAME", username);
        info.put("ORACLE_DB_PASSWORD", password);
        info.put("ORACLE_DB_URL",URL);

        Connection con = null;

        try {
            OracleDataSource ds = new OracleDataSource();
            ds.setURL(info.getProperty("ORACLE_DB_URL"));
            ds.setUser(info.getProperty("ORACLE_DB_USERNAME"));
            ds.setPassword(info.getProperty("ORACLE_DB_PASSWORD"));
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void checkConnection(Connection con) {

        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("SELECT SYSDATE from DUAL");
            ResultSet rs = null;
            rs = statement.executeQuery();

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

        PreparedStatement statement = null;
        try {
            String sqlStatement = "";
            ResultSet rs = null;
            statement = con.prepareStatement("SELECT * from EMPLOYEES where employee_id = ?");
            statement.setInt(1,100);
            rs = statement.executeQuery();

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

        PreparedStatement stat = null;

        try {
            String createTableString = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for(String columnName : columnData.keySet()){
                columnsCount --;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            stat = con.prepareStatement(sqlStatement.toString());
            stat.executeQuery();

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

        PreparedStatement stmt = null;

        ResultSet rs = null;
        try {
            String sqlStatement = "DROP TABLE " + tableName;
            stmt = con.prepareStatement(sqlStatement);
            stmt.executeQuery();
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
