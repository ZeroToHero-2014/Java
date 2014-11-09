package ro.teamnet.zth.dao;

import com.sun.corba.se.impl.orb.PrefixParserData;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 11/3/2014.
 */
public class EmployeeDao {

    public ArrayList<Employee> getAllEmployees(Connection con) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList listaAng = null;
        try {
            ps = con.prepareStatement("SELECT * FROM EMPLOYEES");

            rs = ps.executeQuery();

            listaAng = ResultSetToPojo.convertToEmployee(rs, con);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaAng;
    }

    public Employee getEmployById(Connection con, Long id) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ? ");
            ps.setLong(1, id);
            Employee e;
            ArrayList<Employee> listaAng = ResultSetToPojo.convertToEmployee(ps.executeQuery(), con);
            return listaAng.size() > 0 ? listaAng.get(0) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


    public void insertEmploy(Connection con, Employee emp,boolean genereareCheie){

        //last_name, email si job_id nu pot sa fie null - constrangere BD
        /* //introdus aici sau eliminat constrangere BD
        if(emp == null)
            throw new Exception("Angajatul e null!");
        if(emp.getLastName() == null || emp.getEmail() == null || emp.getJob() == null)
            throw new Exception("Camp obligatoriu lipsa");
        */
        PreparedStatement pst = null;
        String st;
           if(genereareCheie)
         st =  "INSERT INTO EMPLOYEES(employee_id,first_name,last_name,email,phone_number,hire_date,job_id," +
                        "salary,COMMISSION_PCT,manager_id,department_id) VALUES (TAB_DEPARTMENTS_SEQ.nextval," +
                        "?,?,?,?,?,?,?,?,?,?)";
        else
               st =  "INSERT INTO EMPLOYEES(employee_id,first_name,last_name,email,phone_number,hire_date,job_id," +
                       "salary,COMMISSION_PCT,manager_id,department_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        int i = 1;
        try {

            pst = con.prepareStatement(st);
            if(!genereareCheie)
                pst.setLong(i++,emp.getId());
            pst.setString(i++, emp.getFirstName());
            pst.setString(i++, emp.getLastName());
            pst.setString(i++, emp.getEmail());
            pst.setString(i++, emp.getPhoneNumber());
            pst.setDate(i++, new Date(emp.getHireDate().getTime()));//emp.getHireDate());
            pst.setString(i++, emp.getJob().getId());
            pst.setDouble(i++, emp.getSalary());
            pst.setDouble(i++, emp.getCommission_pct());
            if (emp.getManager() != null)
                pst.setLong(i++, emp.getManager().getId());
            else
                pst.setNull(i++, Types.NULL);
            if (emp.getDepartment() != null)
                pst.setLong(i++, emp.getDepartment().getId());
            else
                pst.setNull(i++, Types.NULL);

            pst.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pst != null) try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }




    public void updateEmploy(Connection con, Employee emp) {
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement(
                    "UPDATE employees SET " +
                            "  first_name = ?, " +
                            "  last_name = ?," +
                            "  email = ?," +
                            "  phone_number = ?," +
                            "  hire_date = ?," +
                            "  job_id = ?," +
                            "  salary = ?," +
                            "  commission_pct = ?," +
                            "  manager_id = ?," +
                            "  department_id = ?" +
                            "  where employee_id = ?"
            );

            pst.setString(1, emp.getFirstName());
            pst.setString(2, emp.getLastName());
            pst.setString(3, emp.getEmail());
            pst.setString(4, emp.getPhoneNumber());
            pst.setDate(5, new Date(emp.getHireDate().getTime()));
            pst.setString(6, emp.getJob().getId());
            pst.setDouble(7, emp.getSalary());
            pst.setDouble(8, emp.getCommission_pct());
            if (emp.getManager() != null)
                pst.setLong(9, emp.getManager().getId());
            else
                pst.setNull(9, Types.NULL);
            if (emp.getDepartment() != null)
                pst.setLong(10, emp.getDepartment().getId());
            else
                pst.setNull(10, Types.NULL);
            pst.setLong(11, emp.getId());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pst != null)
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public void deleteEmploy(Connection con,Long Id){
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
            pst.setLong(1,Id);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pst!=null)
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }


    public ArrayList<Employee> getAllManagers(Connection con){
    /* FOlosim Viev-ul din baza de date creat pe baza:
    * CREATE VIEW Managers as SELECT * from employees where employee_id in (
    *                         SELECT distinct manager_id from employees);
    * //se putea apela direct acest select in codul Java
    * */

    PreparedStatement pst = null;
    ArrayList<Employee> listaMan = null;
        try {
            pst =con.prepareStatement("SELECT * FROM Managers");
            listaMan = ResultSetToPojo.convertToEmployee(pst.executeQuery(),con);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(pst!=null)
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    return listaMan;
    }

}
/*
    public void saveEmploy(Employee employee,Connection con) throws SQLException {
//a folosit un hashmap cu valorile
        HashMap<String,String> insertIntoTableEmployees = new HashMap<>();
        Statement stm = null;
        String tableName = "Employees";

        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
        insertIntoTableEmployees.put("first_name",employee.getFirstName());
        insertIntoTableEmployees.put("last_name",employee.getLastName());
        insertIntoTableEmployees.put("email",employee.getEmail());
        insertIntoTableEmployees.put("phone_number",employee.getPhoneNumber());
        insertIntoTableEmployees.put("hire_date","TO_DATE('" + employee.getHireDate().toString() + "','yyyy-mm-dd')");
        insertIntoTableEmployees.put("job_id", employee.getJob().getId().toString());
        insertIntoTableEmployees.put("salary",employee.getSalary().toString());
        insertIntoTableEmployees.put("commission_pct", employee.getCommission_pct().toString());
        insertIntoTableEmployees.put("manager_id",employee.getManager().getId().toString());
        insertIntoTableEmployees.put("department_id",employee.getDepartment().getId().toString());




        try{

            stm = con.createStatement();
            String createTableString = "INSERT INTO " + tableName + " (";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            int valueCount =  insertIntoTableEmployees.keySet().size();

            for(String valueName : insertIntoTableEmployees.keySet()){
                valueCount--;
                String columnString = valueName + (valueCount != 0?", ":")");
                sqlStatement.append(columnString);
            }
            valueCount = insertIntoTableEmployees.keySet().size();

            sqlStatement.append("VALUES (' ");

            for(String valueName:insertIntoTableEmployees.keySet()) {
                valueCount--;
                String columnString;
                if (valueName.equals("hire_date")) {
                    columnString = insertIntoTableEmployees.get(valueName) + (valueCount != 0 ? ", '" : "')");
                } else if (valueName.equals("first_name")) {
                    columnString = insertIntoTableEmployees.get(valueName) + (valueCount != 0 ? "', " : "')");
                } else {
                    columnString = insertIntoTableEmployees.get(valueName) + (valueCount != 0 ? "','" : "')");
                }

                sqlStatement.append(columnString);
            }
            System.out.println(sqlStatement);
            System.out.println(sqlStatement.toString());
            stm.executeUpdate(sqlStatement.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try { if(stm!=null) stm.close();} catch (SQLException e) { e.printStackTrace();
            }
        }

    }






*/
