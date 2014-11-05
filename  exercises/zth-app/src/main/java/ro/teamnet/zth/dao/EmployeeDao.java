package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 11/4/2014.
 */
public class EmployeeDao {

    public ArrayList<Employee> getAllEmployees(Connection con) {

        PreparedStatement stmt=null;
        try {
            String selectALlFromTableString="SELECT employee_id, first_Name, last_Name, manager_id, email, hire_Date, salary, commission_pct,phone_Number,job_id,department_id FROM employees";
            stmt=con.prepareStatement(selectALlFromTableString);
            ResultSet rs= null;
            rs = stmt.executeQuery();
            return ResultSetToPojoConvert.convertToEmployee(rs,con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  new ArrayList<Employee>();


    }

    public Employee getEmployeeById(Connection con, Long id) {
        PreparedStatement stmt=null;
        ArrayList<Employee> employees=null;



        try {
            String selectAllFromTableString="SELECT employee_id, first_Name, last_Name, manager_id, email, hire_Date, salary, commission_pct, phone_Number, job_id, department_id FROM employees WHERE employee_id=" + id + "";
            stmt=con.prepareStatement(selectAllFromTableString);
            ResultSet rs=stmt.executeQuery();
            employees=ResultSetToPojoConvert.convertToEmployee(rs,con);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees.size()> 0 ? employees.get(0): null;
    }
}
