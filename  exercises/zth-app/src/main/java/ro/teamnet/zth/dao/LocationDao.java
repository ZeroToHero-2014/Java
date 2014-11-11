package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by iancu_000 on 11-Nov-14.
 */
public class LocationDao
{
    public ArrayList<Location> getAllLocations(Connection con)
    {


        String selectAllFromTableString = "SELECT location_id, street_address, postal_code, city, state_province FROM Locations";
        PreparedStatement pstmt = null;
        try
        {
            pstmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = pstmt.executeQuery();
            return ResultSetToPojoConverter.convertToLocation(rs, con);
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
        return new ArrayList<Location>();
    }

    public Location getLocationById (Connection con, String id) {
        PreparedStatement pstmt = null;
        String selectAllFromTableString = "SELECT location_id, street_address, postal_code, city, state_province FROM Locations  WHERE location_id = ?";
        ArrayList<Location> locations = null;
        try
        {
            pstmt = con.prepareStatement(selectAllFromTableString);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            locations = ResultSetToPojoConverter.convertToLocation(rs, con);
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


        return locations.size() > 0 ? locations.get(0) : null;
    }
}
