package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
<<<<<<< HEAD
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
=======
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class DepartmentDao {
    public ArrayList<Department> getAllDepartments(Connection con) throws SQLException {
             Statement stmt = con.createStatement();
             String selectAllFromTableString = "SELECT department_id,department_name FROM Departments";
             ResultSet rs = stmt.executeQuery(selectAllFromTableString);
             try {
                 return ResultSetToPojoConverter.convertToDepartment(rs,con);
             } catch (SQLException e) {
                 e.printStackTrace();
             }
             stmt.close();
             return new ArrayList<Department>();
         }
     
         public Department getDepartmentById(Connection con, Long id) throws SQLException {
             Statement stmt = con.createStatement();
             String selectAllFromTableString = "SELECT department_id,department_name " +
                     "FROM Departments WHERE department_id = " + id;
             ResultSet rs = stmt.executeQuery(selectAllFromTableString);
             ArrayList<Department> departments = ResultSetToPojoConverter.convertToDepartment(rs,con);
             stmt.close();
             return departments.size() > 0 ? departments.get(0) : null;
         }
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
}
