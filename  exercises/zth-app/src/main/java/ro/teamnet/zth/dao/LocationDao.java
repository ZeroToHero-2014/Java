package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Buli on 11/9/2014.
 */
public class LocationDao {

    public ArrayList<Location> getAllLocations(Connection con){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectAllFromTableString = "Select * from locations";
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setMaxRows(5);
            rs = stmt.executeQuery();
            return ResultSetToPojoConvert.convertToLocation(rs, con);
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

    public Location getLocationById(Connection con, int id) {
        String selectAllFromTableString = "Select * from locations where location_id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Location> location = null;
        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            location = ResultSetToPojoConvert.convertToLocation(rs, con);
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
        return location.size() > 0 ? location.get(0) : null;
    }

    public void saveLocation(Location location, Connection con){
        HashMap<String, String> insertIntoTablelocation = new HashMap<String, String>();
        String tableName = "locations";

        insertIntoTablelocation.put("location_id",location.getLocationId().toString());
        insertIntoTablelocation.put("street_address",location.getStreetAdress().toString());
        insertIntoTablelocation.put("postal_code",location.getPostalCode().toString());
        insertIntoTablelocation.put("city",location.getCity().toString());
        insertIntoTablelocation.put("state_province",location.getStateProvince().toString());

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("");
            String createTableString = "INSERT INTO " + tableName + " ( ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTablelocation.keySet().size();

            for(String value : insertIntoTablelocation.keySet()){
                valuesCount --;
                String columnName = value + (valuesCount != 0 ? " , " : " ) ");
                sqlStatement.append(columnName);
            }

            sqlStatement.append(" VALUES ( '");
            valuesCount = insertIntoTablelocation.keySet().size();

            for(String valueName : insertIntoTablelocation.keySet()){
                valuesCount --;
                String columnString = insertIntoTablelocation.get(valueName) + (valuesCount != 0 ? "' , '" : "')");
                sqlStatement.append(columnString);
            }

            stmt.executeQuery(sqlStatement.toString());
            stmt.close();
            System.out.println("Inserted into table " + tableName + "...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLocation(Location location, Connection con){
        HashMap<String, String> insertIntoTablelocation = new HashMap<String, String>();
        String tableName = "locations";

        insertIntoTablelocation.put("location_id",location.getLocationId().toString());
        insertIntoTablelocation.put("street_address",location.getStreetAdress().toString());
        insertIntoTablelocation.put("postal_code",location.getPostalCode().toString());
        insertIntoTablelocation.put("city",location.getCity().toString());
        insertIntoTablelocation.put("state_province",location.getStateProvince().toString());

        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("");
            String updateTableString = "UPDATE " + tableName + " SET ";
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(updateTableString);
            Integer columnsCount = insertIntoTablelocation.keySet().size();

            for(String columnName : insertIntoTablelocation.keySet()){
                columnsCount --;
                String columnString = columnName + " = '" + insertIntoTablelocation.get(columnName) + (columnsCount != 0 ? "' , " : "' ");
                sqlStatement.append(columnString);
            }

            sqlStatement.append("WHERE location_id = " + location.getLocationId());
            stmt.executeQuery(sqlStatement.toString());
            stmt.close();
            System.out.println("Created table " + tableName + " in database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLocation(Location location, Connection con){
        PreparedStatement stmt;
        String tableName = "location";
        try {
            stmt = con.prepareStatement("");
            String deleteStatement = "DELETE FROM " + tableName + " WHERE location_id = " + location.getLocationId();
            stmt.executeUpdate(deleteStatement);
            stmt.close();
            System.out.println("Dropped table " + tableName + " from database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
