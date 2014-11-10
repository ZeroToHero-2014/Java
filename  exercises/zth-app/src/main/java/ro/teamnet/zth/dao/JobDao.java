package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by George on 11/4/2014.
 */
public class JobDao {
    public ArrayList<Job> getAllJobs(Connection con){

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            String selectAllFromTableString = "select job_id, job_title, min_salary, max_salary from jobs";
            preparedStatement = con.prepareStatement(selectAllFromTableString);
             rs = preparedStatement.executeQuery();

            return ResultSetToPojoConverter.convertToJob(rs, con);
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
        return new ArrayList<Job>();
    }

    public Job getJobById(Connection con, String id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList<Job> jobs = null;

        try {
            String selectAllFromTableString = "select * from jobs where job_id = ?";
            preparedStatement = con.prepareStatement(selectAllFromTableString);
            preparedStatement.setString(1, id);
//            preparedStatement.setMaxRows(5);
            rs = preparedStatement.executeQuery();
            jobs = ResultSetToPojoConverter.convertToJob(rs, con);
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
        return jobs.size() > 0 ? jobs.get(0) : null;
    }

    /**
     * Insert a job into jobs Table
     * @param con       - connection
     * @param job    - job
     */
    public void insertIntoJobs(Connection con, Job job){
        PreparedStatement preparedStatement = null;
        String tableName = "jobs";

        /*

    private String id;
    private String title;
    private Double minSalary;
    private Double maxSalary;
         */
        try{
            String command = "insert into " + tableName + "(job_id, job_title, min_salary, max_salary)"
                    + " values (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(command);
            preparedStatement.setString(1, job.getId());
            preparedStatement.setString(2, job.getTitle());
            preparedStatement.setDouble(3, job.getMinSalary());
            preparedStatement.setDouble(4, job.getMaxSalary());

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Job with name: " + job.getTitle()
                        + " are inserted into table jobs \n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * Update a job from jobs table
     *
     * @param con   - connection
     * @param job    - job
     */
    public void updateJob(Connection con, Job job){
        PreparedStatement preparedStatement = null;
        String tableName = "jobs";

        try{
            String command = "update " + tableName +
                    " set job_title=?, min_salary=?, max_salary=? " +
                    " where job_id=?";
            preparedStatement = con.prepareStatement(command);
            preparedStatement.setString(1, job.getTitle());
            preparedStatement.setDouble(2, job.getMinSalary());
            preparedStatement.setDouble(3, job.getMaxSalary());
            preparedStatement.setString(4, job.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Update job with name: " + job.getTitle() + "\n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * Delete job by id
     *
     * @param con - connection
     * @param idJob - id of job
     */
    public void deleteJob(Connection con, String idJob){
        PreparedStatement preparedStatement = null;
        String tableName = "jobs";

        try{
            String command = "delete from " + tableName + " where job_id=?";
            preparedStatement = con.prepareStatement(command);
            preparedStatement.setString(1, idJob);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Deleted job with id: " + idJob + "\n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
