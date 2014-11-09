package ro.teamnet.zth.dao;

import ro.teamnet.zth.domain.Location;
import ro.teamnet.zth.utils.ResultSetToPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Mihai on 11/9/2014.
 */
public class LocationDao {


    public ArrayList<Location> getAllLocations(Connection con){
        PreparedStatement pst = null;
        ArrayList<Location> listaLocatii = null;
        try {
            pst = con.prepareStatement("SELECT * FROM LOCATIONS");

            listaLocatii = ResultSetToPojo.convertToLocation(pst.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pst!=null)
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }


        return listaLocatii;}

    public Location getLocationById(Connection con, Long Id){

        PreparedStatement pst = null;
        Location locatie = null;
        try {
            pst = con.prepareStatement("SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?");
            pst.setLong(1,Id);
            ArrayList<Location> listaLocatii = ResultSetToPojo.convertToLocation(pst.executeQuery());

            locatie = listaLocatii.size()>0?listaLocatii.get(0):null;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pst!=null)
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return locatie;

    }


    public void insertLocation(Connection con,Location l){
    PreparedStatement pst = null;
        //city e required ori aici, ori modificat constrangerea in bd
        //        if(l.getCity() == null)
        //            throw new Exception("Campul obligatoriu lipseste");

        try {
            pst = con.prepareStatement("INSERT into locations(location_id,street_address,postal_code,city,state_province)" +
                    "values (TAB_LOCATION_SEQ.nextval,?,?,?,?)");
            pst.setString(1,l.getStreetAdrees());
            pst.setString(2,l.getPostalCode());
            pst.setString(3,l.getCity());
            pst.setString(4,l.getStateProvince());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pst!=null)
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }


    public void updateLocation(Connection con,Location l){
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement(" UPdAte LOCATIONS SET " +
                    "  street_address = ?," +
                    "  postal_code = ?," +
                    "  city = ?," +
                    "  state_province = ?" +
                    "  where location_id = ?");


            pst.setString(1,l.getStreetAdrees());
            pst.setString(2,l.getPostalCode());
            pst.setString(3,l.getCity());
            pst.setString(4,l.getStateProvince());
            pst.setLong(5,l.getId());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pst!=null)
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }


    public void deleteLocation(Connection con,Long Id){
    PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("DELETE FROM LOCATIONS WHERE LOCATION_ID = ?");
            pst.setLong(1,Id);

            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pst!=null)
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }

}
