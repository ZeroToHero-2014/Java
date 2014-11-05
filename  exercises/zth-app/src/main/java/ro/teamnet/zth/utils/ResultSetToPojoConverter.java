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

/**
 * Created by Ifrim on 05.11.2014.
 */
public class ResultSetToPojoConverter {

    private static DepartmentDao departmentDao = new DepartmentDao();
    private static JobDao jobDao = new JobDao();
    private static EmployeeDao employeeDao = new EmployeeDao();

//    private static Department departmentDao = new DepartmentDao();
//    private static JobDao= new JobDao();
//    private static EmployeeDao employeeDao = new EmployeeDao();

    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection x) throws SQLException{
        ArrayList<Employee> emps = new ArrayList<Employee>();


        while(rs.next())
        {
            Employee emp = new Employee();
            Job job = jobDao.getJobId (x, rs.getString("job_id"));
            Department department = departmentDao.getDepartmentId(x, rs.getLong("department_id"));
            Employee manager = employeeDao.getEmployeeId(x, rs.getLong("manager_id"));


            emp.setId(rs.getLong("employee_id"));
            emp.setFirsName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setEmail(rs.getString("email"));
            emp.setPhoneNumber(rs.getString("phone_number"));
            emp.setHireDate(rs.getDate("hire_date"));
            emp.setJob(job);
            emp.setSalary(rs.getDouble("salary"));
            emp.setCommissionPoints(rs.getDouble("commission_pct"));
            emp.setManager(manager);
            emp.setDepartment(department);

            emps.add(emp);
        }
        return emps;
    }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection x) throws SQLException{
        ArrayList<Job> jobs = new ArrayList<Job>();


        while(rs.next())
        {
            Job job = new Job();
            job.setId(rs.getString("job_id"));
            job.setJobTitle(rs.getString("job_title"));
            job.setMinSalary(rs.getDouble("min_salary"));
            job.setMaxSalary(rs.getDouble("max_salary"));
            jobs.add(job);
        }
            return jobs;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection x) throws SQLException {
    ArrayList<Department> dps = new ArrayList<Department>();


    while(rs.next())
    {
        Department dp = new Department();
        dp.setId(rs.getLong("department_id"));
        dp.setDepartmentName(rs.getString("department_name"));
        dps.add(dp);
    }
    return dps;
}
}
