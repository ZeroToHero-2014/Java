package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.EmployeeView;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;


public class EmployeeViewDao {


    public ArrayList<EmployeeView> getAllEmployeesView(Connection con) {

        String SQL = "SELECT employee_id,first_name,last_name,salary,department_name FROM Employees_list";

        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(SQL);
            rs = stm.executeQuery();
            return ResultSetToPojoConverter.convertToEmployeeView(rs, con);

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

        return new ArrayList<EmployeeView>();


    }

    public EmployeeView getEmployeeViewByID(Connection con, long id) {

        String SQL = "SELECT employee_id,first_name,last_name,salary,department_name FROM Employees_list where employee_id = ? ";

        PreparedStatement stm = null;
        ArrayList<EmployeeView> employeesView = null;

        try {
            stm = con.prepareStatement(SQL);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            employeesView = ResultSetToPojoConverter.convertToEmployeeView(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeesView.size() > 0 ? employeesView.get(0) : null;
    }

}
