package ro.teamnet.zth.utils;

import java.sql.*;
import java.util.HashMap;
/**
 * Created by Juvie on 04.11.2014.
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

//    public static void checkConnection(Connection con) {
//        Statement statement = null;
//        try {
//            statement = con.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
//            if (rs.next()) {
//                Date currentDate = rs.getDate(1); //1st col returned
//                System.out.println("Current date from Oracle is : " + currentDate);
//            }
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

    public static void checkConnection(Connection con) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "SELECT SYSDATE FROM DUAL"
            preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Date currentDate = rs.getDate(1); //1st col returned
                System.out.println("Current date from Oracle is : " + currentDate);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

//    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {
//        Statement stat;
//        try {
//            stat = con.createStatement();
//            String createTableString = "CREATE TABLE " + tableName + "(";
//            StringBuilder sqlStatement = new StringBuilder();
//            sqlStatement.append(createTableString);
//            Integer columnsCount = columnData.keySet().size();
//
//            for(String columnName : columnData.keySet()) {
//                columnsCount--;
//                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : " )");
//                sqlStatement.append(columnString);
//            }
//
//            stat.execute(sqlStatement.toString());
//            stat.close();
//            System.out.println("Created table " + tableName + " in db");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {
        PreparedStatement preparedStatement = null;
        try {
            String createTableString = "CREATE TABLE " + tableName + "(";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for(String columnName : columnData.keySet()) {
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : " )");
                sqlStatement.append(columnString);
            }

            preparedStatement = con.prepareStatement(sqlStatement.toString());
            preparedStatement.executeUpdate();

            System.out.println("Created table " + tableName + " in db");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void drop(Connection con, String tableName) {
//        Statement stat;
//
//        try {
//            stat = con.createStatement();
//            String dropTableStatement =  "DROP TABLE " + tableName;
//            stat.execute(dropTableStatement);
//            stat.close();
//            System.out.println("Dropped table " + tableName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public static void drop(Connection con, String tableName) {
        PreparedStatement preparedStatement = null;

        try {
            String dropTableStatement =  "DROP TABLE " + tableName;
            preparedStatement = con.prepareStatement(dropTableStatement);
            preparedStatement.executeUpdate();
            System.out.println("Dropped table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {

            //close the connection
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
