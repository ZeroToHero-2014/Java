package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocationDao {
    public ArrayList<Location> getAllLocations(Connection con) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectAllFromTableString = "Select location_id, location_title from Locations";
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setMaxRows(5);
            rs = stmt.executeQuery();
            return ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Location>();
    }

    public Location getLocById(Connection con, String id) {
        String selectAllFromTableString = "Select * from Locations where job_id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Location> locations = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            locations = ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return locations.size() > 0 ? locations.get(0) : null;
    }
}
