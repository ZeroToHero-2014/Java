package ro.teamnet.zth;

import ro.teamnet.zth.dao.*;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.DatabaseManager;
import ro.teamnet.zth.views.EmployeeView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App {
    private static final String USERNAME = "ZTH_12";
    private static final String PASSWORD = "passw0rd";



    public static void main( String[] args ) {
        System.out.println("Starting ZTH JDBC Tutorial ");

        Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
        DatabaseManager.checkConnection(con);

        System.out.println( "Hello World!" );

        HashMap<String, String> test = new HashMap<String, String>();
        test.put("id", "NUMBER");
        test.put("firstNume", "VARCHAR2 (20 BYTE)");
        test.put("lastNume", "VARCHAR2 (25 BYTE)");
        DatabaseManager.create(con, "test", test);
        DatabaseManager.drop(con, "test");

        JobDao jdao = new JobDao();
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs = jdao.getAllJobs(con);
        for (Job j:jobs) {
            System.out.println(j);
        }

        Job jb;
        jb = jdao.getJobById(con, "AD_PRES1");
        System.out.println(jb);

        DepartmentDao departdao = new DepartmentDao();
        ArrayList<Department> departments = new ArrayList<Department>();
        departments = departdao.getAllDepartment(con);
        for (Department d:departments) {
            System.out.println(d);
        }

        Department dep;
        dep = departdao.getDepartmentById(con, 10l );
        System.out.println(dep);

        EmployeeDao empldao = new EmployeeDao();
        ArrayList<Employee> empl = new ArrayList<Employee>();
        empl = empldao.getAllEmployees(con);
        for (Employee e:empl) {
            System.out.println(e);
        }

        Employee emp;
        emp = empldao.getEmployeeById(con, 133l);
        System.out.println(emp);

        EmployeeViewDao emplViewDao = new EmployeeViewDao();
        try {
            System.out.println(emplViewDao.getEmployeeView(con, 133l));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        LocationDao locdao = new LocationDao();
        ArrayList<Location> loc = new ArrayList<Location>();
        loc = locdao.getAllLocation(con);
        for (Location l:loc) {
            System.out.println(l);
        }

        Location loc2;
        loc2 = locdao.getLocationById(con, 1100L);
        System.out.println(loc2);

        Employee emp2 = new Employee();
        emp2 = empldao.getEmployeeById(con, 200l);
        emp2.setId(91L);
        emp2.setFirstName("daniel");
        empldao.saveEmployee(emp2, con);
        System.out.println(empldao.getEmployeeById(con,91L));

        empldao.deleteEmployee(emp2, con);


    }

}