package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Miha on 11/4/2014.
 */
public class JobDao {
    public ArrayList<Job> getAllJobs(Connection con) {
        String sir = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sir);
            rs = ps.executeQuery();
            return ResultSetToPojoConverter.convertToJob(rs, con);
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Job>();
    }

    public Job getJobById(Connection con, String id){
        String sir = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs WHERE job_id= ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(sir);
            ps.setString(1,id);
            rs = ps.executeQuery();
            ArrayList<Job> jobs = ResultSetToPojoConverter.convertToJob(rs, con);
            return jobs.size() > 0 ? jobs.get(0) : null;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}