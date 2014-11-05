package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ifrim on 04.11.2014.
 */
public class DepartmentDao {
    public ArrayList getAllDepartments(Connection x){
        String selectAllFromTableString = "SELECT department_id, department_name FROM Departments";
        PreparedStatement pstmt = null;
        try {
            pstmt = x.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();

            return ResultSetToPojoConverter.convertToDepartment(rs, x);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try
            {
                pstmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }



        return new ArrayList<Department>();
    }

    public Department getDepartmentId(Connection x, Long id) {
        String selectAllFromTableString = " SELECT department_id, department_name FROM Departments WHERE department_id = ?";
        PreparedStatement pstmt = null;
        ArrayList<Department> dps = new ArrayList<Department>();
        try
        {
            pstmt = x.prepareStatement(selectAllFromTableString);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            dps = ResultSetToPojoConverter.convertToDepartment(rs, x);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dps.size() > 0 ? dps.get(0) : null;
    }
}
