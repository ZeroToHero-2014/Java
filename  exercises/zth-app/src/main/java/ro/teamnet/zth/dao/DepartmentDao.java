package ro.teamnet.zth.dao;

//dao - data access object

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDao {

    public ArrayList<Department> getAllDepartments(Connection con) {

        String selectAllFromTableString = "Select department_id, department_name FROM Departments";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(selectAllFromTableString);

            ResultSet rs = stmt.executeQuery();

            return ResultSetToPojoConverter.convertToDepartment(rs);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Department>();
    }

    public Department getDepartmentById(Connection con, Long id) {

        String selectAllFromTableString = "Select department_id, department_name FROM Departments WHERE department_id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Department> departments = ResultSetToPojoConverter.convertToDepartment(rs);

            return departments.size() > 0 ? departments.get(0) : null;
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
        return null;
    }
}
