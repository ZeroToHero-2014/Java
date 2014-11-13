package ro.teamnet.zth.utils;


import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetToPojoConverter {
   // employee_id, first_name, last_name, email," +
   //         " phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id
    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException {

        ArrayList<Employee> employees = new ArrayList<Employee>();
        while(rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getLong("employee_id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setEmail(rs.getString("email"));
            emp.setHireDate(rs.getDate("hire_date"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setCommissionPoints(rs.getDouble("commission_pct"));
            emp.setPhoneNumber(rs.getString("phone_number"));

            emp.setManager((new EmployeeDao()).getEmployeeById(con,rs.getLong("manager_id")));
            emp.setJob((new JobDao()).getJobById(con, rs.getString("job_id")));
            emp.setDepartment((new DepartmentDao()).getDepartmentById(con, rs.getLong("department_id")));
            employees.add(emp);
        }
        rs.close();
        return employees;
    }

    public static ArrayList<Job> convertToJob(ResultSet rs) throws SQLException {
        String job_id, job_title;
        Double min_salary, max_salary;
        ArrayList<Job> jobs = new ArrayList<Job>();
        while(rs.next()) {
            job_id = rs.getString("job_id");
            job_title = rs.getString("job_title");
            min_salary = rs.getDouble("min_salary");
            max_salary = rs.getDouble("max_salary");
            jobs.add(new Job(job_id, job_title, min_salary, max_salary));
        }
        rs.close();
        return jobs;
    }
    public static ArrayList<Department> convertToDepartment(ResultSet rs) throws SQLException {

        ArrayList<Department> departments = new ArrayList<Department>();
        while(rs.next()) {
            Department dept = new Department();
            dept.setDepartmentName(rs.getString("department_name"));
            dept.setId(rs.getLong("department_id"));
            departments.add(dept);
        }
        rs.close();
        return departments;
    }
}
