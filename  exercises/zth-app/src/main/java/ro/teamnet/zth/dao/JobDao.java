package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by hangan on 11/4/2014.
 */
public class JobDao {
    public ArrayList<Job>getAllJobs(Connection con){
        String selectAllFromTableString = "SELECT job_id,job_title,min_salary,max_salary FROM jobs";
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = stmt.executeQuery();
            return ResultSetToPojoConverter.covertToJob(rs,con);
        }catch (SQLException e){
            e.printStackTrace();
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

    public Job getJobByID(Connection con, String id) {
        String selectAllFromTableString = "SELECT job_id,job_title,min_salary,max_salary FROM Jobs WHERE job_id = '" + id + "'";
        PreparedStatement stmt = null;
        ArrayList<Job> jobs = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            jobs = ResultSetToPojoConverter.covertToJob(rs, con);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobs.size() > 0 ? jobs.get(0) : null;
    }
}
