package ro.teamnet.zth;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.DatabaseManager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String USERNAME="ZTH_03";
    private static final String PASSWORD="passw0rd";

    public static void main( String[] args )
    {
        System.out.println( "Starting ZTH JDBC Tutorial!" );
        Connection con= DatabaseManager.getConnection(USERNAME,PASSWORD);
        DatabaseManager.checkConnection(con);

        HashMap<String, String> hm= new HashMap<String, String>();
        hm.put("nume","VARCHAR(20)");
        hm.put("prenume","VARCHAR(25)");

        //DatabaseManager.create(con,"tabel1",hm);



        JobDao jd= new JobDao();
        ArrayList<Job> jobs= jd.getAllJobs(con);



        for(Job j: jobs){
            System.out.println(j);
        }


        Job jobsi= jd.getJobById(con,"AD_VP");
        System.out.println(jobsi);

        DepartmentDao dp= new DepartmentDao();
        ArrayList<Department> departments=dp.getAllDepartmens(con);
        for (Department d: departments){
            System.out.println(d);
        }

        Department dpi=dp.getDepartmentById(con,"140");
        System.out.println(dpi);

        EmployeeDao em= new EmployeeDao();
        ArrayList<Employee> employees=em.getAllEmployees(con);
        for (Employee e: employees){
            System.out.println(e);
        }
        //Employee emi=em.getEmployeeById(con,new Long(100l));
        //System.out.println(emi);
    }
}
