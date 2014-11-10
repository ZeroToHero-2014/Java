package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;
import ro.teamnet.zth.views.EmployeeView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by George on 11/11/2014.
 */
public class EmployeeViewDao {

    public ArrayList<EmployeeView> getAllLocations(Connection con){

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            String selectAllFromTableString = "select * from EMPLOYEE_LIST";
            preparedStatement = con.prepareStatement(selectAllFromTableString);
            rs = preparedStatement.executeQuery();

            return ResultSetToPojoConverter.convertToEmployeeView(rs, con);
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<EmployeeView>();
    }
}
