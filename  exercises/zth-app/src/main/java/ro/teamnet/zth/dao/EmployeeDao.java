package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bogdan on 11/4/2014.
 */
public class EmployeeDao
{
    public ArrayList<Employee> getAllEmployees(Connection con)
    {


        String selectAllFromTableString = "SELECT employee_id, first_name, last_name, email, " +
                "phone_number, hire_date, job_id, salary,commission_pct, manager_id, department_id FROM Employees ";
        PreparedStatement pstmt = null;
        try
        {
            pstmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();
            return ResultSetToPojoConverter.convertToEmployee(rs, con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return new ArrayList<Employee>();
    }

    public Employee getEmployeeById (Connection con, String id) {
        PreparedStatement pstmt = null;
        String selectAllFromTableString = "SELECT employee_id, first_name, last_name, email, " +
                "phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id FROM Employees  WHERE employee_id = ?";
        ArrayList<Employee> employees = null;
        try
        {
            pstmt = con.prepareStatement(selectAllFromTableString);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            employees = ResultSetToPojoConverter.convertToEmployee(rs, con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return employees.size() > 0 ? employees.get(0) : null;
    }

//    public void saveEmployee(Employee employee, Connection con)
//    {
//        HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
//        String tableName = "employees";
//
//        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
//        insertIntoTableEmployees.put("first_name", employee.getFirstName());
//        insertIntoTableEmployees.put("last_name", employee.getLastName());
//        insertIntoTableEmployees.put("email", employee.getEmail());
//        insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
//        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + employee.getHireDate().toString() + "','yyyy-mm-dd')");
//        insertIntoTableEmployees.put("job_id", employee.getJob().getId().toString());
//        insertIntoTableEmployees.put("salary", employee.getSalary().toString());
//        insertIntoTableEmployees.put("commission", employee.getCommissionPoints().toString());
//        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
//        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());
//
//        Statement stmt = null;
//
//        try
//        {
//            stmt =  con.createStatement();
//            String createTableStatement = "INSERT INTO " + tableName + " ( ";
//            StringBuilder sqlStatement = new StringBuilder();
//            sqlStatement.append(createTableStatement);
//            Integer valuesCount = insertIntoTableEmployees.keySet().size();
//
//            for(String valueName : insertIntoTableEmployees.keySet())
//            {
//                valuesCount--;
//                String columnString = valueName + (valuesCount !=0 ? " , " : ")");
//                sqlStatement.append(columnString);
//            }
//            valuesCount = insertIntoTableEmployees.keySet().size();
//            sqlStatement.append(" VALUES ( '");
//
//            for(String valueName :insertIntoTableEmployees.keySet())
//            {
//                valuesCount--;
//                String columnString;
//                if(valueName.equals("hire_date"))
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount !=0 ? " , '" : "')");
//                }
//                else if(valueName.equals("first_name"))
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount !=0 ? "' , " : "')");
//                }
//                else
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount !=0 ? "' , '" : "')");
//                }
//                sqlStatement.append(columnString);
//            }
//            stmt.executeUpdate(sqlStatement.toString());
//
//            System.out.println("Inserted into table " + tableName + "...");
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

//    }
public void saveEmployee(Employee employee, Connection con) {
    HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
    String tableName = "employees";

    insertIntoTableEmployees.put("employee_id", employee.getId().toString());
    insertIntoTableEmployees.put("first_name", employee.getFirstName());
    insertIntoTableEmployees.put("last_name", employee.getLastName());
    insertIntoTableEmployees.put("email", employee.getEmail());
    insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
    insertIntoTableEmployees.put("hire_date", "TO_DATE('" + employee.getHireDate().toString() + "','yyyy-mm-dd')");
    insertIntoTableEmployees.put("job_id", employee.getJob().getId().toString());
    insertIntoTableEmployees.put("salary", employee.getSalary().toString());
    insertIntoTableEmployees.put("commission_pct", employee.getCommissionPoints().toString());
    insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
    insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());

    Statement stmt;
    try {
        stmt = con.createStatement();
        String createTableString = "INSERT INTO " + tableName + " ( ";
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append(createTableString);
        Integer valuesCount = insertIntoTableEmployees.keySet().size();

        for (String valueName : insertIntoTableEmployees.keySet()) {
            valuesCount--;
            String columnString = valueName + (valuesCount != 0 ? " , " : ")");
            sqlStatement.append(columnString);
        }
        valuesCount = insertIntoTableEmployees.keySet().size();
        sqlStatement.append(" VALUES ( '");

        for (String valueName : insertIntoTableEmployees.keySet()) {
            valuesCount--;
            String columnString;
            if (valueName.equals("hire_date")) {
                columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? " , '" : "')");
            }else if (valueName.equals("first_name")) {
                columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , " : "')");
            }else
            {
                columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
            }
            sqlStatement.append(columnString);
        }
        stmt.executeUpdate(sqlStatement.toString());
        stmt.close();
        System.out.println("Inserted into table " + tableName + "...");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
