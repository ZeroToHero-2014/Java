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
 * Created by ovy on 11/4/2014.
 */
public class DepartmentDao {

    public ArrayList<Department> getAlldepartment(Connection con) {
        String sq="SELECT d.department_id,d.department_name,d.location_id FROM Departments d, locations l WHERE d.location_id=l.location_id";
        PreparedStatement stmt=null;
        ResultSet st= null;
        ArrayList<Department>  dep  = new ArrayList<Department>();
        try {
            stmt = con.prepareStatement(sq);


            st = stmt.executeQuery(sq);

            return ResultSetToPojoConverter.convertToDepartment(st,con);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Department>();


    }
    public Department getDepartmentById(Connection con,String id) {
        String sq ="SELECT d.department_id,d.department_name,d.location_id FROM Departments d, locations l WHERE d.location_id=l.location_id and department_id = ?";
        PreparedStatement stm=null;
        ResultSet re=null;
        ArrayList<Department> jobs = null;
        try {
            stm = con.prepareStatement(sq);
           stm.setString(1,id);
            re = stm.executeQuery();

            jobs = ResultSetToPojoConverter.convertToDepartment(re, con);
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jobs.size()>0 ? jobs.get(0) : null;

    }
}
