package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

    /**
     * Varianta Originala
     * @param employee
     * @param con
     */
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
//        insertIntoTableEmployees.put("commission_pct", employee.getCommissionPoints().toString());
//        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
//        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());
//
//        Statement stmt;
//        try
//        {
//            stmt = con.createStatement();
//            String createTableString = "INSERT INTO " + tableName + " ( ";
//            StringBuilder sqlStatement = new StringBuilder();
//            sqlStatement.append(createTableString);
//            Integer valuesCount = insertIntoTableEmployees.keySet().size();
//
//            for (String valueName : insertIntoTableEmployees.keySet())
//            {
//                valuesCount--;
//                String columnString = valueName + (valuesCount != 0 ? " , " : ")");
//                sqlStatement.append(columnString);
//            }
//            valuesCount = insertIntoTableEmployees.keySet().size();
//            sqlStatement.append(" VALUES ( '");
//
//            for (String valueName : insertIntoTableEmployees.keySet())
//            {
//                valuesCount--;
//                String columnString;
//                if (valueName.equals("hire_date"))
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? " , '" : "')");
//                }
//                else if (valueName.equals("first_name"))
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , " : "')");
//                }
//                else
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
//                }
//                sqlStatement.append(columnString);
//            }
//            System.out.println(sqlStatement.toString());
//            stmt.executeUpdate(sqlStatement.toString());
//            stmt.close();
//            System.out.println("Inserted into table " + tableName + "...");
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }

    /**
     * Varianta #2 cu LinkedHashMap, deoarece se pastreaza ordinea inserarii nu mai este nevoie de primul for
     * care specifica o alta ordine decat cea implicita
     * @param employee
     * @param con
     */
//    public void saveEmployee(Employee employee, Connection con)
//    {
//        LinkedHashMap<String, String> insertIntoTableEmployees = new LinkedHashMap<String, String>();
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
//        insertIntoTableEmployees.put("commission_pct", employee.getCommissionPoints().toString());
//        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
//        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());
//
//        Statement stmt;
//        try
//        {
//            stmt = con.createStatement();
//            String createTableString = "INSERT INTO " + tableName + " VALUES ( '";
//            StringBuilder sqlStatement = new StringBuilder();
//            sqlStatement.append(createTableString);
//            Integer valuesCount = insertIntoTableEmployees.keySet().size();
//
//            for (String valueName : insertIntoTableEmployees.keySet())
//            {
//                valuesCount--;
//                String columnString;
//                if (valueName.equals("hire_date"))
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? " , '" : "')");
//                }
//                else if (valueName.equals("phone_number"))
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , " : "')");
//                }
//                else
//                {
//                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
//                }
//                sqlStatement.append(columnString);
//            }
//            System.out.println(sqlStatement.toString());
//            stmt.executeUpdate(sqlStatement.toString());
//            stmt.close();
//            System.out.println("Inserted into table " + tableName + "...");
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }

    /**
     * Varianta #3 cu PreparedStatement
     * @param employee
     * @param con
     */
    public void saveEmployee(Employee employee, Connection con)
    {
        PreparedStatement pstmt = null;
        try
        {
            String createTableString = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(createTableString);

            pstmt.setLong(1, employee.getId());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getLastName());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getPhoneNumber());
            //pstmt.setString(6, "TO_DATE('" + employee.getHireDate().toString() + "','yyyy-mm-dd')");
            pstmt.setDate(6, (Date) employee.getHireDate());
            pstmt.setString(7, employee.getJob().getId());
            pstmt.setDouble(8, employee.getSalary());
            pstmt.setDouble(9, employee.getCommissionPoints());
            pstmt.setLong(10, employee.getManager().getId());
            pstmt.setString(11, employee.getDepartment().getId());

            pstmt.executeUpdate();

            System.out.println("Inserted into table employees...");
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
    }

    public void deleteEmployee(Employee employee, Connection con)
    {
        PreparedStatement pstmt = null;
        String tableName = "employees";
        try
        {
            String deleteStatement = "DELETE FROM " + tableName + " WHERE employee_id = " + employee.getId();
            pstmt = con.prepareStatement(deleteStatement);
            pstmt.executeUpdate();
            System.out.println("Dropped table " + tableName + " from database...");
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
    }

    public void updateEmployee(Employee employee, Connection con)
    {
        HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
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


        String tableName = "employees";


        Statement stmt;
        try {
            stmt = con.createStatement();
            String createTableString = "UPDATE " + tableName + " SET ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = insertIntoTableEmployees.keySet().size();

            for (String columnName : insertIntoTableEmployees.keySet()) {
                columnsCount--;
                String columnString;
                if (columnName.equals("hire_date")) {
                    columnString = columnName + " = " + insertIntoTableEmployees.get(columnName) + (columnsCount != 0 ? " , " : "' ");
                } else {
                    columnString = columnName + " = '" + insertIntoTableEmployees.get(columnName) + (columnsCount != 0 ? "' , " : "' ");
                }

                sqlStatement.append(columnString);
            }

            sqlStatement.append("WHERE employee_id = " + employee.getId());
            stmt.executeUpdate(sqlStatement.toString());
            stmt.close();
            System.out.println("Created table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
