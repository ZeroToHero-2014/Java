package ro.teamnet.zth;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.dao.LocationsDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Locations;
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
    private static final String USERNAME = "ZTH_09";
    private static final String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {
        System.out.println( "Starting ZTH JDBC Tutoriale" );

        Connection con = DatabaseManager.getConnection(USERNAME,PASSWORD);
        DatabaseManager.checkConnection(con);

        HashMap<String, String> coloana = new HashMap<String, String>();
        coloana.put("id","NUMBER");
        coloana.put("firstName","VARCHAR2(255)");
        //DatabaseManager.create(con,"oricum2",coloana);

        JobDao jobDao =new JobDao();
        ArrayList<Job>jobs=jobDao.getAllJobs(con);
        for(Job j:jobs){
            System.out.println(j);
        }

        Job jd=jobDao.getJobByID(con,"IT_PROG");
        System.out.println(jd);

        DepartmentDao departmentDao =new DepartmentDao();
        ArrayList<Department>departments=departmentDao.getAllDepartments(con);
        for(Department d:departments){
            System.out.println(d.getDepartmentName());
        }

        Department dd=departmentDao.getDepartmentByID(con,"60");
        System.out.println(dd);


        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee>employees=employeeDao.getAllEmployees(con);
        for(Employee e:employees){
            System.out.println(e.getFirstName());
        }

        Employee ee=employeeDao.getEmployeeByID(con,100l);
        System.out.println(ee);


        LocationsDao locationsDao = new LocationsDao();
        ArrayList<Locations>locations=locationsDao.getAllLocations(con);
        for(Locations l:locations){
            System.out.println(l.getCity());
        }

        Locations ll=locationsDao.getLocationsByID(con,"1400");
        System.out.println(ll);

    }
}
