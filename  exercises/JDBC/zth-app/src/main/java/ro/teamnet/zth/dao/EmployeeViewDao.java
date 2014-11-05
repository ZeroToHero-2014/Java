package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;
import ro.teamnet.zth.views.EmployeeView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class EmployeeViewDao {

    public EmployeeView getEmployeeView(Connection con, Long id) throws SQLException {

        Statement stmt = con.createStatement();
        String selectAllFromTableString = "SELECT employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id " +
                "FROM Employees WHERE employee_id = " + id;
        ResultSet rs = stmt.executeQuery(selectAllFromTableString);
        ArrayList<EmployeeView> employeeViews = ResultSetToPojoConverter.convertToEmployeeView(rs, con);
        stmt.close();
        return employeeViews.size() > 0 ? employeeViews.get(0) : null;


    }


}
