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
 * Created by Bogdan on 11/4/2014.
 */
public class DepartmentDao
{
    public ArrayList<Department> getAllDepartments(Connection con)
    {


        String selectAllFromTableString = "SELECT department_id, department_name FROM Departments ";
        PreparedStatement pstmt = null;
        try
        {
            pstmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();
            return ResultSetToPojoConverter.convertToDepartment(rs, con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return new ArrayList<Department>();
    }

    public Department getDepartmentById (Connection con, String id) {
        PreparedStatement pstmt = null;
        String selectAllFromTableString = "SELECT department_id, department_name FROM Departments  WHERE department_id = ?";
        ArrayList<Department> departments = null;
        try
        {
            pstmt = con.prepareStatement(selectAllFromTableString);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            departments = ResultSetToPojoConverter.convertToDepartment(rs, con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


        return departments.size() > 0 ? departments.get(0) : null;
    }
}
