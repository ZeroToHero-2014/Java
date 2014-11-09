package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Maria on 11/4/2014.
 */
public class DepartmentDao {

    public ArrayList<Department>getAllDepartments(Connection con){
        PreparedStatement stm = null;
        String selectAllFromString = "SELECT department_id, department_Name FROM Departments";

        try {
            stm= con.prepareStatement(selectAllFromString);
            ResultSet rs = stm.executeQuery();
            return ResultSetToPojoConverter.convertToDepartment(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return new ArrayList<Department>();
    }

    public Department getDepartmentById(Connection con, String id) throws SQLException{
        String selectAllFromTableString = "SELECT department_id, department_Name " + "FROM Departments WHERE department_id = ?";
        ArrayList<Department> departments = new ArrayList<Department>();
        PreparedStatement stm = con.prepareStatement(selectAllFromTableString);
        stm.setString(1, id);
        ResultSet rs = stm.executeQuery();
        try{
            departments=ResultSetToPojoConverter.convertToDepartment(rs, con);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {stm.close();
        }
        return departments.size() > 0 ?departments.get(0): null;
    }
}