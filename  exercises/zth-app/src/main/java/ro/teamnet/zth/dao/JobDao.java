package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 11/3/2014.
 */
public class JobDao {

    public ArrayList<Job> getAllJobs(Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(" SELECT job_id, job_title, min_salary, max_salary FROM Jobs");


            ResultSet rs = ps.executeQuery();


            return ResultSetToPojo.convertToJob(rs);

        } finally {
            ps.close();
        }
    }


    public Job getJobByid(Connection con, String id) throws SQLException {

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(" Select job_id, job_title, min_salary, max_salary " +
                    "From jobs where job_id = ?");
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            ArrayList<Job> a = ResultSetToPojo.convertToJob(rs);

            return a.size() > 0 ? a.get(0) : null;
        } finally {
            ps.close();
        }
    }

    public void insertJob(Connection con,Job job) throws SQLException {

        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement(" insert into jobs(job_id,job_title,min_salary,max_salary) " +
       "values (?,?,?,?)");
       pst.setString(1,job.getId());
       pst.setString(2,job.getJob_title());
       pst.setDouble(3,job.getMin_salary());
       pst.setDouble(4,job.getMax_salary());
       pst.execute();
        }
        finally {
            if(pst!=null)
                pst.close();
        }

    }

    public void updateJob(Connection con,Job job) throws SQLException {

        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("UPDATE  jobs set" +
                    "  job_title = ?," +
                    "  min_salary = ?," +
                    "  max_salary = ?" +
                    "where job_id =  ?");
            pst.setString(1,job.getJob_title());
            pst.setDouble(2,job.getMin_salary());
            pst.setDouble(3,job.getMax_salary());
            pst.setString(4,job.getId());
    pst.execute();
        }
        finally {
            if(pst!=null)
                pst.close();
        }
    }

    public void deleteJob(Connection con,String id) throws SQLException {

        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("DELETE FROM JOBS WHERE JOB_ID = ?");
            pst.setString(1,id);
            pst.execute();
        }
        finally {
            if(pst!=null)
                pst.close();
        }
    }










}
/*
    public Job getJobByIdcutry(Connection con, String id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Job> listaJobs = null;
        try {
            ps = con.prepareStatement(" Select job_id, job_title, min_salary, max_salary " +
                    "From jobs where job_id = ?");
            ps.setString(1, id);

            rs = ps.executeQuery();

            listaJobs = ResultSetToPojo.convertToJob(rs);

            return listaJobs.size() > 0 ? listaJobs.get(0) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

                return null;
        }
    }



*/
