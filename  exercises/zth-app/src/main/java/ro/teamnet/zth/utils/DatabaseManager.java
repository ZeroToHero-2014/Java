package ro.teamnet.zth.utils;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by user on 11/4/2014.
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
                Date currentDate = rs.getDate(1);
                System.out.println("Current dte from oracle is: " + currentDate);
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
        PreparedStatement stmt=null;

        try {
            String createTableString = "create table " + tableName + " ( ";


            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnscount = columnData.keySet().size();

            for (String columnName : columnData.keySet()) {
                columnscount--;
                String cloumnstring = columnName + " " + columnData.get(columnName) + (columnscount != 0 ? " , " : " ) ") ;
                sqlStatement.append(cloumnstring);

            }
            stmt = con.prepareStatement(sqlStatement.toString());
            stmt.executeUpdate();

            System.out.println("Created table" + tableName + "in database");
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
        PreparedStatement stmt=null;

        try {
            String dropTableStatemnt="Drop table "+ tableName;
            stmt=con.prepareStatement(dropTableStatemnt);

            stmt.executeUpdate();

            System.out.println("dropped table "+ tableName+ "from database");
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
