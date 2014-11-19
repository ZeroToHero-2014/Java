package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by hangan on 11/4/2014.
 */
public class DepartmentDao {
    public ArrayList<Department>getAllDepartments(Connection con){
        String selectAllFromTableString = "SELECT department_id,department_Name FROM departments";
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = stmt.executeQuery();
            return ResultSetToPojoConverter.covertToDepartment(rs, con);
        }catch (SQLException e){
            e.printStackTrace();
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

    public Department getDepartmentByID(Connection con, String id) {
        String selectAllFromTableString = "SELECT department_id,department_name FROM Departments WHERE department_id =?";
        PreparedStatement stmt = null;
        ArrayList<Department> departments = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            departments = ResultSetToPojoConverter.covertToDepartment(rs, con);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments.size() > 0 ? departments.get(0) : null;
    }
}
