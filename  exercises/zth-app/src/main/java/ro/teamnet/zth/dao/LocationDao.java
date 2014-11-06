package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.*;
import java.util.ArrayList;


public class LocationDao {

    public ArrayList<Location> getAllLocations(Connection con) {

        String SQL = "SELECT location_id, street_address, postal_code, city, state_province FROM locations";

        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(SQL);
            rs = stm.executeQuery();
            return ResultSetToPojoConverter.convertToLocation(rs, con);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Location>();

    }

    public Location getLocationByID(Connection con, Long id) {

        String SQL = "SELECT location_id, street_address, postal_code, city, state_province FROM locations WHERE location_id= ?";


        PreparedStatement stm = null;
        ArrayList<Location> locations = null;
        try {
            stm = con.prepareStatement(SQL);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            locations = ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return locations.size() > 0 ? locations.get(0) : null;
    }

}
