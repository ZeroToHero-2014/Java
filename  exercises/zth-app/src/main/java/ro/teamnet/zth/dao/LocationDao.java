package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Job;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by George on 11/11/2014.
 */
public class LocationDao {
    public ArrayList<Location> getAllLocations(Connection con){

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            String selectAllFromTableString = "select * from locations";
            preparedStatement = con.prepareStatement(selectAllFromTableString);
            rs = preparedStatement.executeQuery();

            return ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Location>();
    }


    public Location getLocationById(Connection con, String id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList<Location> locations = null;

        try {
            String selectAllFromTableString = "select * from locations where location_id = ?";
            preparedStatement = con.prepareStatement(selectAllFromTableString);
            preparedStatement.setString(1, id);
//            preparedStatement.setMaxRows(5);
            rs = preparedStatement.executeQuery();
            locations = ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return locations.size() > 0 ? locations.get(0) : null;
    }

    /**
     * Insert a location into locations Table
     * @param con    - connection
     * @param location    - location
     */
    public void insertIntoLocations(Connection con, Location location){
        PreparedStatement preparedStatement = null;
        String tableName = "locations";

        /*

    private String id;
    private String title;
    private Double minSalary;
    private Double maxSalary;
         */
        try{
            String command = "insert into " + tableName + "(location_id, street_address, postal_code, city, state_province)"
                    + " values (?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(command);
            preparedStatement.setLong(1, location.getId());
            preparedStatement.setString(2, location.getStreetAddress());
            preparedStatement.setString(3, location.getPostalCode());
            preparedStatement.setString(4, location.getCity());
            preparedStatement.setString(5, location.getStateProvince());

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Location with street: " + location.getStreetAddress()
                        + " are inserted into table locations \n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * Update a location from locations table
     *
     * @param con   - connection
     * @param location    - location
     */
    public void updateLocation(Connection con, Location location){
        PreparedStatement preparedStatement = null;
        String tableName = "locations";

        try{
            String command = "update " + tableName +
                    " set street_address=?, postal_code=?, city=?, state_province " +
                    " where location_id=?";
            preparedStatement = con.prepareStatement(command);
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setLong(4, location.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Update job with street address: " + location.getStreetAddress() + "\n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    /**
     * Delete location by id
     *
     * @param con - connection
     * @param idLocation - id of job
     */
    public void deleteLocation(Connection con, Long idLocation){
        PreparedStatement preparedStatement = null;
        String tableName = "locations";

        try{
            String command = "delete from " + tableName + " where location_id=?";
            preparedStatement = con.prepareStatement(command);
            preparedStatement.setLong(1, idLocation);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.printf("Deleted location with id: " + idLocation + "\n");
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
