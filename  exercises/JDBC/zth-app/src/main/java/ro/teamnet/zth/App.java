package ro.teamnet.zth;

<<<<<<< HEAD
=======
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.EmployeeViewDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.DatabaseManager;
<<<<<<< HEAD
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
=======
import ro.teamnet.zth.views.EmployeeView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    private static final String USERNAME = "ZTH_24";
    private static final String PASSWORD = "passw0rd";

    public static void main(String[] args) {
        System.out.println("Starting ZTH JDBC Tutorial ");

        Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
        DatabaseManager.checkConnection(con);

        ObjectMapper mapper = new ObjectMapper();

        HashMap<String, String> createTableJobs = new HashMap<String, String>();

        if (false) {
            createTableJobs.put("job_id", "VARCHAR2(10) PRIMARY KEY");
            createTableJobs.put("job_title", "VARCHAR2(35) NOT NULL");
            createTableJobs.put("min_salary", "NUMBER(6)");
            createTableJobs.put("max_salary", "NUMBER(6)");
            DatabaseManager.create(con, "jobs", createTableJobs);


            HashMap<String, String> createTableDepartments = new HashMap<String, String>();
            createTableDepartments.put("department_id", "NUMBER PRIMARY KEY");
            createTableDepartments.put("department_name", "VARCHAR2(30) NOT NULL");
            DatabaseManager.create(con, "departments", createTableDepartments);
        }

        if (false) {
            DatabaseManager.drop(con, "jobs");
            DatabaseManager.drop(con, "departments");
        }


        JobDao jobDao = new JobDao();
        try {
            ArrayList<Job> jobs = jobDao.getAllJobs(con);
            System.out.println("System retrieved " + jobs.size() + " jobs");
            Job job = jobDao.getJobById(con, "AD_PRES");
            System.out.println("System retrieved the following job title: " + job.getJobTitle() + " from database");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DepartmentDao departmentDao = new DepartmentDao();
        try {
            ArrayList<Department> departments = departmentDao.getAllDepartments(con);
            System.out.println("System retrieved " + departments.size() + " departments");
            Department department = departmentDao.getDepartmentById(con, 10L);
            System.out.println("System retrieved the following department title: " + department.getDepartmentName() + " from database");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        EmployeeDao employeeDao = new EmployeeDao();
        try {
            ArrayList<Employee> employees = employeeDao.getAllEmployees(con);
            System.out.println("System retrieved " + employees.size() + " employees");
            Employee employee = employeeDao.getEmployeeById(con, 101L);
            System.out.println("System retrieved Mr/Mrs " + employee.getFirstName() + " " + employee.getLastName() + " from database");
            employeeDao.updateEmployee(employee, con);
            employeeDao.saveEmployee(employee, con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        EmployeeViewDao employeeViewDao = new EmployeeViewDao();

        EmployeeView employeeView = null;

        try {

            employeeView = employeeViewDao.getEmployeeView(con, 101L);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            System.out.println(mapper.writeValueAsString(employeeView));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }


        DatabaseManager.closeConnection(con);
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba

    }
}
