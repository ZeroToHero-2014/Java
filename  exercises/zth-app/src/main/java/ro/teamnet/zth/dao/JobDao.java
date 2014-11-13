package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;

public class JobDao {

    public ArrayList<Job> getAllJobs(Connection con) {

        String selectAllFromTableString = "Select job_id, job_title, min_salary, max_salary FROM Jobs";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(selectAllFromTableString);

            ResultSet rs = stmt.executeQuery();

            return ResultSetToPojoConverter.convertToJob(rs);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Job>();
    }

    public Job getJobById(Connection con, String id) {

        String selectAllFromTableString = "Select job_id, job_title, min_salary, max_salary FROM Jobs WHERE job_id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Job> jobs = ResultSetToPojoConverter.convertToJob(rs);

            return jobs.size() > 0 ? jobs.get(0) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            return null;
    }
}
