package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.EmployeeView;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Miha on 11/5/2014.
 */
public class EmployeeViewDao {
    public ArrayList<EmployeeView> getAllEmployees(Connection con) {
        String sir = "SELECT employee_id, first_name, last_name, department_name FROM Employee_List";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sir);
            rs = ps.executeQuery();
            return ResultSetToPojoConverter.convertToEmployeeView(rs, con);
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<EmployeeView>();
    }

    public EmployeeView getEmployeeViewById(Connection con, Long id){
        String sir = "SELECT employee_id, first_name, last_name,department_name FROM Employee_List WHERE employee_id= ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(sir);
            ps.setMaxRows(5);
            ps.setLong(1,id);
            rs = ps.executeQuery();
            ArrayList<EmployeeView> employees = ResultSetToPojoConverter.convertToEmployeeView(rs, con);
            return employees.size() > 0 ? employees.get(0) : null;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
