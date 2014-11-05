package ro.teamnet.zth.dao;

import ro.teamnet.zth.utils.ResultSetToPojoConverter;
import ro.teamnet.zth.view.EmployeeView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ovy on 11/5/2014.
 */
public class EmployeeViewDao {

    public EmployeeView getEmployeeViewDao(Connection con, Long id)throws SQLException{

        String sq="select employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id from Employees where employee_id= ? ";
        PreparedStatement stmt=null;
        ArrayList<EmployeeView> empview=null;
        try {
   stmt = con.prepareStatement(sq);
            stmt.setLong(1,id);
    ResultSet rs = stmt.executeQuery();
     empview = ResultSetToPojoConverter.convertEmployeeView(rs, con);
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
    return empview.size()>0 ? empview.get(0) : null;

    }
}
