package ro.teamnet.zth;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.DatabaseManager;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String username="ZTH_17";
    private static final String password="passw0rd";
    public static void main( String[] args )
    {
        System.out.println( "Starting ZTH JDBC Tutorial!" );

        Connection con = DatabaseManager.getConnection(username, password);
        DatabaseManager.checkConnection(con);

        HashMap<String, String> columns = new HashMap<String, String>();

       // columns.put("kk", "VARCHAR2(5)");
        columns.put("Id", "number(6,0)");
        columns.put("Name", "varchar2(50)");
        columns.put("Address", "nvarchar2(50)");

      /*  JobDao jobDao = new JobDao();
        System.out.println(jobDao.getJobById(con, "AD_PRES"));*/

       /*   DepartmentDao departmentDaoDao = new DepartmentDao();
        System.out.println(departmentDaoDao.getDepartmentById(con, new Long(50)));*/

        EmployeeDao employeeDao = new EmployeeDao();
        System.out.println(employeeDao.getAllEmployees(con));

       /* Employee employee = employeeDao.getEmployeeById(con, new Long(100));

        Employee emp = employeeDao.getEmployeeById(con, new Long(100));
        employee.setId(new Long(1001));
        employee.setManager(emp);
        employee.setEmail("e@yahoo.com");
        employeeDao.saveEmployee(employee, con);*/

       /* Employee employee_ins = employeeDao.getEmployeeById(con, new Long(1001));
        employee_ins.setEmail("e12@yahoo.com");
        employeeDao.updateEmployee(employee_ins, con);*/
        Employee employee = employeeDao.getEmployeeById(con, new Long(1001));
        System.out.println(employee);
        //employeeDao.deleteEmployee(employee, con);
    }
}