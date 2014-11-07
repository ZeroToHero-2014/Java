package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojoConvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Buli on 04.11.2014.
 */
public class EmployeeDao {

    public ArrayList<Employee> getAllEmployees(Connection con) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectAllFromTableString = "Select * from employees";
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setMaxRows(5);
            rs = stmt.executeQuery();
            return ResultSetToPojoConvert.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Employee>();
    }

    public Employee getEmployeeById(Connection con, int id) {
        String selectAllFromTableString = "Select * from employees where employee_id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Employee> employees = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            employees = ResultSetToPojoConvert.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees.size() > 0 ? employees.get(0) : null;
    }
/* insert delete update*/

    public void saveEmployee(Employee employee, Connection con){
        HashMap<String, String> insertIntoTableEmployees = new HashMap<String, String>();
        String tableName = "employees";

        insertIntoTableEmployees.put("employee_id", employee.getEmployeeId().toString());
        insertIntoTableEmployees.put("first_name", employee.getFirstName());
        insertIntoTableEmployees.put("last_name", employee.getLastName());
        insertIntoTableEmployees.put("email", employee.getEmail());
        insertIntoTableEmployees.put("phone_number", employee.getPhoneNmber());
        insertIntoTableEmployees.put("hire_date", "TO_DATE('" + employee.getHireDate() + "','yyyy-mm-dd");
        insertIntoTableEmployees.put("job_id",employee.getJob().getJobId().toString());
        insertIntoTableEmployees.put("salary", employee.getSalary().toString());
        insertIntoTableEmployees.put("commision_pct", employee.getCommisionPoints().toString());
        insertIntoTableEmployees.put("manager_id", employee.getManager().getEmployeeId().toString());
        insertIntoTableEmployees.put("department_id", employee.getDepartment().getDepartmentId().toString());

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("");
            String createTableString = "INSERT INTO " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTableEmployees.keySet().size();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
