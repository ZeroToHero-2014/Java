package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.views.EmployeeView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class ResultSetToPojoConverter {

    private static DepartmentDao departmentDao = new DepartmentDao();
    private static JobDao jobDao = new JobDao();
    private static EmployeeDao employeeDao = new EmployeeDao();

    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        while (rs.next()) {
            Employee employee = new Employee();
            Job job = jobDao.getJobById(con,rs.getString("job_id"));
            Department department = departmentDao.getDepartmentById(con, rs.getLong("department_id"));
            Employee manager =  employeeDao.getEmployeeById(con, rs.getLong("manager_id"));


            employee.setId(rs.getLong("employee_id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setPhoneNumber(rs.getString("phone_number"));
            employee.setHireDate(rs.getDate("hire_date"));
            employee.setJob(job);
            employee.setSalary(rs.getDouble("salary"));
            employee.setCommissionPoints(rs.getDouble("commission_pct"));
            employee.setManager(manager);
            employee.setDepartment(department);

            employees.add(employee);
        }
        return employees;
    }

    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) throws SQLException {

           ArrayList<EmployeeView> employeeViews = new ArrayList<EmployeeView>();

           while (rs.next()) {
               EmployeeView employeeView = new EmployeeView();
               ArrayList<Job> jobs = jobDao.getAllJobs(con);
               ArrayList<Department> departments = departmentDao.getAllDepartments(con);
               ArrayList<Employee> managers =  employeeDao.getAllEmployees(con); //de modificat sa se excluda pe sine


               employeeView.setId(rs.getLong("employee_id"));
               employeeView.setFirstName(rs.getString("first_name"));
               employeeView.setLastName(rs.getString("last_name"));
               employeeView.setEmail(rs.getString("email"));
               employeeView.setPhoneNumber(rs.getString("phone_number"));
               employeeView.setHireDate(rs.getDate("hire_date"));
               employeeView.setJob(jobs);
               employeeView.setSalary(rs.getDouble("salary"));
               employeeView.setCommissionPoints(rs.getDouble("commission_pct"));
               employeeView.setManager(managers);
               employeeView.setDepartment(departments);

               employeeViews.add(employeeView);
           }
           return employeeViews;
       }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) throws SQLException {
        ArrayList<Job> jobs = new ArrayList<Job>();
        while (rs.next()) {
            Job job = new Job();
            job.setId(rs.getString("job_id"));
            job.setJobTitle(rs.getString("job_title"));
            job.setMinSalary(rs.getDouble("min_salary"));
            job.setMaxSalary(rs.getDouble("max_salary"));

            jobs.add(job);
        }
        return jobs;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws SQLException {
            ArrayList<Department> departments = new ArrayList<Department>();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getLong("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                departments.add(department);
            }
            return departments;
        }

}
