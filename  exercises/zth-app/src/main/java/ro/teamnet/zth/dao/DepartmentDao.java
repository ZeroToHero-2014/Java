package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Buli on 04.11.2014.
 */
public class DepartmentDao {

    public ArrayList<Department> getAllDepartments(Connection con) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectAllFromTableString = "Select * from Departments";
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            rs = stmt.executeQuery();
            return ResultSetToPojoConvert.convertToDepartment(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Department>();
    }

    public Department getDepartmentById(Connection con, int id) {
        String selectAllFromTableString = "Select * from Departments where department_id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Department> departments = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            departments = ResultSetToPojoConvert.convertToDepartment(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return departments.size() > 0 ? departments.get(0) : null;
    }

    public void saveDepartment(Department department, Connection con) {
        HashMap<String, String> insertIntoTableDepartments = new HashMap<String, String>();
        String tableName = "departments";

        insertIntoTableDepartments.put("department_id", department.getDepartmentId().toString());
        insertIntoTableDepartments.put("department_name", department.getDepartmentName());
        insertIntoTableDepartments.put("department_location", department.getLocation().getLocationId().toString());

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("");
            String createTableString = "INSERT INTO " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTableDepartments.keySet().size();

            for (String value : insertIntoTableDepartments.keySet()) {
                valuesCount--;
                String columnName = value + (valuesCount != 0 ? " , " : " ) ");
                sqlStatement.append(columnName);
            }

            sqlStatement.append(" VALUES ( '");
            valuesCount = insertIntoTableDepartments.keySet().size();

            for (String valueName : insertIntoTableDepartments.keySet()) {
                valuesCount--;
                String columnString = insertIntoTableDepartments.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
                sqlStatement.append(columnString);
            }

            stmt.executeQuery(sqlStatement.toString());
            stmt.close();
            System.out.println("Inserted into table " + tableName + "...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDepartment(Department department, Connection con){
        HashMap<String, String> insertIntoTableDepartments = new HashMap<String, String>();
        String tableName = "departments";

        insertIntoTableDepartments.put("department_id", department.getDepartmentId().toString());
        insertIntoTableDepartments.put("department_name", department.getDepartmentName());
        insertIntoTableDepartments.put("department_location", department.getLocation().getLocationId().toString());

        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("");
            String updateTableString = "UPDATE " + tableName + " SET ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(updateTableString);
            Integer columnsCount = insertIntoTableDepartments.keySet().size();

            for(String columnName : insertIntoTableDepartments.keySet()){
                columnsCount --;
                String columnString = columnName + " = '" + insertIntoTableDepartments.get(columnName) + (columnsCount != 0 ? "' , " : "' ");
                sqlStatement.append(columnString);
            }

            sqlStatement.append("WHERE department_id = " + department.getDepartmentId());
            stmt.executeQuery(sqlStatement.toString());
            stmt.close();
            System.out.println("Created table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartment(Department department, Connection con){
        PreparedStatement stmt;
        String tableName = "departments";
        try {
            stmt = con.prepareStatement("");
            String deleteStatement = "DELETE FROM " + tableName + " WHERE department_id = " + department.getDepartmentId();
            stmt.executeUpdate(deleteStatement);
            stmt.close();
            System.out.println("Dropped table " + tableName + " from database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
