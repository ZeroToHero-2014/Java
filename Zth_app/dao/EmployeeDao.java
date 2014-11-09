package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Maria on 11/4/2014.
 */
public class EmployeeDao {
    public ArrayList<Employee>getAllEmployees(Connection con){
        PreparedStatement stm = null;
        String selectAllFromString = "SELECT employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id FROM Employees";

        try {
            stm= con.prepareStatement(selectAllFromString);
            ResultSet rs = stm.executeQuery();
            return ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return new ArrayList<Employee>();
    }

    public Employee getEmployeeById(Connection con, Long id) throws SQLException{
        String selectAllFromTableString = "SELECT employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id " + "FROM Employees WHERE employee_id = ?";

        ArrayList<Employee> employees = new ArrayList<Employee>();
        PreparedStatement stm=null;
        try{
        stm = con.prepareStatement(selectAllFromTableString);
        stm.setLong(1, id);
        ResultSet rs = stm.executeQuery();

            employees=ResultSetToPojoConverter.convertToEmployee(rs, con);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {stm.close();
        }
        return employees.size() > 0 ? employees.get(0): null;
    }

    public void saveEmployee(Employee employee, Connection con){
        LinkedHashMap<String,String> insertIntoTableEmployees = new LinkedHashMap<String, String>();
        String tableName="employees";
        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
        insertIntoTableEmployees.put("first_name", employee.getFirstName());
        insertIntoTableEmployees.put("last_name", employee.getLastName());
        insertIntoTableEmployees.put("email", employee.getEmail());
        insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + "1999-12-10"+ "','yyyy-mm-dd)");
        insertIntoTableEmployees.put("job_id", employee.getJob().getId().toString());
        insertIntoTableEmployees.put("salary", employee.getSalary().toString());
        insertIntoTableEmployees.put("commission_pct", employee.getCommissionPoints().toString());
        insertIntoTableEmployees.put("manager_id", employee.getManager().getId().toString());
        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());
        PreparedStatement stm=null;

        try{

            String createTableString = "INSERT INTO " + tableName + "( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTableEmployees.keySet().size();
                    for (String valueName : insertIntoTableEmployees.keySet()){
                        valuesCount--;
                        String columnString = valueName + (valuesCount !=0 ? " , " : ")");
                        sqlStatement.append(columnString);
                    }
            valuesCount = insertIntoTableEmployees.keySet().size();
            sqlStatement.append("VALUES ( '");
                    for (String valueName : insertIntoTableEmployees.keySet()){
                        valuesCount--;
                        String columnString;

                if(valueName.equals("hire_date")){
                   columnString = insertIntoTableEmployees.get(valueName) + (valuesCount !=0 ? " , '" : "')");
                 } else if (valueName.equals("phone_number")){
                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount !=0 ? " , '" : "')");
                    } else {
                    columnString = insertIntoTableEmployees.get(valueName) + (valuesCount !=0 ? " , '" : "')");
                }
                    sqlStatement.append(columnString);
                    }
            System.out.println(sqlStatement);
            stm = con.prepareStatement(sqlStatement.toString());
            stm.executeUpdate();
            stm.close();
            System.out.println("INSERT INTO TABLE " + tableName + "...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee, Connection con){
        PreparedStatement stm;
        String deleteStatement = "DELETE FROM employees WHERE employee_id = ? ";
        try {
            stm = con.prepareStatement(deleteStatement);
            stm.setLong(1, employee.getId());
            stm.executeUpdate();
            stm.close();
            System.out.println("DELETED Employee: " + employee.getFirstName() + " FROM employees");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee, Connection con){
        HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
        insertIntoTableEmployees.put("employee_id", employee.getId().toString());
        insertIntoTableEmployees.put("first_name", employee.getFirstName());
        insertIntoTableEmployees.put("last_name", employee.getLastName());
        insertIntoTableEmployees.put("email", employee.getEmail());
        insertIntoTableEmployees.put("phone_number", employee.getPhoneNumber());
        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + "1999-12-10" + "','yyyy-mm-dd')");
        insertIntoTableEmployees.put("job_id", employee.getJob().getId().toString());
        insertIntoTableEmployees.put("salary", employee.getSalary().toString());
        insertIntoTableEmployees.put("commission_pct", employee.getCommissionPoints().toString());
        insertIntoTableEmployees.put("manager_id",employee.getManager().getId().toString());
        insertIntoTableEmployees.put("department_id", employee.getDepartment().getId().toString());
        String tableName = "employees";
        PreparedStatement stm;
        try{
            String createTableString = "UPDATE " + tableName + "SET ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = insertIntoTableEmployees.keySet().size();
                for (String columnName : insertIntoTableEmployees.keySet()){
                    columnsCount--;
                    String columnString;

                    if (columnName.equals("hire_date")){
                        columnString = columnName + " = " +insertIntoTableEmployees.get(columnName) + (columnsCount != 0 ? " , " : " ' ");
                    }else {
                        columnString = columnName + " = " + insertIntoTableEmployees.get(columnName) + (columnsCount != 0 ? " , " : " ' ");
                    }
                    sqlStatement.append(columnString);
                }
            sqlStatement.append("WHERE employee_id = " + employee.getId());
            stm = con.prepareStatement(sqlStatement.toString());
            stm.executeUpdate();
            stm.close();
            System.out.println("CREATE TABLE " + tableName + " IN DATABASE...");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
