package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojo;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 11/3/2014.
 */
public class DepartmentDao {


    public ArrayList<Department> getAllDepartments(Connection con)  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Department> listaDep = null;
try {
    ps = con.prepareStatement("SELECT * FROM DEPARTMENTS");
    rs = ps.executeQuery();


    listaDep = ResultSetToPojo.convertToDepartment(con,rs);
} catch (SQLException e) {
    e.printStackTrace();
} finally{
    try {
        if(ps!=null)
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return listaDep;
}

    }


    public Department getDepartmentById(Connection con, Long id) {
        PreparedStatement ps = null;
        Department d = null;
        try{ ps = con.prepareStatement("SELECT * FROM DEPARTMENTS WHERE department_id = ?");
        ps.setLong(1,id);

        ArrayList<Department> listaDep = ResultSetToPojo.convertToDepartment(con,ps.executeQuery());

        if(listaDep!=null)
            d = listaDep.size()>0?listaDep.get(0):null;

    } catch (SQLException e) {
            e.printStackTrace();
        } finally{ if(ps!=null) try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    return d;}


    public void insertDepartment(Connection con, Department dep) throws SQLException {

        PreparedStatement pst = null;
    try {
        pst = con.prepareStatement("insert into departments(department_id,department_name,location_id) values (TAB_DEPARTMENTS_SEQ.nextval,?,?)");
        pst.setString(1,dep.getDepartmentName());
        pst.setLong(2,dep.getLocation().getId());
        pst.execute();
    }
    finally {
        if(pst!=null)
        pst.close();
    }
    }

    public void updateDepartment(Connection con, Department dep) throws SQLException {

        PreparedStatement pst = null;
        try{
        pst = con.prepareStatement("Update DEPARTMENTS SET " +
                "department_name = ?," +
                "location_id = ?" +
                "where department_id  = ?;");
        pst.setString(1, dep.getDepartmentName());
        pst.setLong(2, dep.getLocation().getId());
        pst.setLong(3, dep.getId());
    }    finally {
        if(pst!=null)
        pst.close();
        }



    }

    public void deleteDepartment(Connection con,Long Id) throws SQLException {
    PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?");
            pst.setLong(1, Id);
            pst.execute();
        }  finally {
            if(pst!=null)
                pst.close();
        }
    }

}
