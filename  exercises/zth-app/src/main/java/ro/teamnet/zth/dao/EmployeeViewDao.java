package ro.teamnet.zth.dao;

import ro.teamnet.zth.utils.ResultSetToPojoConverter;
import ro.teamnet.zth.views.EmployeeView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Bogdan on 11/5/2014.
 */
public class EmployeeViewDao
{
    public EmployeeView getEmployeeView(Connection con, Long id) throws SQLException
    {
        String selectAllFromTableString = "SELECT employee_id, first_name, last_name, email, " +
                "phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id FROM Employees  WHERE employee_id = ?";
        PreparedStatement pstmt = con.prepareStatement(selectAllFromTableString);
        pstmt.setString(1,id.toString());
        ResultSet rs = pstmt.executeQuery();

        ArrayList<EmployeeView> employeeViews = ResultSetToPojoConverter.convertToEmployeeView(rs, con);

        try {
            pstmt.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return employeeViews.size() > 0 ? employeeViews.get(0) : null;
    }
}
