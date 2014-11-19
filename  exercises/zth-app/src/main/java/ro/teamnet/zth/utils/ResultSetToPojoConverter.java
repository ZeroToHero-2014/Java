package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.*;
import ro.teamnet.zth.domain.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by hangan on 11/5/2014.
 */
public class ResultSetToPojoConverter {
    private static DepartmentDao departmentDao = new DepartmentDao();
    private static JobDao jobDao = new JobDao();
    private static EmployeeDao employeeDao = new EmployeeDao();
    private static LocationsDao locationsDao = new LocationsDao();

    public static ArrayList<Employee> covertToEmployee(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Employee>employees=new ArrayList<Employee>();
        while(rs.next()){
            Employee e=new Employee();

            Job job = jobDao.getJobByID(con,rs.getString("job_id"));
            Department department = departmentDao.getDepartmentByID(con, rs.getString("department_id"));
            Employee manager = employeeDao.getEmployeeByID(con,rs.getLong("manager_id"));

            e.setId(rs.getLong("employee_id"));
            e.setFirstName(rs.getString("first_name"));
            e.setLastName(rs.getString("last_name"));
            e.setEmail(rs.getString("email"));
            e.setPhoneNumber(rs.getString("phone_number"));
            e.setHireDate(rs.getDate("hire_date"));
            e.setJob(job);
            e.setSalary(rs.getDouble("salary"));
            e.setCommissionPoints(rs.getDouble("comission_pct"));
            e.setManager(manager);
            e.setDepartment(department);


            employees.add(e);
        }
        return employees;
    }
    public static ArrayList<Job> covertToJob(ResultSet rs, Connection con) throws SQLException{

        ArrayList<Job>jobs=new ArrayList<Job>();

      while(rs.next()){
          Job j= new Job();
          j.setId(rs.getString("job_id"));
          j.setJobTitle((rs.getString("job_title")));
          j.setMinSalary(rs.getDouble("min_salary"));
          j.setMaxSalary(rs.getDouble("max_salary"));

          jobs.add(j);

      }

        return jobs;
    }
    public static ArrayList<Department> covertToDepartment(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Department>departments=new ArrayList<Department>();

        while(rs.next()){
            Department d= new Department();
            d.setId(rs.getLong("department_id"));
            d.setDepartmentName((rs.getString("department_Name")));


            departments.add(d);

        }

        return departments;
    }
    public static ArrayList<Locations> covertToLocations(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Locations>locations=new ArrayList<Locations>();
        while(rs.next()){
            Locations l=new Locations();

            l.setId(rs.getLong("location_id"));
            l.setStreetAddress(rs.getString("street_address"));
            l.setPostalCode(rs.getString("postal_code"));
            l.setCity(rs.getString("city"));
            l.setCity(rs.getString("state_province"));

            locations.add(l);
        }
        return locations;


    }

    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) throws SQLException{
        ArrayList<EmployeeView> arrayListFromResultSet = new ArrayList<EmployeeView>();
        while(rs.next()){
            EmployeeView employeeView = new EmployeeView();
            employeeView.setEmployeeId(rs.getLong("employee_id"));
            employeeView.setFirstName(rs.getString("first_name"));
            employeeView.setDepartmentName(rs.getString("department_name"));
            arrayListFromResultSet.add(employeeView);
        }
        return arrayListFromResultSet;
    }
}

