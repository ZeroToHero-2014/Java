package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Miha on 11/7/2014.
 */
public class LocationDao {
    public ArrayList<Location> getAllLocations(Connection con) {
        String sir = "SELECT location_id, street_address, postal_code, city, state_province FROM Locations";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sir);
            rs = ps.executeQuery();
            return ResultSetToPojoConverter.convertToLocation(rs, con);
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Location>();
    }

    public Location getLocationById(Connection con, Long id){
        String sir = "SELECT location_id, street_address, postal_code, city, state_province FROM Locations WHERE location_id= ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{

            ps = con.prepareStatement(sir);
            ps.setMaxRows(5);
            ps.setLong(1,id);
            rs = ps.executeQuery();
            ArrayList<Location> employees = ResultSetToPojoConverter.convertToLocation(rs, con);
            return employees.size() > 0 ? employees.get(0) : null;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
