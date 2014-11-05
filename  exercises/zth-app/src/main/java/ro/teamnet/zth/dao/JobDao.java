package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 11/4/2014.
 */
public class JobDao {
    public ArrayList<Job> getAllJobs(Connection con) {

      PreparedStatement stmt=null;
        try {
            String selectALlFromTableString="SELECT job_id,job_title,min_salary,max_salary FROM jobs";
            stmt=con.prepareStatement(selectALlFromTableString);
            ResultSet rs= null;
            rs = stmt.executeQuery();
            return ResultSetToPojoConvert.convertToJob(rs,con);

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

        return  new ArrayList<Job>();


    }

    public Job getJobById(Connection con, String id) {
        PreparedStatement stmt=null;
        ArrayList<Job> jobs=null;



        try {
            String selectAllFromTableString="SELECT job_id,job_title,min_salary,max_salary FROM Jobs WHERE job_id='" + id + "'";
            stmt=con.prepareStatement(selectAllFromTableString);
            ResultSet rs=stmt.executeQuery();
            jobs=ResultSetToPojoConvert.convertToJob(rs,con);



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

        return jobs.size()> 0 ? jobs.get(0): null;
    }
}
