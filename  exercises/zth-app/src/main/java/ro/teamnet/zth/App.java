package ro.teamnet.zth;

import oracle.jdbc.pool.OracleDataSource;
import ro.teamnet.zth.dao.*;
import ro.teamnet.zth.domain.*;
import ro.teamnet.zth.utils.DatabaseManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String USERNAME = "ZTH_21";
    private static final String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {
        System.out.println( "Starting ZTH JDBC Tutorial " );

        //CONEXIUNE STATICA
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

//        try {
//            Driver myDriver = new oracle.jdbc.driver.OracleDriver();
//            DriverManager.registerDriver(myDriver);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
//        DatabaseManager.checkConnection(con);

        //CONEXIUNE DINAMICA
        Connection con = null;
        try {
            OracleDataSource ds = new OracleDataSource();
            ds.setURL("jdbc:oracle:thin:@10.6.33.102:1521:orcl");
            ds.setUser(USERNAME);
            ds.setPassword(PASSWORD);
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //TESTING
//        HashMap<String, String> hm = new HashMap<String, String>();
//        hm.put("sir", "VARCHAR2(30)");
//        hm.put("sir2", "VARCHAR2(30)");
//        hm.put("numar", "NUMBER");
        //DatabaseManager.create(con, "TABELA1", hm);
        //DatabaseManager.drop(con, "TABELA1");

        JobDao jd = new JobDao();
//        ArrayList<Job> al = jd.getAllJobs(con);
//        for(Job j : al){
//            System.out.println(j);
//        }
        Job jo = jd.getJobById(con, "MK_MAN");
//        System.out.println(jo);

        DepartmentDao dd = new DepartmentDao();
//        ArrayList<Department> ad =  dd.getAllDepartments(con);
//        for(Department d : ad){
//            System.out.println(d);
//        }
        Department dep = dd.getDepartmentById(con, "250");
//        System.out.println(dep);

        EmployeeDao ed = new EmployeeDao();
//        ArrayList<Employee> ae = ed.getAllEmployees(con);
//        for(Employee e : ae)
//            System.out.println(e);
        Employee emp = ed.getEmployeeById(con, 111l);
        System.out.println(emp);

        Employee emp1 = new Employee();
        emp1.setId(777l);
        emp1.setLastName("Scripcaru");
        Employee x = ed.getEmployeeById(con, 110l);
        emp1.setManager(x);
        emp1.setJob(jo);
        emp1.setDepartment(dep);
        emp1.setFirstName("Mihaela");
        emp1.setComissionPoints(0.5);
        emp1.setEmail("email@x.ro");
        emp1.setHireDate(new Date());
        emp1.setPhoneNumber("0740");
        emp1.setSalary(1000d);
        //ed.saveEmployee(emp1, con);
        System.out.println(ed.getEmployeeById(con, 777l));
        //ed.deleteEmployee(emp1, con);
        ed.updateEmployee(emp1, con);
        System.out.println(ed.getEmployeeById(con, 777l));

//        EmployeeViewDao evd = new EmployeeViewDao();
//        ArrayList<EmployeeView> aed = evd.getAllEmployees(con);
//        for(EmployeeView e : aed)
//            System.out.println(e);
//        EmployeeView empl = evd.getEmployeeViewById(con, 102l);
//        System.out.println(empl);

        LocationDao ld = new LocationDao();
        ArrayList<Location> all = ld.getAllLocations(con);
        for(Location loc : all){
            System.out.println(loc);
        }
        Location loc2 = ld.getLocationById(con, 1700l);
        System.out.println(loc2);
    }
}