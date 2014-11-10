package ro.teamnet.zth.utils;

import ro.teamnet.zth.Views.EmployeeView;
import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class ResultSetToPojoConverter {



    public static ArrayList<Employee> convertToEmployee(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Employee> arrayListFromResultSet = new ArrayList<Employee>();
        JobDao jobDao = new JobDao();
        EmployeeDao employeeDao = new EmployeeDao();
        while(rs.next()){
            Employee newEmployee = new Employee();
            newEmployee.setId(rs.getLong("employee_id"));
            newEmployee.setFirstName(rs.getString("first_name"));
            newEmployee.setLastName(rs.getString("last_name"));
            newEmployee.setEmail(rs.getString("email"));
            newEmployee.setHireDate(rs.getDate("hire_date"));
            newEmployee.setJob(jobDao.getJobById(con,rs.getString("job_id")));
            newEmployee.setSalary(rs.getDouble("salary"));
            newEmployee.setCommissionPoints(rs.getDouble("commission_pct"));
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
            newJob.setId(rs.getString("job_id"));
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
            department.setId(rs.getLong("department_id"));
            department.setDepartmentName(rs.getString("department_name"));
            arrayListFromResultSet.add(department);
        }
        return arrayListFromResultSet;
    }
    public static ArrayList<Location> convertToLocation(ResultSet rs, Connection con) throws SQLException{
        ArrayList<Location> arrayListFromResultSet = new ArrayList<Location>();
        while (rs.next()){
            Location location = new Location();
            location.setId(rs.getLong("location_id"));
            location.setCity(rs.getString("city"));
            arrayListFromResultSet.add(location);
        }
        return arrayListFromResultSet;
    }
    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) throws SQLException {

        ArrayList<EmployeeView> employeeViews = new ArrayList<EmployeeView>();

        while (rs.next()) {
            EmployeeView employeeView = new EmployeeView();
            ArrayList<Job> jobs = JobDao.getAllJobs(con);
            ArrayList<Department> departments = DepartmentDao.getAllDepartments(con);
            ArrayList<Employee> managers =  EmployeeDao.getAllEmployees(con); //de modificat sa se excluda pe sine


            employeeView.setId(rs.getLong("employee_id"));
            employeeView.setFirstName(rs.getString("first_name"));
            employeeView.setLastName(rs.getString("last_name"));
            employeeView.setEmail(rs.getString("email"));
            employeeView.setPhoneNumber(rs.getString("phone_number"));
            employeeView.setHireDate(rs.getDate("hire_date"));
            employeeView.setJob(jobs);
            employeeView.setSalary(rs.getDouble("salary"));
            employeeView.setCommissionPoints(rs.getDouble("commission_pct"));
            employeeView.setManager(managers);
            employeeView.setDepartment(departments);

            employeeViews.add(employeeView);
        }
        return employeeViews;
    }
}