package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Buli on 11/5/2014.
 */
public class ResultSetToPojoConvert {



    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Employee> arrayListFromResultSet = new ArrayList<Employee>();
        JobDao jobDao = new JobDao();
        EmployeeDao employeeDao = new EmployeeDao();
        while(rs.next()){
            Employee newEmployee = new Employee();
            newEmployee.setEmployeeId(rs.getLong("employee_id"));
            newEmployee.setFirstName(rs.getString("first_name"));
            newEmployee.setLastName(rs.getString("last_name"));
            newEmployee.setEmail(rs.getString("email"));
            newEmployee.setHireDate(rs.getDate("hire_date"));
            newEmployee.setJob(jobDao.getJobById(con,rs.getString("job_id")));
            newEmployee.setSalary(rs.getDouble("salary"));
            newEmployee.setCommisionPoints(rs.getDouble("commission_pct"));
            newEmployee.setManager(employeeDao.getEmployeeById(con,rs.getInt("manager_id")));
            newEmployee.setDepartment((new DepartmentDao().getDepartmentById(con,rs.getInt("department_id"))));
            arrayListFromResultSet.add(newEmployee);
        }
        return arrayListFromResultSet;
    }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Job> arrayListFromResultSet = new ArrayList<Job>();
        while(rs.next()){
            Job newJob = new Job();
            newJob.setJobId(rs.getString("job_id"));
            newJob.setJobTitle(rs.getString("job_title"));
            newJob.setMinSalary(rs.getDouble("min_salary"));
            newJob.setMaxSalary(rs.getDouble("max_salary"));
            arrayListFromResultSet.add(newJob);
        }
        return arrayListFromResultSet;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Department> arrayListFromResultSet = new ArrayList<Department>();
        while (rs.next()){
            Department department = new Department();
            department.setDepartmentId(rs.getLong("department_id"));
            department.setDepartmentName(rs.getString("department_name"));
            arrayListFromResultSet.add(department);
        }
        return arrayListFromResultSet;
    }

}
