package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
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
}
