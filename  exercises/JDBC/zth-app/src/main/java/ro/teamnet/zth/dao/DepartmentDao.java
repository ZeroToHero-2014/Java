package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Dumitru on 04.11.2014.
 */
public class DepartmentDao {

    public ArrayList<Department> getAllDepartments(Connection con) {
        PreparedStatement pstmt = null;
        String selectAllFromTableString = "SELECT department_id, department_name FROM Departments";

        try {
            pstmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();

            return ResultSetToPojoConverter.convertToDepartment(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Department>();
    }

    public Department getDepartmentById(Connection con, String dept) {

        PreparedStatement pstmt = null;
        ArrayList<Department> arrayDept = new ArrayList<Department>();
        String selectAllFromTableString = "SELECT department_id, department_name " +
                "FROM Departments WHERE department_id = ?";   //?: analogie cu printf din C :D

        try {
            pstmt = con.prepareStatement(selectAllFromTableString);
            pstmt.setString(1, dept);
            ResultSet rs = pstmt.executeQuery();
            arrayDept = ResultSetToPojoConverter.convertToDepartment(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  arrayDept.size() > 0 ? arrayDept.get(0) : null;
    }
}
