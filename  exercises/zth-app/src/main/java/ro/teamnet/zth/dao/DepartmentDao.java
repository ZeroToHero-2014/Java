package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by George on 11/4/2014.
 */
public class DepartmentDao {

    /**
     * return a list with all deparments from departments table
     *
     * @param con   - connection
     * @return
     */
    public ArrayList<Department> getAllDepartments(Connection con){

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            String selectAllFromTableString = "select department_id, department_name, location_id from departments";
            preparedStatement = con.prepareStatement(selectAllFromTableString);
            rs = preparedStatement.executeQuery();

            return ResultSetToPojoConverter.convertToDepartment(rs, con);
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
        return new ArrayList<Department>();
    }

    /**
     * return a department based on id
     *
     * @param con   - connection
     * @param id    - id of department
     * @return
     */
    public Department getDepartmentById(Connection con, String id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList<Department> departments = null;

        try {
            String selectAllFromTableString = "select department_id, department_name, location_id from departments where department_id = ?" ;
            preparedStatement = con.prepareStatement(selectAllFromTableString);
            preparedStatement.setString(1, id);

            rs = preparedStatement.executeQuery();
            departments = ResultSetToPojoConverter.convertToDepartment(rs, con);
        } catch (SQLException e) {
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
        return departments.size() > 0 ? departments.get(0) : null;
    }

    /**
     * Insert a department into departments Table
     * @param con       - connection
     * @param department    - department
     */
    public void insertIntoDepartment(Connection con, Department department){
        PreparedStatement preparedStatement = null;
        String tableName = "departments";

        try{
            String command = "insert into " + tableName + "(department_id, department_name, location_id)"
                    + "values (TAB_DEPARTMENTS_SEQ.nextval, ?, ?)";

            preparedStatement = con.prepareStatement(command);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setLong(2, department.getLocationId());

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Department with name: " + department.getDepartmentName()
                + " are inserted into table departments \n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * Update a department from departments table
     *
     * @param con   - connection
     * @param department    - department
     */
    public void updateDepartment(Connection con, Department department){
        PreparedStatement preparedStatement = null;
        String tableName = "departments";

        try{
            String command = "update " + tableName +
                    " set department_name=?, location_id=? " +
                    " where department_id=?";
            preparedStatement = con.prepareStatement(command);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setLong(2, department.getLocationId());
            preparedStatement.setLong(3, department.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Update department with name: " + department.getDepartmentName() + "\n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * Delete department by id
     *
     * @param con - connection
     * @param idDepartment - id of department
     */
    public void deleteDepartment(Connection con, Long idDepartment){
        PreparedStatement preparedStatement = null;
        String tableName = "departments";

        try{
            String command = "delete from " + tableName + " where department_id=?";
            preparedStatement = con.prepareStatement(command);
            preparedStatement.setLong(1, idDepartment);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Deleted department with id: " + idDepartment + "\n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
