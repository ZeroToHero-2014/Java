package ro.teamnet.zth;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.DatabaseManager;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final String USERNAME = "ZTH_01";
    private static final String PASSWORD = "passw0rd";
    private static final String URL = "jdbc:oracle:thin:@10.6.33.102:1521:orcl";
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Connection con = null;

        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("id", "number primary key");
        hashMap.put("first_name", "varchar2(40) not null");
        hashMap.put("last_name", "varchar2(40) not null");
        hashMap.put("phone_number", "varchar2(35)");

//        con = DatabaseManager.getConnection(USERNAME,PASSWORD);
        con = DatabaseManager.getConnection(USERNAME,PASSWORD,URL);
//        DatabaseManager.checkConnection(con);
//        DatabaseManager.getFirstRow(con);
//        DatabaseManager.create(con,"test_jdbc",hashMap);
//        DatabaseManager.drop(con,"test_jdbc");

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
//        System.out.println(arrayList.toString());

//        Job job = new Job();
//        Department dep = new Department();
//        Employee manager = new Employee();
//        Date date = new Date(1346524199000l);
//        manager.setEmployeeId(100L);
//        dep.setDepartmentId(150L);
//        job.setJobId("SA_REP");
//        Employee employee = new Employee();
//        employee.setEmployeeId(900L);
//        employee.setFirstName("Vlad");
//        employee.setLastName("Bulimac");
//        employee.setEmail("buli.vlad@yahoo.com");
//        employee.setPhoneNmber("0742387589");
//        employee.setHireDate(date);
//        employee.setJob(job);
//        employee.setSalary(12000.2);
//        employee.setCommisionPoints(20.2);
//        employee.setDepartment(dep);
//        employee.setManager(manager);
//
//        EmployeeDao emp = new EmployeeDao();
//        emp.saveEmployee(employee,con);

        DatabaseManager.closeConnecction(con);

    }
}
