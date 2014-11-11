package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DepartmentDao {

    public ArrayList<Department> getAllDepartment(Connection con) {

        String selectAllFromTableString = "SELECT department_id, department_name, location_id FROM Departments";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            return ResultSetToPojoConverter.convertToDepartment(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Department>();
    }

    public Department getDepartmentById(Connection con, Long id) {

        PreparedStatement stmt = null;
        ArrayList<Department> departments = new ArrayList<Department>();

        try {
            String SelectAllFromTableString = "SELECT department_id, department_name, location_id " +
                    " FROM Departments Where department_id = ?";
            stmt = con.prepareStatement(SelectAllFromTableString);
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            departments = ResultSetToPojoConverter.convertToDepartment(rs, con);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return departments.size() > 0 ? departments.get(0) : null;
    }

    public void saveDepartment(Department department, Connection con) {
        HashMap<String, String> insertIntoTableDepartments = new HashMap<String, String>();
        String tableName = "departments";
        insertIntoTableDepartments.put("department_id", department.getId().toString());
        insertIntoTableDepartments.put("department_name", department.getDepartmentName());
        insertIntoTableDepartments.put("location_id", department.getLocation().toString());

        PreparedStatement stmt = null;
        String insertTable = "INSERT INTO " + tableName + " (";
        try {
            stmt = con.prepareStatement(insertTable);
            Integer valuesCount = insertIntoTableDepartments.keySet().size();
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(insertTable);
            for (String valueName : insertIntoTableDepartments.keySet()) {
                valuesCount--;
                String valueColomn = valueName + (valuesCount != 0 ? " , " : ")");
                sqlStatement.append(valueColomn);
            }
            sqlStatement.append(" VALUES ('");
            valuesCount = insertIntoTableDepartments.keySet().size();
            for (String valueName : insertIntoTableDepartments.keySet()) {
                valuesCount--;
                String valueColomn = insertIntoTableDepartments.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
                sqlStatement.append(valueColomn);
            }
            stmt.executeUpdate(sqlStatement.toString());
            System.out.println("Insert into table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void deleteDepartment(Department department, Connection con) {

        String tableName = "departments";
        PreparedStatement stmt = null;
        String deleteQuery = "DELETE FROM " + tableName + " WHERE department_id = " + department.getId();
        try {
            stmt = con.prepareStatement(deleteQuery);
            stmt.executeUpdate(deleteQuery);
            System.out.println("Dropped from table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateDepartment(Department department, Connection con) {
        LinkedHashMap<String, String> insertIntoTableDepartment = new LinkedHashMap<String, String>();
        String tableName = "departments";

        insertIntoTableDepartment.put("department_id", department.getId().toString());
        insertIntoTableDepartment.put("department_name", department.getDepartmentName());
        insertIntoTableDepartment.put("location_id", department.getLocation().toString());

        PreparedStatement stmt = null;
        String updateDepartment = "UPDATE " + tableName + " SET ";

        try {
            stmt = con.prepareStatement(updateDepartment);
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(updateDepartment);
            Integer valuesCount = insertIntoTableDepartment.keySet().size();
            for (String valueName : insertIntoTableDepartment.keySet()) {
                valuesCount--;
                String valueColumn = valueName + " ='" + insertIntoTableDepartment.get(valueName) + (valuesCount != 0 ? "' , " : "'");
                sqlStatement.append(valueColumn);
            }
            sqlStatement.append(" WHERE department_id = " + department.getId());
            stmt.executeUpdate(sqlStatement.toString());
            System.out.println("Update table " + tableName + " from database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
