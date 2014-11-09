package ro.teamnet.zth;

import ro.teamnet.zth.dao.*;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.DatabaseManager;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;
import ro.teamnet.zth.view.EmployeeView;

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
    private static  final String USERNAME="ZTH_04";
    private static  final String PASSWORD="passw0rd";
    public static void main( String[] args )  throws SQLException

    {
        System.out.println("Starting jdbc Tutorial");
        Connection con = DatabaseManager.getConnection(USERNAME,PASSWORD);
        DatabaseManager.checkConnection(con);
        /*HashMap<String,String> hs= new HashMap<String, String>();
        hs.put("Id","int");
        hs.put("Nume","varchar(10)");
        hs.put("Prenume", "varchar(10)");
        DatabaseManager.create(con, "Tabel", hs);
        DatabaseManager.drop(con, "Tabel");
        JobDao jobDao = new JobDao();
       /*ArrayList<Job> job=jobDao.getAllJobs(con);
        for( Job j : job){
            System.out.println(j);
        }*/
       /* Job a= jobDao.getJobById(con,"FI_MGR");
        System.out.println(a);*/
       /* DepartmentDao jo = new DepartmentDao();
        ArrayList<Department> job1 =jo.getAlldepartment(con);
        for( Department j : job1){
            System.out.println(j);
        }*/
         /* Department d = jo.getDepartmentById(con,"20");
        System.out.println(d);
        //jobDao.getJobById(con,"4");*/

       EmployeeDao empl = new EmployeeDao();
     /*  ArrayList<Employee> emp1= empl.getAllEmployees(con);
        for(Employee j : emp1){
            System.out.println(j);

        }*/
        Employee e= empl.getEmployeeById(con,"109");
       System.out.println(e);
      /* EmployeeDao emm = new EmployeeDao();
        Employee e= emm.getEmployeeById(con,"102");
        e.setId(6l);
        EmployeeDao emm1 = new EmployeeDao();
        emm1.saveEmployee(e,con);*/

       /* LocationDao l= new LocationDao();
        ArrayList<Location> l1 =l.getAllLocations(con);
        for(Location j : l1){
            System.out.println(j);

        }*/
       /* LocationDao l= new LocationDao();
      Location l1 =l.getLocationByID(con,2400l);
        System.out.println(l1);*/
        EmployeeDao testx= new EmployeeDao();
        /*Employee testSaveEmp = new Employee();
        EmployeeDao test= new EmployeeDao();
        JobDao test1= new JobDao();
        DepartmentDao dep = new DepartmentDao();
      Date d = new Date();
        testSaveEmp.setId(999l);
       testSaveEmp.setFirstName("eu");
       testSaveEmp.setLastName("mere");
        testSaveEmp.setManager(test.getEmployeeById(con, "100"));
       testSaveEmp.setEmail("test@test.com");
       testSaveEmp.setHireDate(d);
      testSaveEmp.setSalary(1000.5);
       testSaveEmp.setComissionPoints(0.5);
        testSaveEmp.setPhoneNumber("0745");
      testSaveEmp.setJob(test1.getJobById(con, "PR_REP"));
       testSaveEmp.setDepartment(dep.getDepartmentById(con,"240"));*/
       // e.setFirstName("valeriu");
       // testx.saveEmployee(testSaveEmp, con);
            //testx.updateEmployee(e,con);
           // testx.deleteEmployee(e,con);

       /* for( ArrayList<Job> j : job){
            System.out.println(j);
        }*/
      /* EmployeeViewDao emp11= new EmployeeViewDao();
        EmployeeView emp12 = emp11.getEmployeeViewDao(con,100l);
        System.out.println(emp12);*/
       /* System.out.println(job);*/
        System.out.println( "Hello World!" );
        DatabaseManager.closeConnection(con);
    }

}
