package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
<<<<<<< HEAD
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Dumitru on 04.11.2014.
 */
public class JobDao {

    public ArrayList<Job> getAllJobs(Connection con) {

        PreparedStatement pstmt = null;
        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary FROM Jobs";

        try {
            pstmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();

            return ResultSetToPojoConverter.convertToJob(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Job>();
    }

    public Job getJobById(Connection con, String id) {
        PreparedStatement pstmt = null;
        ArrayList<Job> jobs = new ArrayList<Job>();
        String selectAllFromTableString = "SELECT job_id, job_title, min_salary, max_salary " +
                "FROM Jobs WHERE job_id = ?";   //?: analogie cu printf din C :D

        try {
            pstmt = con.prepareStatement(selectAllFromTableString);
            pstmt.setString(1, id); //pentru ?
            ResultSet rs = pstmt.executeQuery();
            jobs = ResultSetToPojoConverter.convertToJob(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jobs.size() > 0 ? jobs.get(0) : null;
    }
=======
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class JobDao {
    public ArrayList<Job> getAllJobs(Connection con) throws SQLException {
            Statement stmt = con.createStatement();
            String selectAllFromTableString = "SELECT job_id,job_title,min_salary,max_salary FROM Jobs";
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            try {
                return ResultSetToPojoConverter.convertToJob(rs,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt.close();
            rs.close();
            return new ArrayList<Job>();
        }
    
        public Job getJobById(Connection con, String id) throws SQLException {
            Statement stmt = con.createStatement();
            String selectAllFromTableString = "SELECT job_id,job_title,min_salary,max_salary " +
                    "FROM Jobs WHERE job_id = '" + id + "'";
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            ArrayList<Job> jobs = ResultSetToPojoConverter.convertToJob(rs,con);
            stmt.close();
            return jobs.size() > 0 ? jobs.get(0) : null;
        }
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
}
