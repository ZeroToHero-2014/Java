package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Miha on 11/4/2014.
 */
public class DepartmentDao {
    public ArrayList<Department> getAllDepartments(Connection con) {
        String sir = "SELECT department_id, department_name, location_id FROM Departments";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sir);
            rs = ps.executeQuery();
            return ResultSetToPojoConverter.convertToDepartment(rs, con);
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
        return new ArrayList<Department>();
    }

    public Department getDepartmentById(Connection con, String id){
        String sir = "SELECT department_id, department_name, location_id FROM Departments WHERE department_id= ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(sir);
            ps.setString(1,id);
            rs = ps.executeQuery();
            ArrayList<Department> departments = ResultSetToPojoConverter.convertToDepartment(rs, con);
            return departments.size() > 0 ? departments.get(0) : null;
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
