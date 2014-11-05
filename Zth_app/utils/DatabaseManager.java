package ro.teamnet.zth.utils;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Maria on 11/4/2014.
 */
public class DatabaseManager {

    public static Connection getConnection(String username, String password) {
//  Connection con = null;
//  try {
//     con = DriverManager.getConnection(
//             "jdbc:oracle:thin:@10.6.33.102:1521:orcl",
//            username,
//            password);
//} catch (SQLException e) {
//   e.printStackTrace();
// }
// return con;
//}

        OracleDataSource ds;
        Connection con = null;
        try {
            ds = new OracleDataSource();
            ds.setDriverType("thin");
            ds.setServerName("10.6.33.102");
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
        //   Statement statement = null;

        //   try {
        //      statement = con.createStatement();
        //      ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
        //      if (rs.next()) {
        //          Date currentDate = rs.getDate(1); //get first colum returned
        //          System.out.println("Current Date from Oracle is: " + currentDate);

        //      }
        //      rs.close();
        //  } catch (SQLException e) {
        //      e.printStackTrace();
        //  } finally {
        //     try {
        //          statement.close();
        //      } catch (SQLException e) {
        //          e.printStackTrace();
        //     }
        //  }

        // }
        PreparedStatement stm = null;

        try {
            String SQL = "Select from dual ";
            stm = con.prepareStatement(SQL);
            ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    Date currentDate = rs.getDate(1);
                    System.out.println("Current Date is: " + currentDate);
                }
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                    stm.close();

            } catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    public static void create(Connection con, String tableName, HashMap<String, String> columData) {

        Statement stm;


        try {
            stm = con.createStatement();
            String createTableString = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnCount = columData.keySet().size();

            for (String columnName:columData.keySet()){
                columnCount--;
                String columnString = columnName + " " + columData.get(columnName) +(columnCount != 0 ? " , " : ")");
                sqlStatement.append(columnString);
            }

            stm.executeUpdate(sqlStatement.toString());
            stm.close();
            System.out.println("Created table "+ tableName + "in database...");

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public static void drop(Connection con, String tableName) {
    //    Statement stmt;
    //    try {
    //        stmt = con.createStatement();
    //        String dropTableStatement = "DROP TABLE " + tableName;
    //        stmt.executeUpdate(dropTableStatement);
    //        stmt.close();
    //        System.out.println("Dropped table " + tableName + "from database...");
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
   // }

        PreparedStatement stm =null;
        try {
            String SQL = "Drop Table " + tableName;
            stm = con.prepareStatement(SQL);
            stm.executeUpdate();
            stm.close();
            System.out.println("Deleted table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            finally {
            try{
                if (stm !=null){
                    stm.close();
                }
            }
            catch (SQLException e){
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
