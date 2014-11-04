package ro.teamnet.zth.utils;


import oracle.jdbc.pool.*;

import java.sql.*;
import java.util.HashMap;

public class DatabaseManager {


    public static Connection getConnection(String username, String password) {
//        Connection con = null;
//
//        try {
//            con = DriverManager.getConnection("jdbc:oracle:thin:@demo.teamnet.ro:1521:orcl",
//                    username,
//                    password);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return con;

        OracleDataSource ds;
        Connection con = null;
        try {
            ds = new OracleDataSource();
            ds.setDriverType("thin");
            ds.setServerName("demo.teamnet.ro");
            //  ds.setURL("jdbc:oracle:thin:@demo.teamnet.ro:1521:orcl");
            ds.setPortNumber(1521);
            ds.setDatabaseName("orcl");
            ds.setUser(username);
            ds.setPassword(password);
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void checkConnection(Connection con) {
//
//        Statement statment = null;
//        try {
//            statment = con.createStatement();
//            ResultSet rs = statment.executeQuery("SELECT SYSDATE FROM DUAL");
//            if (rs.next()) {
//                Date currentDate = rs.getDate(1);
//                System.out.println("Current Date from Oracle is :" + currentDate);
//
//            }
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statment.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//        }

        PreparedStatement stm = null;


        try {
            String SQL = "SELECT SYSDATE FROM DUAL";
            stm = con.prepareStatement(SQL);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Date currentDate = rs.getDate(1);
                System.out.println("Current Date from Oracle is :" + currentDate);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }


    public static void create(Connection con, String tableName, HashMap<String, String> columnData) {

        Statement statement = null;
        try {
            statement = con.createStatement();
            String createTableString = "CREATE TABLE " + tableName + "(";

            StringBuilder sqlStatment = new StringBuilder();
            sqlStatment.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for (String columnName : columnData.keySet()) {

                columnsCount--;
                String columnString = columnName + " " + columnData.get(columnName) + (columnsCount != 0 ? " , " : ")");
                sqlStatment.append(columnString);
            }

            statement.executeUpdate(sqlStatment.toString());
            statement.close();
            System.out.println("Created  table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void drop(Connection con, String tableName) {
//        Statement statement = null;
//
//        try {
//            statement = con.createStatement();
//            String dropTableStatment = "DROP TABLE " + tableName;
//            statement.executeUpdate(dropTableStatment);
//            statement.close();
//            System.out.println("Deleted table " + tableName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        PreparedStatement stm = null;

        try {
            String SQL = "DROP TABLE "+ tableName;
            stm = con.prepareStatement(SQL);
            stm.executeUpdate();
            stm.close();
            System.out.println("Deleted table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

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
