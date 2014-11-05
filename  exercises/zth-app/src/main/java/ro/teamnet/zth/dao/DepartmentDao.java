package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 11/4/2014.
 */
public class DepartmentDao {

    public ArrayList<Department> getAllDepartmens(Connection con) {

        PreparedStatement stmt = null;
        try {
            String selectALlFromTableString = "SELECT department_id,department_name FROM departments";
            stmt = con.prepareStatement(selectALlFromTableString);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            return ResultSetToPojoConvert.convertToDepartment(rs, con);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Department>();
    }


    public Department getDepartmentById(Connection con, String id){
    PreparedStatement stmt=null;
    ArrayList<Department> departments=null;



    try {
        String selectAllFromTableString="SELECT department_id,department_name  FROM Departments WHERE department_id=" + id + "";
        stmt=con.prepareStatement(selectAllFromTableString);
        ResultSet rs=stmt.executeQuery();
        departments=ResultSetToPojoConvert.convertToDepartment(rs,con);



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

    return departments.size() > 0 ? departments.get(0): null;
}
}
