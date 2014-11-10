package ro.teamnet.zth;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.DatabaseManager;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String USERNAME = "ZTH_19";
    private static final String PASSWORD = "passw0rd";

    public static void main( String[] args ){
        System.out.println("Starting JDBC Tutorial!\n" );

        Connection con = DatabaseManager.getConnection(USERNAME, PASSWORD);
        DatabaseManager.checkConnection(con);

        /* =========== create new table ===========*/
        HashMap<String, String> myMap = new HashMap<String, String>();
        myMap.put("aaa", "varchar2(255)");
        myMap.put("ccc", "number(10)");
       // DatabaseManager.create(con, "myTable_Prepared", myMap);

        /* =========== job query ===========*/
        JobDao jobDao = new JobDao();
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs = jobDao.getAllJobs(con);

        // System.out.println(jobs);
        // System.out.println(jobDao.getJobById(con, "IT_PROG"));
        Job myJob = new Job();
        myJob.setId("myJobId");
        myJob.setTitle("myJobTitle");
        myJob.setMaxSalary(Double.parseDouble("1234"));
        myJob.setMaxSalary(Double.parseDouble("2345"));

        // TODO nu merge insert, update
        //jobDao.insertIntoJobs(con, myJob);
        Job modifyJob = jobDao.getJobById(con, "IT_PROG");
        modifyJob.setTitle("IT_PROGRAMARE");
        //jobDao.updateJob(con, myJob);

        //jobDao.deleteJob(con, "AC_MGR");

        /* =========== department query ===========*/
        DepartmentDao departmentDao = new DepartmentDao();
        ArrayList<Department> departments = new ArrayList<Department>();
        departments = departmentDao.getAllDepartments(con);
        //System.out.println(departments);

        //System.out.println(departmentDao.getDepartmentById(con, "10"));

        // insert into department
        Department d = new Department();
        d.setDepartmentName("MyDepartment");
        d.setLocationId(new Long(2222));
       // departmentDao.insertIntoDepartment(con, d);

        // update department
        Department d2 = new Department();
        d2 = departmentDao.getDepartmentById(con, "10");
        d2.setDepartmentName("MyDepartment2");
        d2.setLocationId(new Long(3333));
        //departmentDao.updateDepartment(con, d2);
        // delete department
        //departmentDao.deleteDepartment(con, new Long(22));

        /* =========== employee query ===========*/
        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees = employeeDao.getAllEmployees(con);

      // System.out.println(employees);
      // System.out.println(employeeDao.getEmployeeById(con, new Long(100)));
        Employee newEmp = employeeDao.getEmployeeById(con, new Long(100));
        newEmp.setFirstName("Redeleanu");
        //employeeDao.insertIntoEmployees(con, newEmp);

        newEmp.setLasName("George");
        //employeeDao.updateEmployee(con, newEmp);
        //employeeDao.deleteEmployee(con, new Long(21));


    }
}