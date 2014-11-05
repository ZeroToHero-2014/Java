package ro.teamnet.zth.utils;

import oracle.jdbc.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by user on 11/3/2014.
 */
public class DatabaseManager {

    public static Connection getConnection(String username,String password){
       Connection con=null;
//        try {
//            con = DriverManager.getConnection("jdbc:oracle:thin:@10.6.33.102:1521:orcl",username,password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return con;
        //ta varianta mai buna cu proprietati din map

        try {
            DriverManager.registerDriver(new OracleDriver());

            OracleDataSource dataSource= new OracleDataSource();
            dataSource.setServerName("10.6.33.102");
            dataSource.setDriverType("thin");
            dataSource.setPortNumber(1521);
            dataSource.setDatabaseName("orcl");
            dataSource.setUser(username);
            dataSource.setPassword(password);
            con =dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


    public static void checkConnection(Connection con){
    //Statement st = null; //for statement
        PreparedStatement pst=null;
        try {
            //for statement
            //st = con.createStatement();
            //ResultSet rs =  st.executeQuery("Select Sysdate from dual");
            String sql = "Select Sysdate from dual";
            pst=con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
        if(rs.next()){
        Date currentDate = rs.getDate(1);
            System.out.println("Current Date from Oracle is : " + currentDate);
        }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
             //st.close(); //for statement
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void checkConnection2 (Connection con)
    {
     //   Statement statement = null; //for statement
        PreparedStatement pst1 =null;
        try {
            //for statement
       // statement = con.createStatement();
        //ResultSet rs2 =statement.executeQuery("Select * FROM Employees");
            String sql="Select * FROM Employees";
            pst1= con.prepareStatement(sql);
            ResultSet rs2= pst1.executeQuery(sql);
           if(rs2.next())
           {
               for (int i = 1; i < rs2.getMetaData().getColumnCount(); i++) {
               System.out.println(rs2.getString(i)+ " ");
               }
           }
           rs2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //statement.close(); //for statement
                pst1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void create(Connection con,String tableName, HashMap<String,String> columnData){
        // for statement
//    Statement stmt;
//        try{
//            stmt = con.createStatement();
//            String createTableString="Create table " + tableName +"( ";
//            StringBuilder sqlStatement = new StringBuilder();
//            sqlStatement.append(createTableString);
//            Integer columnsCount = columnData.keySet().size();
//
//            for (String columnName:columnData.keySet()){
//                columnsCount--;
//                String columnString= columnName +" "+ columnData.get(columnName)+(columnsCount!=0 ? " , " : ")");
//                sqlStatement.append(columnString);
//            }
//            stmt.executeUpdate(sqlStatement.toString());
//            stmt.close();
//            System.out.println("Created table " + tableName + " in database ...");
//        }catch(SQLException e)
//        {
//            e.printStackTrace();
//        }

        // for PreparedStatement
        PreparedStatement pstmt;
        try{

            String createTableString="Create table " + tableName +"( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for (String columnName:columnData.keySet()){
                columnsCount--;
                String columnString= columnName +" "+ columnData.get(columnName)+(columnsCount!=0 ? " , " : ")");
                sqlStatement.append(columnString);
            }
            pstmt = con.prepareStatement(createTableString);
            pstmt.executeUpdate(sqlStatement.toString());
            pstmt.close();
            System.out.println("Created table " + tableName + " in database ...");
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void drop(Connection con,String table){
        //for statement
//    Statement stmt;
//        try {
//            stmt=con.createStatement();
//            String dropTableStatement = "Drop Table "+ table;
//            stmt.executeUpdate(dropTableStatement);
//            stmt.close();
//            System.out.println("Dropped table " + table + " from database ..");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        PreparedStatement pstmt=null;
        try {

            String dropTableStatement = "Drop Table "+ table;
            pstmt = con.prepareStatement(dropTableStatement);
            pstmt.executeUpdate(dropTableStatement);

            pstmt.close();
            System.out.println("Dropped table " + table + " from database ..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection con){

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
