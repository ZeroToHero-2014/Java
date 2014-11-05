package ro.teamnet.zth;


import com.sun.org.apache.xpath.internal.SourceTree;
import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.utils.DatabaseManager;


import java.sql.Connection;
import java.util.HashMap;


public class App {
    private static final String USER = "ZTH_16";
    private static final String PASS = "passw0rd";


    public static void main(String[] args) {
        JobDao test = new JobDao();
        DepartmentDao testDept = new DepartmentDao();
        EmployeeDao testEmp = new EmployeeDao();
        Connection con = DatabaseManager.getConnection(USER, PASS);


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
      // System.out.println(testDept.getAllDepartments(con));
      //  System.out.println(testDept.getDepartmentByID(con,240));

        //System.out.println(testEmp.getAllEmployees(con));
        System.out.println(testEmp.getEmployeeByID(con,171));
        DatabaseManager.closeConnection(con);
    }
}
