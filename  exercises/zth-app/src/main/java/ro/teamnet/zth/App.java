package ro.teamnet.zth;


import com.sun.org.apache.xpath.internal.SourceTree;
import ro.teamnet.zth.dao.*;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.EmployeeView;
import ro.teamnet.zth.utils.DatabaseManager;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;


public class App {
    private static final String USER = "ZTH_16";
    private static final String PASS = "passw0rd";


    public static void main(String[] args) {
        JobDao test = new JobDao();
        DepartmentDao testDept = new DepartmentDao();
        EmployeeDao testEmp = new EmployeeDao();
        EmployeeDao testx = new EmployeeDao();
        Connection con = DatabaseManager.getConnection(USER, PASS);
        LocationDao testLocation = new LocationDao();
        EmployeeViewDao testEmpView = new EmployeeViewDao();


        //System.out.println(testEmpView.getEmployeeViewByID(con,197l));
        //System.out.println(testEmpView.getAllEmployeesView(con));

       // System.out.println(testLocation.getLocationByID(con,1300l));
        //System.out.println(testLocation.getAllLocations(con));


        //DatabaseManager.checkConnection(con);


//        HashMap<String, String> mapTest = new HashMap<String, String>();
//
//        mapTest.put("TEST1", "VARCHAR2(10) PRIMARY KEY");
//        mapTest.put("TEST2", "NUMBER(6)");
//        mapTest.put("TEST3", "NUMBER(6)");

       // DatabaseManager.create(con, "TEST", mapTest);

        // DatabaseManager.drop(con,"TEST");
     //   System.out.println(test.getAllJobs(con));
        //    System.out.println(test.getJobByID(con,"PR_REP"));
       //      System.out.println(testDept.getAllDepartments(con));
      // System.out.println(testDept.getDepartmentByID(con,240));

        //System.out.println(testEmp.getAllEmployees(con));
//        System.out.println(testEmp.getEmployeeByID(con,171));

//        Employee testSaveEmp = new Employee();
//
//        Date d = new Date();
//        testSaveEmp.setId(999l);
//        testSaveEmp.setFirstName("iulian");
//        testSaveEmp.setLastName("rupe");
//        testSaveEmp.setManager(testEmp.getEmployeeByID(con, 100));
//        testSaveEmp.setEmail("test@test.com");
//        testSaveEmp.setHireDate(d);
//        testSaveEmp.setSalary(1000.5);
//        testSaveEmp.setCommissionPoints(0.5);
//        testSaveEmp.setPhoneNumber("1234");
//        testSaveEmp.setJob(test.getJobByID(con,"PR_REP"));
//        testSaveEmp.setDepartment(testDept.getDepartmentByID(con,240));

     //   testx.saveEmployee(testSaveEmp,con);
     //   testx.deleteEmployee(testSaveEmp,con);
     //   testx.updateEmployee(testSaveEmp,con);
     //   System.out.println(testEmp.getEmployeeByID(con,999));
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
