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
 * Created by Bogdan on 11/5/2014.
 */
public class ResultSetToPojoConverter
{

    private static DepartmentDao departmentDao = new DepartmentDao();
    private static EmployeeDao employeeDao = new EmployeeDao();
    private static JobDao jobDao = new JobDao();

    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException
    {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        while (rs.next())
        {
            Employee employee = new Employee();

            employee.setId(rs.getLong("employee_id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setPhoneNumber(rs.getString("phone_number"));
            employee.setHireDate(rs.getDate("hire_date"));


            Job job = new JobDao().getJobById(con,rs.getString("job_id"));
            employee.setJob(job);
            employee.setSalary(rs.getDouble("salary"));
            employee.setCommissionPoints(rs.getDouble("commission_pct"));

            Employee manager = new EmployeeDao().getEmployeeById(con, rs.getLong("manager_id") + "");
            employee.setManager(manager);
            Department department = new DepartmentDao().getDepartmentById(con, rs.getLong("department_id") + "");
            employee.setDepartment(department);

            employees.add(employee);
        }
        return employees;
    }

    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) throws SQLException
    {
        ArrayList<EmployeeView> employees = new ArrayList<EmployeeView>();
        while (rs.next())
        {
            EmployeeView employee = new EmployeeView();

            employee.setId(rs.getLong("employee_id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setPhoneNumber(rs.getString("phone_number"));
            employee.setHireDate(rs.getDate("hire_date"));

            ArrayList<Job> job = new JobDao().getAllJobs(con);
            employee.setJob(job);

            employee.setSalary(rs.getDouble("salary"));
            employee.setCommissionPoints(rs.getDouble("commission_pct"));

            //Adaug doar angajatii care au cuvantul Manager in job_title
            ArrayList<Employee> empl = new EmployeeDao().getAllEmployees(con);
            ArrayList<Employee> managers = new ArrayList<Employee>();
            for(int i = 0; i < empl.size(); i++)
            {
                if(empl.get(i).getJob().getJobTitle().contains("Manager"))
                    managers.add(empl.get(i));
            }
            System.out.println(managers);
            employee.setManager(managers);
            ArrayList<Department> department = new DepartmentDao().getAllDepartments(con);
            employee.setDepartment(department);

            employees.add(employee);
        }
        return employees;
    }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) throws SQLException
    {
        ArrayList<Job> jobs = new ArrayList<Job>();

        while (rs.next())
        {
            Job job = new Job();
            job.setId(rs.getString("job_id"));
            job.setJobTitle(rs.getString("job_title"));
            job.setMaxSalary(rs.getLong("max_salary"));
            job.setMinSalary(rs.getLong("min_salary"));
            jobs.add(job);
        }

        return jobs;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws SQLException
    {
        ArrayList<Department> departments = new ArrayList<Department>();

        while (rs.next())
        {
            Department department = new Department();
            department.setId(rs.getString("department_id"));
            department.setDepartmentName(rs.getString("department_name"));
            departments.add(department);
        }

        return departments;
    }
}
