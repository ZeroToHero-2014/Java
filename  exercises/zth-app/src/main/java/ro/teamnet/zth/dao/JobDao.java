package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ifrim on 04.11.2014.
 */
public class JobDao {
    public ArrayList getAllJobs(Connection x){
        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs";
       PreparedStatement pstmt = null;
        try {
            pstmt = x.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();

            return ResultSetToPojoConverter.convertToJob(rs, x);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try
            {
                pstmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }



    return new ArrayList<Job>();
}

    public Job getJobId(Connection x, String id) {
        String selectAllFromTableString = " SELECT job_id, job_title, min_salary, max_salary FROM Jobs WHERE job_id = ?";
        PreparedStatement pstmt = null;
        ArrayList<Job> jobs = new ArrayList<Job>();
        try
        {
            pstmt = x.prepareStatement(selectAllFromTableString);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            jobs = ResultSetToPojoConverter.convertToJob(rs, x);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jobs.size() > 0 ? jobs.get(0) : null;
    }
}
