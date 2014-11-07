package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.dao.LocationDao;
import ro.teamnet.zth.domain.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Miha on 11/5/2014.
 */
public class ResultSetToPojoConverter {
    private static DepartmentDao departmentDao = new DepartmentDao();
    private static JobDao jobDao = new JobDao();
    private static EmployeeDao employeeDao = new EmployeeDao();
    private static LocationDao locationDao = new LocationDao();

    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) throws SQLException{
        ArrayList<EmployeeView> al = new ArrayList<EmployeeView>();
        while(rs.next()){
            EmployeeView j = new EmployeeView();
            j.setId(rs.getLong("employee_id"));
            j.setDepartmentName(rs.getString("department_name"));
            j.setFirstName(rs.getString("first_name"));
            j.setLastName(rs.getString("last_name"));
            al.add(j);
        }
        return al;
    }

    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Employee> al = new ArrayList<Employee>();
        while(rs.next()){
            Employee j = new Employee();
            j.setId(rs.getLong("employee_id"));
            j.setComissionPoints(rs.getDouble("commission_pct"));
            j.setEmail(rs.getString("email"));
            j.setFirstName(rs.getString("first_name"));
            j.setLastName(rs.getString("last_name"));
            j.setPhoneNumber(rs.getString("phone_number"));
            j.setSalary(rs.getDouble("salary"));
            j.setHireDate(rs.getDate("hire_date"));
            Department dep = departmentDao.getDepartmentById(con, rs.getString("department_id"));
            j.setDepartment(dep);
            Job job = jobDao.getJobById(con, rs.getString("job_id"));
            j.setJob(job);
            Employee em = employeeDao.getEmployeeById(con, rs.getLong("manager_id"));
            j.setManager(em);
            al.add(j);
        }
        return al;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Department> al = new ArrayList<Department>();
        while(rs.next()){
            Department d = new Department();
            d.setId(rs.getLong("department_id"));
            d.setDepartmentName(rs.getString("department_name"));
            Location loc = locationDao.getLocationById(con, rs.getLong("location_id"));
            d.setLocation(loc);
            al.add(d);
        }
        return al;
    }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Job> al = new ArrayList<Job>();
        while(rs.next()){
            Job j = new Job();
            j.setId(rs.getString("job_id"));
            j.setJobTitle(rs.getString("job_title"));
            j.setMaxSalary(rs.getDouble("min_salary"));
            j.setMinSalary(rs.getDouble("max_salary"));
            al.add(j);
        }
        return al;
    }

    public static ArrayList<Location> convertToLocation(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Location> al = new ArrayList<Location>();
        while(rs.next()){
            Location d = new Location();
            d.setId(rs.getLong("location_id"));
            d.setCity(rs.getString("city"));
            d.setPostalCode(rs.getString("postal_code"));
            d.setStateProvince(rs.getString("state_province"));
            d.setStreetAddress(rs.getString("street_address"));
            al.add(d);
        }
        return al;
    }
}
