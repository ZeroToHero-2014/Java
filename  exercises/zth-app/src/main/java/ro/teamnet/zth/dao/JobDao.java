package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class JobDao {

    public ArrayList<Job> getAllJobs(Connection con) {

        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            return ResultSetToPojoConverter.convertToJob(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Job>();
    }

    public  Job getJobById(Connection con, String id) {

        PreparedStatement stmt = null;
        ArrayList<Job> jobs = new ArrayList<Job>();

        try {
            String SelectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary " +
                    " FROM Jobs Where job_id = ?";
            stmt = con.prepareStatement(SelectAllFromTableString);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            jobs = ResultSetToPojoConverter.convertToJob(rs, con);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return jobs.size() > 0 ? jobs.get(0) : null;
    }

    public void saveJob(Job job, Connection con) {
        LinkedHashMap<String, String> insertIntoTableJobs = new LinkedHashMap<String, String>();
        String tableName = "jobs";
        insertIntoTableJobs.put("job_id", job.getId());
        insertIntoTableJobs.put("job_title", job.getJobTitle());
        insertIntoTableJobs.put("min_salary", job.getMinSalary().toString());
        insertIntoTableJobs.put("max_salary", job.getMaxSalary().toString());
        PreparedStatement stmt = null;
        String createTableString = "INSERT INTO" + tableName + "(";
        try {
            stmt = con.prepareStatement(createTableString);
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTableJobs.keySet().size();
            for (String valueName: insertIntoTableJobs.keySet()) {
                valuesCount--;
                String columnString = valueName + (valuesCount !=0 ? " , " : ")");
                sqlStatement.append(columnString);
            }
            valuesCount = insertIntoTableJobs.keySet().size();
            sqlStatement.append(" VALUES ( '");
            for (String valueName : insertIntoTableJobs.keySet()) {
                valuesCount--;
                String columnString = insertIntoTableJobs.get(valueName) + (valuesCount !=0 ? "' , '" : "')");
                sqlStatement.append(columnString);
            }
            stmt.executeUpdate(sqlStatement.toString());
            System.out.println("Inserted into table " + tableName + "...");
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

    public void deleteJob(Job job, Connection con) {
        PreparedStatement stmt = null;
        String tableName = "jobs";
        String deleteStatement = "DELETE FROM " + tableName + " Where job_id = " + job.getId();
        try {
            stmt = con.prepareStatement(deleteStatement);
            stmt.executeUpdate(deleteStatement);
            System.out.println("Dropped table " + tableName + " from database ...");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateJob(Job job, Connection con) {
        LinkedHashMap<String, String> insertIntoTableJobs = new LinkedHashMap<String, String>();
        insertIntoTableJobs.put("job_id", job.getId());
        insertIntoTableJobs.put("job_title", job.getJobTitle());
        insertIntoTableJobs.put("min_salary", job.getMinSalary().toString());
        insertIntoTableJobs.put("max_salary", job.getMaxSalary().toString());

        String tableName = "jobs";
        PreparedStatement stmt = null;
        String createTableString = "UPDATE " + tableName + " SET ";

        try {
            stmt = con.prepareStatement(createTableString);
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer columnsCount = insertIntoTableJobs.keySet().size();

            for (String columnName : insertIntoTableJobs.keySet()) {
                columnsCount--;
                String columnString;
                columnString = columnName + " = '" + insertIntoTableJobs.get(columnName) +  (columnsCount !=0 ? "' , " : "'");
                sqlStatement.append(columnString);
            }
            sqlStatement.append("WHERE job_id = " + job.getId());
            stmt.executeUpdate(sqlStatement.toString());
            System.out.println("Update table " + tableName + " in database ...");
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
