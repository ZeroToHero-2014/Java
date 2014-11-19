package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Locations;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by hangan on 11/9/2014.
 */
public class LocationsDao {

    public ArrayList<Locations> getAllLocations(Connection con){
        String selectAllFromTableString = "SELECT location_id,street_address,postal_code,city,state_province FROM locations";
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = stmt.executeQuery();
            return ResultSetToPojoConverter.covertToLocations(rs, con);
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Locations>();

    }

    public Locations getLocationsByID(Connection con, String id) {
        String selectAllFromTableString = "SELECT location_id,street_address,postal_code,city,state_province FROM locations WHERE location_id = '" + id + "'";
        PreparedStatement stmt = null;
        ArrayList<Locations> locations = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            locations = ResultSetToPojoConverter.covertToLocations(rs, con);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations.size() > 0 ? locations.get(0) : null;
    }
}
