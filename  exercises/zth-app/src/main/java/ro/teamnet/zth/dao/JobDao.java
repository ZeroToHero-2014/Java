package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

}
