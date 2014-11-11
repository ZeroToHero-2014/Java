package ro.teamnet.zth.utils;

import java.beans.*;
import java.net.SocketPermission;
import java.sql.*;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

public class DatabaseManager {
    public static Connection getConnection(String username, String password){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: unable to load driver class");
            System.exit(1);
        }

//        try{
//            Driver myDriver = new oracle.jdbc.driver.OracleDriver();
//            DriverManager.registerDriver(myDriver);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Connection con = null;

//        try {
//            con = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@10.6.33.102:1521:orcl",
//                    username,
//                    password );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return con;

        String url = "jdbc:oracle:thin:@10.6.33.102:1521:orcl";
        Properties dateConectare = new Properties();
        dateConectare.put("user", "ZTH_12");
        dateConectare.put("password", "passw0rd");
        try {
            con = DriverManager.getConnection(url, dateConectare);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    public static void checkConnection(Connection con) {
//        Statement statement = null;
//
//        try{
//            statement = con.createStatement();
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                Date currentDate = rs.getDate(1); // get first column returned
//                System.out.println("Current Date from Orache is :" + currentDate);
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
//        }

        PreparedStatement statement = null;

        try {

            String SQL = "SELECT SYSDATE FROM DUAL";
            statement = con.prepareStatement(SQL);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Date currentDate = rs.getDate(1); // get first column returned
                System.out.println("Current Date from Orache is :" + currentDate);
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
//        Statement stmt = null;
//        try {
//            stmt = con.createStatement();
//            String createTableString = "CREATE TABLE" + tableName + " ( ";
//            StringBuilder sqlStatement = new StringBuilder();
//            sqlStatement.append(createTableString);
//            Integer columnsCount = columnData.keySet().size();
//
//            for (String columnName : columnData.keySet()) {
//                columnsCount--;
//                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : " ) ");
//                sqlStatement.append(columnString);
//            }
//
//            stmt.executeUpdate(sqlStatement.toString());
//            System.out.println("Created table " + tableName + " in database ...");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        PreparedStatement stmt = null;


        try {
            String createTableString = "CREATE TABLE " + tableName + " ( ";
            stmt = con.prepareStatement(createTableString);
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for (String columnName : columnData.keySet()) {
                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : " ) ");
                sqlStatement.append(columnString);
            }

            stmt.executeUpdate(sqlStatement.toString());
            System.out.println("Created table " + tableName + " in database ...");

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

    public static void drop(Connection con, String tableName) {
//        Statement stmt = null;
//        try {
//            stmt = con.createStatement();
//            String dropTableStatement = "DROP TABLE " + tableName;
//            stmt.executeUpdate(dropTableStatement);
//            System.out.println("Dropped table " + tableName + "from databese ...");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        PreparedStatement stmt = null;

        try {
            String dropTableStatement = "DROP TABLE " + tableName;
            stmt = con.prepareStatement(dropTableStatement);
            stmt.executeUpdate(dropTableStatement);
            System.out.println("Dropped table " + tableName + " from database ...");


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