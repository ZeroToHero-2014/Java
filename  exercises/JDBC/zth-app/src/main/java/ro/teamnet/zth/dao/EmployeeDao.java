package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class EmployeeDao {

    public ArrayList<Employee> getAllEmployees(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String selectAllFromTableString = "SELECT employee_id,first_name,last_name,email," +
                "phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id FROM Employees";
        ResultSet rs = stmt.executeQuery(selectAllFromTableString);
        try {
            return ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stmt.close();
        return new ArrayList<Employee>();
    }

    public Employee getEmployeeById(Connection con, Long id) throws SQLException {
        Statement stmt = con.createStatement();
        PreparedStatement preparedStatement = con.prepareStatement("");
        preparedStatement.setMaxRows(5);

        String selectAllFromTableString = "SELECT employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id " +
                "FROM Employees WHERE employee_id = " + id;
        ResultSet rs = stmt.executeQuery(selectAllFromTableString);
        ArrayList<Employee> employees = ResultSetToPojoConverter.convertToEmployee(rs, con);
        stmt.close();
        return employees.size() > 0 ? employees.get(0) : null;
    }

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

    public void deleteEmployee(Employee employee, Connection con) {
        Statement stmt;
        String tableName = "employees";
        try {
            stmt = con.createStatement();
            String deleteStatement = "DELETE FROM " + tableName + " WHERE employee_id = " + employee.getId();
            stmt.executeUpdate(deleteStatement);
            stmt.close();
            System.out.println("Dropped table " + tableName + " from database...");
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
