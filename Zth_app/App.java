package ro.teamnet.zth;

import com.sun.org.apache.xpath.internal.SourceTree;
import ro.teamnet.zth.dao.*;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.DatabaseManager;

import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static String USERNAME = "ZTH_18";
    private final static String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {

        Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
       // DatabaseManager.checkConnection(con);

      //create table
      //  HashMap<String, String> createTableTest = new HashMap<String, String>();

       //     createTableTest.put("coloana1", "VARCHAR2(10) PRIMARY KEY");
       //     createTableTest.put("coloana2", "NUMBER(10)");

         //DatabaseManager.create(con, "TableTest", createTableTest);
        // DatabaseManager.drop(con,"TableTest");

      // create table
      //  DatabaseManager.create(con, "Test", createTableTest);
      // drop table
      //  DatabaseManager.drop(con, "Test");

//          JOB DAO
//        JobDao test = new JobDao();
//        System.out.println(test.getAllJobs(con));
//        String STR="ST_MAN";
//        try {
//            System.out.println(test.getJobById(con,STR));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//          DEPARTMENT DAO
//        DepartmentDao test2 = new DepartmentDao();
//        System.out.println(test2.getAllDepartments(con));

//         EMPLOYEE DAO
//         EmployeeDao test3 = new EmployeeDao();
//         ArrayList<Employee> emp = test3.getAllEmployees(con);
//        System.out.println(emp);
     //    Employee tests = new Employee();

//        try {
//            Employee e = test3.getEmployeeById(con,206l);
//            System.out.println(e);
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        }

         // EMPLOYEE VIEW DAO
   //     EmployeeViewDao test4 = new EmployeeViewDao();
    //    System.out.println(test4.getAllEmployeesView(con));

        // LOCATION DAO
     //   LocationDao test5 = new LocationDao();
    //    System.out.println(test5.getAllLocations(con));

     //   Date date = new Date();
     //   tests.setId(999l);
     //   tests.setFirstName("andreea");
     //   tests.setLastName("maria");
     //   tests.setManager(test3.getEmployeeById(con, 100));
     //   tests.setEmail("email@test.com");
     //   tests.setHireDate(date);
     //   tests.setSalary(100.1);
     //   tests.setCommissionPoints(1.2);
     //   tests.setPhoneNumber("123456789");
     //   tests.setJob(test.getDepartmentById(con, 240));


     //   test3.saveEmployee(tests, con);
     //   test3.deleteEmployee(tests, con);
     //   test3.updateEmployee(tests, con);



// close connection
        DatabaseManager.closeConnection(con);


    }




}
