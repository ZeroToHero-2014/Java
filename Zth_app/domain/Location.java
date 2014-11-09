package ro.teamnet.zth.domain;

/**
 * Created by Maria on 11/9/2014.
 */


    public class Location {

        private Long id;
        private String streetAdress;
        private String postalCode;
        private String city;
        private String stateProvince;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getStreetAdress() {
            return streetAdress;
        }

        public void setStreetAdress(String streetAdress) {
            this.streetAdress = streetAdress;
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

        public void setStateProvince(String stateProvince) {
            this.stateProvince = stateProvince;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "id=" + id +
                    ", streetAdress='" + streetAdress + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    ", city='" + city + '\'' +
                    ", stateProvince='" + stateProvince + '\'' +
                    "}\r\n";
        }
    }


