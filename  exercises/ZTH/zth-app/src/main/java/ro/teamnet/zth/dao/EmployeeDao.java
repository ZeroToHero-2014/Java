package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by ovy on 11/4/2014.
 */
public class EmployeeDao {
    public ArrayList<Employee> getAllEmployees(Connection con) throws SQLException {
        String sq = "select employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id from Employees";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sq);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Employee> emp = new ArrayList<Employee>();

            return ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Employee>();

    }
    public Employee getEmployeeById(Connection con,String id) {
        String sq ="select employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id from Employees where employee_id= ? ";
        PreparedStatement stm=null;
        ResultSet re=null;
        ArrayList<Employee> emp = null;
        try {
            stm = con.prepareStatement(sq);
            stm.setString(1,id);
            re = stm.executeQuery();

            emp = ResultSetToPojoConverter.convertToEmployee(re, con);
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return emp.size()>0 ? emp.get(0) : null;

    }
    public void saveEmployee(Employee employee, Connection con) {
        LinkedHashMap<String, String> insertIntoTableEmployees = new LinkedHashMap<String, String>();
        String tableName = "employees";
        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
        insertIntoTableEmployees.put("first_name", employee.getFirstName());
        insertIntoTableEmployees.put("last_name", employee.getLastName());
        insertIntoTableEmployees.put("email", employee.getEmail());
        insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
        //insertIntoTableEmployees.put("hire_date", "TO_DATE('" + employee.getHireDate().toString() + "','yyyy-mm-dd')");
        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + "1999-12-10" + "','yyyy-mm-dd')");
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
                }else if (valueName.equals("phone_number")) {
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
    public void deleteEmployee(Employee employee, Connection con) {
        PreparedStatement stmt;

        String deleteStatement = "DELETE FROM employees WHERE employee_id = ? ";
        try {
            stmt = con.prepareStatement(deleteStatement);
            stmt.setLong(1, employee.getId());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Deleted Employee: "+ employee.getFirstName()+" from employees!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee, Connection con) {
        HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
        insertIntoTableEmployees.put("first_name", employee.getFirstName());
        insertIntoTableEmployees.put("last_name", employee.getLastName());
        insertIntoTableEmployees.put("email", employee.getEmail());
        insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
        //insertIntoTableEmployees.put("hire_date", "TO_DATE('" + employee.getHireDate().toString() + "','yyyy-mm-dd')");
        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + "1999-12-10" + "','yyyy-mm-dd')");
        insertIntoTableEmployees.put("job_id", employee.getJob().getId().toString());
        insertIntoTableEmployees.put("salary", employee.getSalary().toString());
        insertIntoTableEmployees.put("commission_pct", employee.getCommissionPoints().toString());
        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());
        String tableName = "employees";
        PreparedStatement stmt;
        try {

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

            stmt =con.prepareStatement(sqlStatement.toString());

            stmt.executeUpdate();
            stmt.close();

            System.out.println("Created table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
