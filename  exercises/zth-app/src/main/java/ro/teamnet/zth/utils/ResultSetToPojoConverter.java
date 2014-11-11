package ro.teamnet.zth.utils;


import ro.teamnet.zth.dao.*;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.views.EmployeeView;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetToPojoConverter {

    private static DepartmentDao departmentDao = new DepartmentDao();
    private static JobDao jobDao= new JobDao();
    private static EmployeeDao employeeDao = new EmployeeDao();
    private static EmployeeViewDao employeeVeiwDao = new EmployeeViewDao();

    public static ArrayList<Employee> convertToEmployee (ResultSet rs, Connection con) throws SQLException{

    ArrayList<Employee> employees = new ArrayList<Employee>();
        while(rs.next()) {
            Employee employee = new Employee();
            //Job job = JobDao.getJobById(con, rs.getString("job_id"));
            Department department = departmentDao.getDepartmentById(con, rs.getLong("department_id"));
            Employee manager = employeeDao.getEmployeeById(con, rs.getLong("manager_id"));

            employee.setId(rs.getLong("employee_id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setPhoneNumber(rs.getString("phone_number"));
            employee.setHireDate(rs.getDate("hire_date"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setJob( new JobDao().getJobById(con, rs.getString("job_id")));
            employee.setCommissionPoints(rs.getDouble("commission_pct"));
            employee.setManager(manager);
            employee.setDepartment(department);
            employees.add(employee);
        }
        return employees;
    }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) throws SQLException {

    ArrayList<Job> jobs = new ArrayList<Job>();
        while(rs.next()) {
            Job job = new Job();
            job.setId(rs.getString("job_id"));
            job.setJobTitle(rs.getString("job_title"));
            job.setMaxSalary(rs.getDouble("max_salary"));
            job.setMinSalary(rs.getDouble("min_salary"));
            jobs.add(job);
        }

        return jobs;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws SQLException {

    ArrayList<Department> departments = new ArrayList<Department>();
        while(rs.next()) {


            Department department = new Department();
            department.setId(rs.getLong("department_id"));
            department.setDepartmentName(rs.getString("department_name"));
            department.setLocation( new LocationDao().getLocationById(con, rs.getLong("location_id")));
            departments.add(department);
        }

        return departments;

    }

    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) throws SQLException {
        ArrayList<EmployeeView> employeeViews = new ArrayList<EmployeeView>();

        while(rs.next()) {
            EmployeeView employeeView = new EmployeeView();
            ArrayList<Job> jobs = jobDao.getAllJobs(con);
            ArrayList<Department> departments = departmentDao.getAllDepartment(con);
            ArrayList<Employee> managers = employeeDao.getAllEmployees(con);

            employeeView.setId(rs.getLong("employee_id"));
            employeeView.setFirstName(rs.getString("first_name"));
            employeeView.setLastName(rs.getString("last_name"));
            employeeView.setEmail(rs.getString("email"));
            employeeView.setPhoneNumber(rs.getString("phone_number"));
            employeeView.setHireDate(rs.getDate("hire_date"));
            employeeView.setJobs(jobs);
            employeeView.setSalary(rs.getDouble("salary"));
            employeeView.setCommissionPoints(rs.getDouble("commission_pct"));
            employeeView.setManagers(managers);
            employeeView.setDepartments(departments);

            employeeViews.add(employeeView);

        }
        return employeeViews;
    }

    public static ArrayList<Location> convertToLocation (ResultSet rs, Connection con) throws SQLException {

        ArrayList<Location> locations = new ArrayList<Location>();

        while(rs.next()) {

            Location location = new Location();

            location.setId(rs.getLong("location_id"));
            location.setStreetAddress(rs.getString("street_address"));
            location.setPostalCode(rs.getString("postal_code"));
            location.setCity(rs.getString("city"));
            location.setStateProvince(rs.getString("state_province"));

            locations.add(location);
        }

        return locations;
    }

}
