package ro.teamnet.zth.utils;
import java.util.Date;
import java.sql.*;
import java.util.*;


/**
 * Created by ovy on 11/4/2014.
 */
public class DatabaseManager {



    public static Connection getConnection(String username,String password) throws SQLException {




  /*  String driverClassName = "jdbc:oracle:thin:@10.6.33.102:1521:orcl";

        // String url = "jdbc:mysql://localhost/companydb";

        String dbUsername = "ZTH_04";

       String dbPassword = "passw0rd";
        DriverManagerDataSource dataSource = new DriverManagerDataSource();



        dataSource.setDriverClassName(driverClassName);



        dataSource.setUrl(url);



        dataSource.setUsername(dbUsername);



        dataSource.setPassword(dbPassword);*/





        Connection con=null;

        try {
            Driver myDriver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(myDriver);
            con=DriverManager.getConnection("jdbc:oracle:thin:@10.6.33.102:1521:orcl", username,
                    password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

return con;

    }
    public  static void  checkConnection(Connection con){
       PreparedStatement statement=null;
            try {
                String sq="SELECT SYSDATE FROM DUAL";
               statement = con.prepareStatement(sq);

                ResultSet rs = statement.executeQuery(sq );
                if (rs.next()) {
                  Date currentDate = rs.getDate(1);
                    System.out.println(currentDate);
                }
                rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
        finally {
                try{
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }


            }
    public static void create(Connection con,String tableName,HashMap<String,String> columnData){
        PreparedStatement stmt;
        try {
            String createTableString="CREATE TABLE "+tableName+" ( ";
            StringBuilder sqlStatement=new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = columnData.keySet().size();

            for(String columnName: columnData.keySet()){
                columnsCount--;
                String columnString= columnName+ " "+columnData.get(columnName)+(columnsCount!= 0 ? ",":")");
                sqlStatement.append(columnString);



            }
            stmt=con.prepareStatement(sqlStatement.toString());

            stmt.executeUpdate();
            stmt.close();
            System.out.println("create table"+tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public  static  void drop(Connection con,String tableName){
        PreparedStatement stmt;
        try {
            String dropTableStatment="DROP TABLE "+tableName;
            stmt=con.prepareStatement(dropTableStatment);

            stmt.executeUpdate(dropTableStatment);
            stmt.close();
            System.out.println("Droped table"+tableName);

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




