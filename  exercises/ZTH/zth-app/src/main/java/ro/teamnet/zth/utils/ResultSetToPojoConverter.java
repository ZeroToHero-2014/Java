package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.view.EmployeeView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ovy on 11/5/2014.
 */
public class ResultSetToPojoConverter {
    private static DepartmentDao departmentDao = new DepartmentDao();
    private static JobDao jobDao = new JobDao();
    private static EmployeeDao demployeeDao = new EmployeeDao();

    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException {

        ArrayList<Employee> emp1 = new ArrayList<Employee>();
       while (rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getLong("employee_id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));

            emp.setEmail(rs.getString("email"));
            emp.setPhoneNumber(rs.getString("phone_number"));
            emp.setHireDate(rs.getDate("hire_date"));
           String re= rs.getString(("job_id"));
            JobDao jd= new JobDao();
           // Job b = jd.getJobById(con,re);
            emp.setJob(jd.getJobById(con,re));
            emp.setSalary(rs.getDouble("salary"));
            emp.setComissionPoints(rs.getDouble("commission_pct"));
            DepartmentDao d= new DepartmentDao();
           String ru= rs.getString(("department_id"));
            emp.setDepartment(d.getDepartmentById(con,ru));
            EmployeeDao e= new EmployeeDao();
           String eu= rs.getString("manager_id");
            emp.setManager(e.getEmployeeById(con,eu));


            emp1.add(emp);
        }
        return emp1;

    }



    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) throws SQLException {
        String sq = "";

        ArrayList<Job> jobs = new ArrayList<Job>();
        while (rs.next()) {
            Job job = new Job();
            job.setId(rs.getString("job_id"));
            job.setTitle(rs.getString("job_title"));
            job.setMax_salary(rs.getDouble("max_salary"));
            job.setMin_salary(rs.getDouble("min_salary"));
            jobs.add(job);

        }


        return jobs;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws SQLException {

        String sq = "";

        ArrayList<Department> dep = new ArrayList<Department>();
        while (rs.next()) {

            Department dep1 = new Department();
            dep1.setId(rs.getLong("department_id"));
            dep1.setDepartment(rs.getString("department_name"));
            dep1.setLocation(rs.getLong("location_id"));
            dep.add(dep1);

        }
        return dep;


    }
    public static  ArrayList<EmployeeView> convertEmployeeView(ResultSet rs,Connection con) throws SQLException{
        ArrayList<EmployeeView> jobs = new ArrayList<EmployeeView>();
        while (rs.next()) {
ArrayList<Employee> e = demployeeDao.getAllEmployees(con);
            ArrayList<Job> j = jobDao.getAllJobs(con);
            ArrayList<Department> d= departmentDao.getAlldepartment(con);
           EmployeeView emp = new EmployeeView();

            emp.setId(rs.getLong("employee_id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setManager(e);
            emp.setEmail(rs.getString("email"));
            emp.setPhoneNumber(rs.getString("phone_number"));
            emp.setHireDate(rs.getDate("hire_date"));
            emp.setJob(j);
            emp.setSalary(rs.getDouble("salary"));
            emp.setComissionPoints(rs.getDouble("commission_pct"));
            emp.setDepartment(d);




            jobs.add(emp);


        }
        return jobs;

    }
}
