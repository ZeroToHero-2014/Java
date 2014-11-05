package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Juvie on 05.11.2014.
 */
public class ResultSetToPojoConverter {

//    private static DepartmentDao departmentDao = new DepartmentDao();
//    private static JobDao jobDao = new JobDao();
//    private static EmployeeDao employeeDao = new EmployeeDao();


//    public static ArrayList<Employee> convertToEmployee (ResultSet rs, Connection con) throws SQLException {
//        return null;
//    }
    public static ArrayList<Job> convertToJob(ResultSet rs) throws SQLException  {
        ArrayList<Job> jobs = new ArrayList<Job>();
        while(rs.next()) {
            Job job = new Job();
            job.setJobId(rs.getString("job_id"));
            job.setJobTitle(rs.getString("job_title"));
            job.setMinSalary(rs.getDouble("min_salary"));
            job.setMaxSalary(rs.getDouble("max_salary"));
            jobs.add(job);
        }
        return jobs;

    }
//    public static ArrayList<Department> convertToDepartment(ResultSet rs, Connection con) throws  SQLException {
//        return null;
//    }

}
