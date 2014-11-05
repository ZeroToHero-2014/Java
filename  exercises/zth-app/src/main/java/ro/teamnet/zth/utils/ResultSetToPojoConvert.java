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
 * Created by user on 11/5/2014.
 */
public class ResultSetToPojoConvert {
    private static DepartmentDao departmentDao= new DepartmentDao();
    private static JobDao jobDao= new JobDao();
    private static EmployeeDao employeeDao= new EmployeeDao();

    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException {
        /*
        private Long id;
        private String firstName;
        private Employee manager;
        private String email;
        private Date hireDate;
        private Double salary;
        private Double commissionPoints;
        private String phoneNumber;
        private Job job;
        private Department department;
        */
        ArrayList<Employee> employees=new ArrayList<Employee>();

            while (rs.next()){
                Employee employee= new Employee();
                Job job= jobDao.getJobById(con,rs.getString("job_id"));
                Department department=departmentDao.getDepartmentById(con, rs.getString("department_id"));
                Employee manager= employeeDao.getEmployeeById(con, rs.getLong("manager_id"));

                employee.setId(rs.getLong("employee_id"));
                employee.setFirstName(rs.getString("first_Name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setComissionPoints(rs.getDouble("commission_pct"));
                employee.setHireDate(rs.getDate("hire_date"));
                employee.setJob(job);
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartment(department);
                employee.setManager(manager);

                employees.add(employee);

        }

    return employees;

    }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) throws SQLException {


        ArrayList<Job> jobs = new ArrayList<Job>();
        int i = 1;

        while (rs.next()) {
            String id = rs.getString("job_id");
            String title = rs.getString("job_title");
            Double minsalary = rs.getDouble("min_salary");
            Double maxsalary = rs.getDouble("max_salary");

            Job j = new Job();
            j.setId(id);
            j.setJobTitle(title);
            j.setMaxSalary(maxsalary);
            j.setMinSalary(minsalary);

            jobs.add(j);

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
