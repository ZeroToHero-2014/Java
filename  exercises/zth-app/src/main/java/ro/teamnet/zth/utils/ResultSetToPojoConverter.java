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

public class ResultSetToPojoConverter {


//        private static DepartmentDao departmentDao = new DepartmentDao();
//        private static JobDao


    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        while(rs.next()){
            Employee employee = new Employee();
            employee.setId(rs.getLong("Employee_id"));
            employee.setCommissionPoints(rs.getDouble("commission_pct"));
            employee.setEmail(rs.getString("email"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setHireDate(rs.getDate("hire_date"));
            employee.setPhoneNumber(rs.getString("phone_number"));
            employee.setJob(new JobDao().getJobByID(con, rs.getString("job_id")));
            employee.setManager(new EmployeeDao().getEmployeeByID(con, rs.getLong("manager_id")));
            employee.setDepartment(new DepartmentDao().getDepartmentByID(con, rs.getLong("department_id")));
            employee.setSalary(rs.getDouble("salary"));
            employees.add(employee);
        }
        return employees;
    }

    public static ArrayList<Job> convertToJob(ResultSet rs, Connection con) {
       ArrayList<Job> jobs = new ArrayList<Job>();

        try {
            while(rs.next()){
             Job job = new Job();
             job.setId(rs.getString("JOB_ID")) ;
             job.setJobTitle(rs.getString("JOB_TITLE"));
             job.setMaxSalary(rs.getDouble("MAX_SALARY"));
             job.setMinSalary(rs.getDouble("MIN_SALARY"));
             jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) {
        ArrayList<Department> depts = new ArrayList<Department>();

        try {
            while(rs.next()){
                Department department = new Department();
                department.setId(rs.getLong("DEPARTMENT_ID")) ;
                department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                depts.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    }

}
