package ro.teamnet.zth.dao;


import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JobDao {

    public ArrayList<Job> getAllJobs(Connection con) {

        String SQL = "SELECT job_id,job_title,min_salary,max_salary FROM Jobs";

        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(SQL);
            rs = stm.executeQuery();
            return ResultSetToPojoConverter.convertToJob(rs, con);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Job>();

    }

    public Job getJobByID(Connection con, String id) {

        String SQL = "SELECT job_id,job_title,min_salary,max_salary FROM Jobs WHERE job_id = ?";


        PreparedStatement stm = null;
        ArrayList<Job> jobs = null;
        try {
            stm = con.prepareStatement(SQL);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            jobs = ResultSetToPojoConverter.convertToJob(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return jobs.size() > 0 ? jobs.get(0) : null;
    }
}
