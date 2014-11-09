package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Maria on 11/5/2014.
 */
public class ResultSetToPojoConverter {

   // private static DepartmentDao departmentDao = new DepartmentDao();
   // private static JobDao jobDao = new JobDao();
   //

    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con)
    {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getLong("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setManager(new EmployeeDao().getEmployeeById(con, rs.getLong("manager_id")));
                employee.setEmail(rs.getString("email"));
                employee.setHireDate(rs.getDate("hire_date"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setCommissionPoints(rs.getDouble("commission_pct"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setJob(new JobDao().getJobById(con, rs.getString("job_id")));
                employee.setDepartment(new DepartmentDao().getDepartmentById(con, rs.getString("department_id")));

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static ArrayList<Job> convertToJob (ResultSet rs, Connection con) throws SQLException
    {
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

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws SQLException
    {
        ArrayList<Department> departments =new ArrayList<Department>();

        while (rs.next()){
            Department department = new Department();
            department.setId(rs.getLong("department_id"));
            department.setDepartmentName(rs.getString("department_name"));
            departments.add(department);
        }
        return departments;
    }

    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) {

        ArrayList<EmployeeView> employeeViews= new ArrayList<EmployeeView>();

        try {
            while(rs.next()){
                EmployeeView employeeView = new EmployeeView();

                employeeView.setId(rs.getLong("employee_id"));
                employeeView.setDepartmentName(rs.getString("department_name"));
                employeeView.setFirstName(rs.getString("first_name"));
                employeeView.setLastName(rs.getString("last_name"));
                employeeView.setSalary(rs.getDouble("salary"));
                employeeViews.add(employeeView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeViews;
    }

    public static ArrayList<Location> convertToLocation(ResultSet rs, Connection con){
        ArrayList<Location> locations = new ArrayList<Location>();

            try {
                while (rs.next()){
                    Location location = new Location();
                    location.setId(rs.getLong("location_id"));
                    location.setPostalCode(rs.getString("postal_code"));
                    location.setCity(rs.getString("city"));
                    location.setStateProvince(rs.getString("state_province"));
                    location.setStreetAdress(rs.getString("street_address"));
                    locations.add(location);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return locations;
        }

    }



