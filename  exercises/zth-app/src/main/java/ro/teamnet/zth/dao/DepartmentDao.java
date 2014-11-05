package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by user on 11/4/2014.
 */
public class DepartmentDao {
    public ArrayList<Department> getAllDepartments(Connection con) {

        String SQL = "SELECT department_id,department_name FROM Departments"; //location_id

        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(SQL);
            rs = stm.executeQuery();
            return ResultSetToPojoConverter.convertToDepartment(rs, con);

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

        return new ArrayList<Department>();

    }

    public Department getDepartmentByID(Connection con, long id) {

        String SQL = "SELECT department_id,department_name FROM Departments WHERE department_id = ?";


        PreparedStatement stm = null;
        ArrayList<Department> departments = null;
        try {
            stm = con.prepareStatement(SQL);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            departments = ResultSetToPojoConverter.convertToDepartment(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return departments.size() > 0 ? departments.get(0) : null;
    }
}