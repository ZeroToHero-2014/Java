package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ovy on 11/4/2014.
 */
public class JobDao {
    public ArrayList<Job> getAllJobs(Connection con) {
        String sq="SELECT JOB_ID,JOB_TITLE,MAX_SALARY,MIN_SALARY FROM  JOBS";
        PreparedStatement stmt=null;
        ResultSet st= null;
        ArrayList<Job>  job = new ArrayList<Job>();
        try {
            stmt = con.prepareStatement(sq);


            st = stmt.executeQuery();

           return ResultSetToPojoConverter.convertToJob(st, con);

        }
        catch (SQLException e){
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
    public  Job getJobById(Connection con,String id) {
        String sq ="select job_id,job_title,min_salary,max_salary from Jobs where job_id= ? ";
        PreparedStatement stm=null;
        ResultSet re=null;
        ArrayList<Job> jobs = null;
        try {
            stm = con.prepareStatement(sq);
            stm.setString(1,id);
            re = stm.executeQuery();

            jobs = ResultSetToPojoConverter.convertToJob(re, con);
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jobs.size()>0 ? jobs.get(0) : null;

    }

}
