package ro.teamnet.zth;

import ro.teamnet.zth.dao.JobDao;
import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.utils.DatabaseManager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class App 
{   private static final String USERNAME = "ZTH_20";
    private static final String PASSWORD = "passw0rd";

    public static void main( String[] args )
    {   HashMap hm = new HashMap();
        hm.put("nume", "number");
        hm.put("prenume", "varchar2(32 BYTE)");
        ArrayList<Job> jobs = new ArrayList<Job>();
        Connection con = DatabaseManager.getConnection(USERNAME , PASSWORD);
        DatabaseManager.checkConnection(con);
//        DatabaseManager.create(con, "TEST", hm);
//        DatabaseManager.drop(con, "TEST");
        JobDao jobDao = new JobDao();
        jobs = jobDao.getAllJobs(con);
        for (Job j : jobs) {
            System.out.println(j + " ");
        }

    }
}
