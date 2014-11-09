package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Maria on 11/9/2014.
 */
public class LocationDao {

    public ArrayList<Location> getAllLocations(Connection con){
        String SQL = "SELECT location_id, street_address, postal_code, city, state_province FROM locations ";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(SQL);
            rs = stm.executeQuery();
            return ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  new ArrayList<Location>();
    }

    public Location getLocationById(Connection con, Long id){
        String SQL = "SELECT location_id, street_address, postal_code, city, state_province FROM locations WHERE location_id= ? ";
        PreparedStatement stm = null;
        ArrayList<Location> locations = null;
        try {
            stm = con.prepareStatement(SQL);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            locations = ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return locations.size() > 0 ? locations.get(0) : null;
    }
}
