package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.views.EmployeeView;

import java.awt.geom.Arc2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by George on 11/5/2014.
 */
public class ResultSetToPojoConverter {

    private static DepartmentDao departmentDao = new DepartmentDao();
    private static JobDao jobDao = new JobDao();
    private static EmployeeDao employeeDao = new EmployeeDao();

    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Employee> employees = new ArrayList<Employee>();
        while (rs.next()){
            Employee employee = new Employee();
            employee.setId(rs.getLong("employee_id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLasName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setPhoneNumber(rs.getString("phone_number"));
            employee.setHireDate(rs.getDate("hire_date"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setCommissionPoints(rs.getDouble("commission_pct"));

            employee.setJob(jobDao.getJobById(con, rs.getString("job_id")));
            employee.setManager(employeeDao.getEmployeeById(con, rs.getLong("manager_id")));
            employee.setDepartment(departmentDao.getDepartmentById(con, rs.getString("department_id")));

            employees.add(employee);
        }
        return  employees;
    }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Job> jobs = new ArrayList<Job>();

        while (rs.next()){
            Job job = new Job();
            job.setId(rs.getString("job_id"));
            job.setTitle(rs.getString("job_title"));
            job.setMaxSalary(rs.getDouble("min_salary"));
            job.setMinSalary(rs.getDouble("max_salary"));

            jobs.add(job);
        }
        return jobs;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Department> departments = new ArrayList<Department>();

        while (rs.next()){
            Department department = new Department();
            department.setId(rs.getLong("department_id"));
            department.setDepartmentName(rs.getString("department_name"));

            departments.add(department);
        }
        return departments;
    }

    public static ArrayList<Location> convertToLocation(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Location> locations = new ArrayList<Location>();

        while (rs.next()){
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

    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) throws SQLException{
        ArrayList<EmployeeView> employeeViews = new ArrayList<EmployeeView>();

        while (rs.next()){
            EmployeeView employeeView = new EmployeeView();
            employeeView.setId(rs.getLong("location_id"));
            employeeView.setFirstName(rs.getString("first_name"));
            employeeView.setDepartmentName(rs.getString("department_name"));
            employeeViews.add(employeeView);
        }
        return employeeViews;
    }
}
