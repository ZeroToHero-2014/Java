package ro.teamnet.zth.utils;

import ro.teamnet.zth.dao.DepartmentDao;
import ro.teamnet.zth.dao.EmployeeDao;
import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.dao.LocationDao;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.views.EmployeeView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 11/4/2014.
 */
public class ResultSetToPojo {


    private static DepartmentDao departmentDao = new DepartmentDao();

    private static JobDao jobDao = new JobDao();

    private static EmployeeDao employeeDao = new EmployeeDao();

    private static LocationDao locationDao = new LocationDao();

    public static ArrayList<Employee> convertToEmployee(ResultSet rs,Connection con) throws SQLException {
        ArrayList<Employee> listaAngajati = new ArrayList<>();
    while(rs.next()){
    Employee e = new Employee();
    e.setId(rs.getLong("Employee_id"));
    e.setFirstName(rs.getNString("FIRST_NAME"));
    e.setLastName(rs.getNString("LAST_NAME"));
    e.setEmail(rs.getNString("EMAIL"));
    e.setPhoneNumber(rs.getNString("PHONE_NUMBER"));
    e.setHireDate(rs.getDate("HIRE_DATE"));
    e.setJob(jobDao.getJobByid(con, rs.getString("JOB_ID")));//intrebare
    e.setSalary(rs.getDouble("SALARY"));
    e.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
    e.setManager(employeeDao.getEmployById(con, rs.getLong("MANAGER_ID")));
    e.setDepartment( departmentDao.getDepartmentById(con, rs.getLong("Department_ID")) );
        listaAngajati.add(e);

    }


        return listaAngajati;}

    public static ArrayList<Job> convertToJob(ResultSet rs) throws SQLException {
    ArrayList<Job> listaJob = new ArrayList<>();

       while(rs.next()){
       Job j = new Job();
           j.setId(rs.getNString("JOB_ID"));
           j.setJob_title(rs.getNString("JOB_TITLE"));
           j.setMin_salary(rs.getDouble("MIN_SALARY"));
           j.setMax_salary(rs.getDouble("MAX_SALARY"));

           listaJob.add(j);




       }
    return listaJob;
    }

    public static ArrayList<Department> convertToDepartment(Connection con,ResultSet rs) throws SQLException {
        ArrayList<Department> listaDep = new ArrayList<>();

        while(rs.next()){
            Department d = new Department();
            d.setId(rs.getLong("Department_ID"));
            d.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
            d.setLocation(locationDao.getLocationById(con,rs.getLong("LOCATION_ID")));
            listaDep.add(d);

        }
    return listaDep;

    }

    public static ArrayList<Location> convertToLocation(ResultSet rs) throws SQLException {
        ArrayList<Location> listaLocatii = new ArrayList<>();
        while(rs.next())
        {
            Location loc = new Location();
            loc.setId(rs.getLong("Location_id"));
            loc.setStreetAdrees(rs.getString("Street_address"));
            loc.setPostalCode(rs.getString("Postal_code"));
            loc.setCity(rs.getString("City"));
            loc.setStateProvince(rs.getString("State_Province"));
            listaLocatii.add(loc);
        }

        return listaLocatii;
    }

    public static ArrayList<EmployeeView> convertToEmployeeView(ResultSet rs, Connection con) throws SQLException {
        ArrayList<EmployeeView> ew = new ArrayList<>();
        ArrayList<Job> listaJob = jobDao.getAllJobs(con);
        ArrayList<Department> listaDep = departmentDao.getAllDepartments(con);
        ArrayList<Employee> listaMan = employeeDao.getAllEmployees(con);
        while (rs.next()) {
            EmployeeView e = new EmployeeView();
            e.setId(rs.getLong("Employee_id"));
            e.setFirstName(rs.getNString("FIRST_NAME"));
            e.setLastName(rs.getNString("LAST_NAME"));
            e.setEmail(rs.getNString("EMAIL"));
            e.setPhoneNumber(rs.getNString("PHONE_NUMBER"));
            e.setHireDate(rs.getDate("HIRE_DATE"));
            e.setSalary(rs.getDouble("SALARY"));
            e.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
            e.setJobs(listaJob );
            e.setDepartments(listaDep);
            e.setManager(listaMan);


            ew.add(e);

        }return ew;

    }
    }

