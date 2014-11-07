package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Buli on 04.11.2014.
 */
public class DepartmentDao {

    public ArrayList<Department> getAllDepartments(Connection con) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectAllFromTableString = "Select * from Departments";
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            rs = stmt.executeQuery();
            return ResultSetToPojoConvert.convertToDepartment(rs, con);
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
        return new ArrayList<Department>();
    }

    public Department getDepartmentById(Connection con, int id) {
        String selectAllFromTableString = "Select * from Departments where department_id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Department> departments = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            departments = ResultSetToPojoConvert.convertToDepartment(rs, con);
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
        return departments.size() > 0 ? departments.get(0) : null;
    }

}
