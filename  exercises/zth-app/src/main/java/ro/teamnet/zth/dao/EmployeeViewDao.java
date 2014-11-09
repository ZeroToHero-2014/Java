package ro.teamnet.zth.dao;

import ro.teamnet.zth.utils.ResultSetToPojo;
import ro.teamnet.zth.views.EmployeeView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 11/4/2014.
 */
public class EmployeeViewDao {


    public EmployeeView getEmployeeView(Connection con,Long id) throws SQLException {
        PreparedStatement ps = null;
        try{
        ps = con.prepareStatement("SELECT * FROM EMPLOYEES WHERE employee_id = ?");
        ps.setLong(1,id);

        ResultSet rs = ps.executeQuery();
            ArrayList<EmployeeView> employeeViews = ResultSetToPojo.convertToEmployeeView(rs,con);

        return employeeViews.size()>0?employeeViews.get(0):null;
        } finally {
            if(ps!=null)
                ps.close();
        }

    }



}
