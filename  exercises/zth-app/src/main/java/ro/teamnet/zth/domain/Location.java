package ro.teamnet.zth.domain;

/**
 * Created by Mihai on 11/9/2014.
 */
public class Location {

    private Long id;
    private String streetAdrees;
    private String postalCode;
    private String city;
    private String stateProvince;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAdrees() {
        return streetAdrees;
    }

    public void setStreetAdrees(String streetAdrees) {
        this.streetAdrees = streetAdrees;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAdrees='" + streetAdrees + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
}
