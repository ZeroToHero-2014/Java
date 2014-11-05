package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ifrim on 04.11.2014.
 */
public class EmployeeDao {
    public ArrayList getAllEmployees(Connection x){
        String selectAllFromTableString = "SELECT employee_id, first_name, last_name, email, phone_number, salary, commission_pct, manager_id, department_id, hire_date, job_id FROM Employees";

        PreparedStatement pstmt = null;
        try {
            pstmt = x.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();

            return ResultSetToPojoConverter.convertToEmployee(rs, x);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try
            {
                pstmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }



        return new ArrayList<Employee>();
    }

    public Employee getEmployeeId(Connection x, Long id) {
        String selectAllFromTableString = "SELECT employee_id, first_name, last_name, email, phone_number, salary, commission_pct, manager_id, department_id, hire_date, job_id FROM Employees WHERE employee_id = ?";
        PreparedStatement pstmt = null;
        ArrayList<Employee> emps = new ArrayList<Employee>();
        try
        {
            pstmt = x.prepareStatement(selectAllFromTableString);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            emps = ResultSetToPojoConverter.convertToEmployee(rs, x);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return emps.size() > 0 ? emps.get(0) : null;
    }
}
