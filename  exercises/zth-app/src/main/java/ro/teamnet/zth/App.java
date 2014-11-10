package ro.teamnet.zth;

import ro.teamnet.zth.utils.DatabaseManager;

import java.sql.Connection;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App
{
    private static final String USERNAME = "ZTH_13";
    private static final String PASSWORD ="passw0rd";
    private static final String URL = "jdbc:oracle:thin:@10.6.33.102:1521:orcl";

    public static void main( String[] args )
    {

        System.out.println( "Whats the date?" );

       // Connection connection = null;


        DatabaseManager dbm = new DatabaseManager();
        Connection connection=dbm.getConnection(USERNAME,PASSWORD);
        dbm.checkConnection(connection);
        dbm.getFirst(connection);



        HashMap<String,String> myMap = new HashMap<String, String>();
        myMap.put("random_name_1","VARCHAR2(10) PRIMARY KEY");
        myMap.put("random_name_2","VARCHAR2(35) NOT NULL");

        //dbm.create(connection, "MYTABLE", myMap);
        //dbm.drop(connection,"MYTABLE");

//      con = DatabaseManager.getConnection(USERNAME,PASSWORD);
//        connection = DatabaseManager.getConnection(USERNAME,PASSWORD,URL);
//        DatabaseManager.checkConnection(connection);

//        DatabaseManager.getFirst(connection);

//        DatabaseManager.create(connection,"MYTABLE",myMap);
//        DatabaseManager.drop(connection,"MYTABLE");

//        JobDao job = new JobDao();
//        ArrayList<Job> arrayList = job.getAllJobs(con);
//        System.out.println(arrayList.toString());

//        DepartmentDao depDao = new DepartmentDao();
//        ArrayList<Department> arrayList = depDao.getAllDepartments(con);
//        Department dep = depDao.getDepartmentById(con,50);
//        System.out.println(dep.toString());
//        System.out.println(arrayList.toString());

//        EmployeeDao employeeDao = new EmployeeDao();
//        ArrayList<Employee> arrayList = employeeDao.getAllEmployees(con);
//        Employee employee = employeeDao.getEmployeeById(con,203);
//        System.out.println(employee.toString());
//


        dbm.closeConnection(connection);

    }
}
