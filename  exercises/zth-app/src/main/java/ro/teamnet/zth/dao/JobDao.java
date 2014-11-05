package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Bogdan on 11/4/2014.
 */
public class JobDao
{
    public ArrayList<Job> getAllJobs(Connection con)
    {


        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs ";
        PreparedStatement pstmt = null;
        try
        {
            pstmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();
            return ResultSetToPojoConverter.convertToJob(rs, con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return new ArrayList<Job>();
    }

    public Job getJobById (Connection con, String id) {
        PreparedStatement pstmt = null;
        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs WHERE job_id = ?";
        ArrayList<Job> jobs = null;
        try
        {
            pstmt = con.prepareStatement(selectAllFromTableString);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            jobs = ResultSetToPojoConverter.convertToJob(rs, con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


        return jobs.size() > 0 ? jobs.get(0) : null;
    }
}
