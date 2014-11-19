package ro.teamnet.zth.dao;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;
import ro.teamnet.zth.domain.EmployeeView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by hangan on 11/5/2014.
 */
public class EmployeeViewDao {

    public EmployeeView getEmployeeView(Connection con, Long id){
        PreparedStatement stmt;
        ArrayList<EmployeeView> employeeViews = null;
        try {
            stmt = con.prepareStatement("");
            String query = "SELECT * " + "FROM EMPLOYEE_LIST " + "WHERE employee_id=" + id;
            ResultSet rs = stmt.executeQuery(query);
            employeeViews = ResultSetToPojoConverter.convertToEmployeeView(rs,con);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeViews.size() > 0 ? employeeViews.get(0) : null;
    }
}
