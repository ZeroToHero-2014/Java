package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
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
public class JobDao {

    public ArrayList<Job> getAllJobs(Connection con) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectAllFromTableString = "Select job_id, job_title, min_salary, max_salary from Jobs";
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setMaxRows(5);
            rs = stmt.executeQuery();
            return ResultSetToPojoConvert.convertToJob(rs, con);
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
        return new ArrayList<Job>();
    }

    public Job getJobById(Connection con, String id) {
        String selectAllFromTableString = "Select * from Jobs where job_id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Job> jobs = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            jobs = ResultSetToPojoConvert.convertToJob(rs, con);
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
        return jobs.size() > 0 ? jobs.get(0) : null;
    }

    public void saveJob(Job job, Connection con) {
        HashMap<String, String> insertIntoTableJobs = new HashMap<String, String>();
        String tableName = "jobs";

        insertIntoTableJobs.put("job_id", job.getJobId());
        insertIntoTableJobs.put("job_title", job.getJobTitle());
        insertIntoTableJobs.put("min_salary", job.getMinSalary().toString());
        insertIntoTableJobs.put("max_salary", job.getMaxSalary().toString());

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("");
            String createTableString = "INSERT INTO " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTableJobs.keySet().size();

            for (String value : insertIntoTableJobs.keySet()) {
                valuesCount--;
                String columnName = value + (valuesCount != 0 ? " , " : " ) ");
                sqlStatement.append(columnName);
            }

            sqlStatement.append(" VALUES ( '");
            valuesCount = insertIntoTableJobs.keySet().size();

            for (String valueName : insertIntoTableJobs.keySet()) {
                valuesCount--;
                String columnString = insertIntoTableJobs.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
                sqlStatement.append(columnString);
            }

            stmt.executeQuery(sqlStatement.toString());
            stmt.close();
            System.out.println("Inserted into table " + tableName + "...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateJob(Job job, Connection con){
        HashMap<String, String> insertIntoTableJobs = new HashMap<String, String>();
        String tableName = "jobs";

        insertIntoTableJobs.put("job_id", job.getJobId());
        insertIntoTableJobs.put("job_title", job.getJobTitle());
        insertIntoTableJobs.put("min_salary", job.getMinSalary().toString());
        insertIntoTableJobs.put("max_salary", job.getMaxSalary().toString());

        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("");
            String updateTableString = "UPDATE " + tableName + " SET ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(updateTableString);
            Integer columnsCount = insertIntoTableJobs.keySet().size();

            for(String columnName : insertIntoTableJobs.keySet()){
                columnsCount --;
                String columnString = columnName + " = '" + insertIntoTableJobs.get(columnName) + (columnsCount != 0 ? "' , " : "' ");
                sqlStatement.append(columnString);
            }

            sqlStatement.append("WHERE job_id = " + job.getJobId());
            stmt.executeQuery(sqlStatement.toString());
            stmt.close();
            System.out.println("Created table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJob(Job job, Connection con){
        PreparedStatement stmt;
        String tableName = "jobs";
        try {
            stmt = con.prepareStatement("");
            String deleteStatement = "DELETE FROM " + tableName + " WHERE job_id = " + job.getJobId();
            stmt.executeUpdate(deleteStatement);
            stmt.close();
            System.out.println("Dropped table " + tableName + " from database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
