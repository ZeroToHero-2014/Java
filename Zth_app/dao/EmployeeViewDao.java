package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.EmployeeView;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Maria on 11/9/2014.
 */
public class EmployeeViewDao {

   public ArrayList<EmployeeView> getAllEmployeesView(Connection con) {
        String  SQL = "SELECT employee_id,first_name,last_name, salary,department_name FROM Employee_list";
       PreparedStatement stm = null;
       ResultSet rs = null;
       try {
           stm = con.prepareStatement(SQL);
           rs=stm.executeQuery();
           return ResultSetToPojoConverter.convertToEmployeeView(rs, con);

       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           try {
               stm.close();
               rs.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
            return new ArrayList<EmployeeView>();
   }


    public EmployeeView getEmployeeViewById(Connection con, long id){
        String SQL = "SELECT employee_id, first_name, last_name,department_name FROM Employee_list WHERE employee_id= ? ";
        PreparedStatement stm = null;
        ArrayList<EmployeeView> employeesViews = null;

        try {
            stm = con.prepareStatement(SQL);
            stm.setLong(1,id);
            ResultSet rs = stm.executeQuery();
            employeesViews = ResultSetToPojoConverter.convertToEmployeeView(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stm!= null)
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
return employeesViews.size() > 0 ? employeesViews.get(0) : null;
    }
}
