package ro.teamnet.zth.utils;


import java.sql.*;
import java.util.HashMap;

public class DatabaseManager {


    public static Connection getConnection(String username, String password) {
        Connection con = null;

        try {


            con = DriverManager.getConnection("jdbc:oracle:thin:@10.6.33.102:1521:orcl", username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;

    }

    public static void getFirst(Connection con) {

        Statement statement_2 = null;
        try {
            statement_2 = con.createStatement();
            ResultSet rs = statement_2.executeQuery("SELECT * FROM EMPLOYEES WHERE employee_id=100");
            if (rs.next()) {

                System.out.println("First line is:" + rs.getString(1));

            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            try {
                statement_2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

    public static void checkConnection(Connection con) {
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
            if (rs.next()) {
                Date currentDate = rs.getDate(1);
                System.out.println("Current date from oracle is:" + currentDate);

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
        Statement stmt;
        try{
            stmt = con.createStatement();
            String createTableString = "CREATE TABLE " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();
            for(String columnName: columnData.keySet()){
                columnsCount--;
                String columnString = columnName+" "+columnData.get(columnName)+(columnsCount!=0 ? " , ":")");
                sqlStatement.append(columnString);
            }
            stmt.executeUpdate(sqlStatement.toString());
            stmt.close();
            System.out.println("Created Table "+tableName+" in database...");


        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static void drop(Connection con, String tableName) {
        Statement stmt;

        try {
            stmt=con.createStatement();
            stmt.executeQuery("DROP TABLE "+ tableName);
            System.out.println("Table: "+tableName+" deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
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
