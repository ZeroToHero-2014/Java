package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LocationDao {

    public ArrayList<Location> getAllLocation (Connection con) {
        String selectAllFromTableString = "SELECT location_id, street_address, postal_code, city, state_province FROM Locations";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(selectAllFromTableString);
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            return ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<Location>();
    }

    public Location getLocationById (Connection con, Long id) {

        PreparedStatement stmt = null;
        ArrayList<Location> locations = new ArrayList<Location>();
        String SelectAllFromTableString = "SELECT location_id, street_address, postal_code, city, state_province " +
                " FROM Locations WHERE location_id = ?";

        try {
            stmt = con.prepareStatement(SelectAllFromTableString);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            locations = ResultSetToPojoConverter.convertToLocation(rs, con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return locations.size() > 0 ? locations.get(0) : null;
    }

    public void saveLocation(Location location, Connection con) {
        LinkedHashMap<String, String> insertIntoTableLocation = new LinkedHashMap<String, String>();
        insertIntoTableLocation.put("location_id", location.getId().toString());
        insertIntoTableLocation.put("street_address", location.getStreetAddress());
        insertIntoTableLocation.put("postal_code", location.getPostalCode());
        insertIntoTableLocation.put("city", location.getCity());
        insertIntoTableLocation.put("state_province", location.getStateProvince());
        String tableName = "locations";
        PreparedStatement stmt = null;
        String createTableString = "INSERT INTO " + tableName + " ( ";
        try {
            stmt = con.prepareStatement(createTableString);
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(createTableString);
            Integer valuesCount = insertIntoTableLocation.keySet().size();
            for (String valueName : insertIntoTableLocation.keySet()) {
                valuesCount--;
                String columnString = insertIntoTableLocation.get(valueName) + (valuesCount !=0 ? " , " : " )");
                sqlStatement.append(columnString);
            }
            sqlStatement.append(" VALUES ('");
            valuesCount = insertIntoTableLocation.keySet().size();
            for (String valueName : insertIntoTableLocation.keySet()) {
                valuesCount--;
                String columnString = valueName + ( valuesCount !=0 ? "' , '" : "')");
                sqlStatement.append(columnString);
            }
            stmt.executeUpdate(sqlStatement.toString());
            System.out.println("Insert into table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteLocation(Location location, Connection con) {

        String tableName = "locations";
        PreparedStatement stmt = null;
        String sqlStatement = "DELETE FROM " + tableName + " WHERE location_id = " + location.getId();
        try {
            stmt = con.prepareStatement(sqlStatement);
            stmt.executeUpdate(sqlStatement);
            System.out.println("Dropped from table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateLocation(Location location, Connection con) {
        LinkedHashMap<String, String> insertIntoTableLocations = new LinkedHashMap<String, String>();
        String tableName = "locations";
        insertIntoTableLocations.put("location_id", location.getId().toString());
        insertIntoTableLocations.put("street_address", location.getStreetAddress());
        insertIntoTableLocations.put("postal_code", location.getPostalCode());
        insertIntoTableLocations.put("city", location.getCity());
        insertIntoTableLocations.put("state_province", location.getStateProvince());

        PreparedStatement stmt = null;
        String updateTable = "UPDATE " + tableName + " SET ";
        try {
            stmt = con.prepareStatement(updateTable);
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append(updateTable);
            Integer valuesCount = insertIntoTableLocations.keySet().size();
            for (String valueName : insertIntoTableLocations.keySet()) {
                valuesCount--;
                String columnName = valueName + " = '" + insertIntoTableLocations.get(valueName) + (valuesCount != 0 ? "', " : "'");
                sqlStatement.append(columnName);
            }
            sqlStatement.append(" WHERE location_id = " + location.getId());
            stmt.executeUpdate(sqlStatement.toString());
            System.out.println("Update in table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
