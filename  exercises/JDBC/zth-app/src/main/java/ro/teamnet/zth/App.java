package ro.teamnet.zth;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.EmployeeViewDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.DatabaseManager;
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

    }
}
