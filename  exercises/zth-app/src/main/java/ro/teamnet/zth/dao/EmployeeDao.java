package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by user on 11/4/2014.
 */
public class EmployeeDao {
    public ArrayList<Employee> getAllEmployees(Connection con) {

        String SQL = "SELECT employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id FROM Employees";

        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(SQL);
            rs = stm.executeQuery();
            return ResultSetToPojoConverter.convertToEmployee(rs, con);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Employee>();


    }

    public Employee getEmployeeByID(Connection con, long id) {

        String SQL = "SELECT employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id FROM Employees WHERE employee_id=?";


        PreparedStatement stm = null;
        ArrayList<Employee> employees = null;
        try {
            stm = con.prepareStatement(SQL);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            employees = ResultSetToPojoConverter.convertToEmployee(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees.size() > 0 ? employees.get(0) : null;
    }
}
