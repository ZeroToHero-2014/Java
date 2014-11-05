package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Juvie on 04.11.2014.
 */
public class JobDao {
    public ArrayList<Job> getAllJobs(Connection con){
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs";

        try {
            psmt = con.prepareStatement(selectAllFromTableString.toString());
            rs = psmt.executeQuery();
            return ResultSetToPojoConverter.convertToJob(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Job>();
    }

    public Job getJobById(Connection con, String id) {
        PreparedStatement psmt = null;
        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary " +
                "FROM Jobs WHERE job_id = ? ";
        ArrayList<Job> jobs = new ArrayList<Job>();
        ResultSet rs = null;
        try {
            psmt = con.prepareStatement(selectAllFromTableString.toString());
            psmt.setString(1, id);
            rs = psmt.executeQuery();
            jobs = ResultSetToPojoConverter.convertToJob(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                psmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jobs.size() > 0 ? jobs.get(0) : null;

    }
}
