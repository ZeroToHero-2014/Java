package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Maria on 11/4/2014.
 */
public class JobDao {

    public ArrayList<Job> getAllJobs(Connection con) {
        PreparedStatement stm = null;
        String selectAllFromString = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs";

        try {
            stm = con.prepareStatement(selectAllFromString);
            ResultSet rs = stm.executeQuery();

            return ResultSetToPojoConverter.convertToJob(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Job>();
    }

    public Job getJobById(Connection con, String id) throws SQLException {
        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary " + "FROM Jobs WHERE job_id = ?";
        ArrayList<Job> jobs = new ArrayList<Job>();
        PreparedStatement stm = con.prepareStatement(selectAllFromTableString);
        stm.setString(1,id);
        ResultSet rs = stm.executeQuery();

        try {
            jobs= ResultSetToPojoConverter.convertToJob(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stm.close();

        }
        return jobs.size() > 0 ?jobs.get(0) :null;
    }
}
