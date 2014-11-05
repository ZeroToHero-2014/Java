package ro.teamnet.zth;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class App {

    private final static String USERNAME="ZTH_11";
    private final static String PASSWORD="passw0rd";

    public static void main(String[] args) {


        //Connection x = DatabaseManager.getConnection(USERNAME, PASSWORD);
        Connection x = DatabaseManager.getConnectionDriverRegister(USERNAME, PASSWORD);
        DatabaseManager.checkConnection(x);


        HashMap<String, String> createTableJobsTest = new HashMap<String, String>();

      {
            createTableJobsTest.put("job_id", "VARCHAR2(10) PRIMARY KEY");
            createTableJobsTest.put("job_title", "VARCHAR2(35) NOT NULL");
           // DatabaseManager.create (x, "jobstest", createTableJobsTest);
           //DatabaseManager.drop(x, "jobstest");
//
//        }
//          JobDao joburi = new JobDao();
//          System.out.println(joburi.getAllJobs(x));
//          System.out.println(joburi.getJobId(x, "AD_PRES"));
//         System.out.println(joburi.getJobId(x, "AD_PRES"));
//          System.out.println();
//
//          DepartmentDao departamente = new DepartmentDao();
//          System.out.println(departamente.getAllDepartments(x));
//          System.out.println(departamente.getDepartmentId(x, 30l));
//          System.out.println();

          EmployeeDao employees = new EmployeeDao();
          System.out.println(employees.getAllEmployees(x));
          System.out.println(employees.getEmployeeId(x, 100l));






    DatabaseManager.closeConnection(x);
//
//
//
   }
}
}
