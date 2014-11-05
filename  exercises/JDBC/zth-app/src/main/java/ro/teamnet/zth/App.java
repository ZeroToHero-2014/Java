package ro.teamnet.zth;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.EmployeeViewDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.DatabaseManager;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;
import ro.teamnet.zth.views.EmployeeView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String USERNAME = "ZTH_07";
    public static final String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {

        System.out.println("Starting ZTH JDBC Turorial!" );
        //Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
        //Connection con = DatabaseManager.getConnectionClassForName(USERNAME, PASSWORD);
        Connection con = DatabaseManager.getConnectionDriverRegister(USERNAME, PASSWORD);
        DatabaseManager.checkConnection(con);

        /*
        System.out.println("------CREATE--------");
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("FirstName", "varchar2(32 BYTE)");
        hm.put("LastName", "varchar2(32 BYTE)");
        hm.put("ID", "NUMBER");
        String tableName = "NAMES";
        //DatabaseManager.create(con, tableName, hm);
        DatabaseManager.drop(con, tableName);*/

        /*System.out.println("--------JOB--------");
        JobDao jd = new JobDao();
        ArrayList<Job> arrayJob = jd.getAllJobs(con);
        System.out.println("Job: " + jd.getJobById(con, "AD_VP").toString());

        for(Job job : arrayJob) {
            System.out.println(job);
        }

        System.out.println("--------DEPT--------");
        DepartmentDao dd = new DepartmentDao();
        ArrayList<Department> arrayDept = dd.getAllDepartments(con);
        System.out.println("Dept: " + dd.getDepartmentById(con, "10"));

        for(Department dept : arrayDept) {
            System.out.println(dept);
        }

        System.out.println("--------EMP--------");
        EmployeeDao emp = new EmployeeDao();
        ArrayList<Employee> arrayEmp = emp.getAllEmployees(con);
        System.out.println("Emp: " + emp.getEmployeeById(con, "100"));

        for(Employee employee : arrayEmp) {
            System.out.println(employee);
        }

        System.out.println("--------EMP-VIEW----");
        EmployeeViewDao empView = new EmployeeViewDao();
        EmployeeView arrayEmpView = empView.getEmployeeView(con, 100l);

        System.out.println(arrayEmpView);*/

        /*Employee emp = new Employee();
        emp.setId(80l);
        emp.setFirstName("Andrei");
        emp.setLastName("Stoica");
        emp.setEmail("stoica.andrei@gmail.com");
        emp.setPhoneNumber("1234.5555.333");
        emp.setHireDate(new Date());
        Job job = new Job();
        job.setId("AD_VP");
        emp.setJob(job);
        emp.setSalary(1000d);
        emp.setCommisionPoints(10d);

        EmployeeDao empDao = new EmployeeDao();
        empDao.getEmployeeById(con, "100");
        emp.setManager();
        Department dept = new Department();
        dept.setId(100l);
        emp.setDepartment(dept);*/

        EmployeeDao empDao = new EmployeeDao();
        Employee employee = empDao.getEmployeeById(con, "101");

        employee.setId(80l);
        empDao.saveEmployee(employee, con);

    }
}
