package ro.teamnet.zth;

import ro.teamnet.zth.dao.*;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String USERNAME = "ZTH_10";
    private static final String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {

        System.out.println( "Starting ZTH JDBC Tutorial" );

        //Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
        //Connection con = DatabaseManager.getConnectionClassforName(USERNAME, PASSWORD);
        //Connection con = DatabaseManager.getConnectionRegisterDriver(USERNAME, PASSWORD);
        Connection con = DatabaseManager.getConnectionDataSource(USERNAME, PASSWORD);

        DatabaseManager.checkConnection(con);

//        HashMap<String, String> map = new HashMap<String, String>();
//
//        map.put("String", "varchar(244)");
//        map.put("Numar", "number(10)");


        //DatabaseManager.create(con, "NewMap", map);

        //DatabaseManager.drop(con, "NewMap");

//        JobDao jd = new JobDao();
//
//        System.out.println(jd.getAllJobs(con));
//        System.out.println(jd.getJobById(con, "AD_VP"));
//
//        DepartmentDao dd = new DepartmentDao();
//
//        System.out.println(dd.getAllDepartments(con));
//        System.out.println(dd.getDepartmentById(con, "220"));
//
        EmployeeDao ed = new EmployeeDao();
//
//        System.out.println(ed.getAllEmployees(con));
//

//        EmployeeViewDao evd = new EmployeeViewDao();
//
//        try
//        {
//            System.out.println(evd.getEmployeeView(con, 206L));
//            //evd.getEmployeeView(con, 206L);
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//
//        Employee employee = ed.getEmployeeById(con,"206");
//
//        employee.setFirstName("Sad3");
//        employee.setLastName("Panda3");
//        employee.setId(11114l);
//
//
//        ed.saveEmployee(employee,con);
//        System.out.println(ed.getEmployeeById(con, "11114"));
//        Employee employee = ed.getEmployeeById(con, "1111");
//        System.out.println(employee.getDepartment().toString());
//       ed.deleteEmployee(employee, con);

//        System.out.println(new LocationDao().getAllLocations(con));
//
//        System.out.println(new LocationDao().getLocationById(con, "1700"));

        System.out.println(ed.getEmployeeById(con, "206"));


    }
}
