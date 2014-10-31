import exercise1.Exercise1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Radu.Hoaghe on 10/29/2014.
 */
public class Exercise1Test {
    public static final String[][] data = {
            // Africa
            {"ALGERIA","Algiers"}, {"ANGOLA","Luanda"},
            {"BENIN","Porto-Novo"}, {"BOTSWANA","Gaberone"},
            {"BURKINA FASO","Ouagadougou"}, {"BURUNDI","Bujumbura"},
            {"CAMEROON","Yaounde"}, {"CAPE VERDE","Praia"},
            {"CENTRAL AFRICAN REPUBLIC","Bangui"},
            {"CHAD","N’djamena"}, {"COMOROS","Moroni"},
            {"CONGO","Brazzaville"}, {"DJIBOUTI","Dijibouti"},
            {"EGYPT","Cairo"}, {"EQUATORIAL GUINEA","Malabo"},
            {"ERITREA","Asmara"}, {"ETHIOPIA","Addis Ababa"},
            {"GABON","Libreville"}, {"THE GAMBIA","Banjul"},
            {"GHANA","Accra"}, {"GUINEA","Conakry"},
            {"BISSAU","Bissau"}, {"COTE D’IVOIRE (IVORY COAST)","Yamoussoukro"},
            {"KENYA","Nairobi"}, {"LESOTHO","Maseru"},
            {"LIBERIA","Monrovia"}, {"LIBYA","Tripoli"},
            {"MADAGASCAR","Antananarivo"}, {"MALAWI","Lilongwe"},
            {"MALI","Bamako"}, {"MAURITANIA","Nouakchott"},
            {"MAURITIUS","Port Louis"}, {"MOROCCO","Rabat"},
            {"MOZAMBIQUE","Maputo"}, {"NAMIBIA","Windhoek"},
            {"NIGER","Niamey"}, {"NIGERIA","Abuja"},
            {"RWANDA","Kigali"}, {"SAO TOME E PRINCIPE","Sao Tome"},
            {"SENEGAL","Dakar"}, {"SEYCHELLES","Victoria"},
            {"SIERRA LEONE","Freetown"}, {"SOMALIA","Mogadishu"},
            {"SOUTH AFRICA","Pretoria/Cape Town"},
            {"SUDAN","Khartoum"}, {"SWAZILAND","Mbabane"}, {"TANZANIA","Dodoma"},
            {"TOGO","Lome"}, {"TUNISIA","Tunis"},
            {"UGANDA","Kampala"},{"DEMOCRATIC REPUBLIC OF THE CONGO (ZAIRE)", "Kinshasa"},
            {"ZAMBIA","Lusaka"}, {"ZIMBABWE","Harare"},
            // Asia
            {"AFGHANISTAN","Kabul"}, {"BAHRAIN","Manama"},
            {"BANGLADESH","Dhaka"}, {"BHUTAN","Thimphu"},
            {"BRUNEI","Bandar Seri Begawan"},
            {"CAMBODIA","Phnom Penh"},
            {"CHINA","Beijing"}, {"CYPRUS","Nicosia"},
            {"INDIA","New Delhi"}, {"INDONESIA","Jakarta"},
            {"IRAN","Tehran"}, {"IRAQ","Baghdad"},
            {"ISRAEL","Jerusalem"}, {"JAPAN","Tokyo"},
            {"JORDAN","Amman"}, {"KUWAIT","Kuwait City"},
            {"LAOS","Vientiane"}, {"LEBANON","Beirut"},
            {"MALAYSIA","Kuala Lumpur"}, {"THE MALDIVES","Male"},
            {"MONGOLIA","Ulan Bator"}, {"MYANMAR (BURMA)","Rangoon"},
            {"NEPAL","Katmandu"}, {"NORTH KOREA","P’yongyang"},
            {"OMAN","Muscat"}, {"PAKISTAN","Islamabad"},
            {"PHILIPPINES","Manila"}, {"QATAR","Doha"},
            {"SAUDI ARABIA","Riyadh"}, {"SINGAPORE","Singapore"},
            {"SOUTH KOREA","Seoul"}, {"SRI LANKA","Colombo"},
            {"SYRIA","Damascus"}, {"TAIWAN (REPUBLIC OF CHINA)","Taipei"},
            {"THAILAND","Bangkok"}, {"TURKEY","Ankara"},
            {"UNITED ARAB EMIRATES","Abu Dhabi"},
            {"VIETNAM","Hanoi"}, {"YEMEN","Sana’a"},
            // Australia and Oceania
            {"AUSTRALIA","Canberra"}, {"FIJI","Suva"},
            {"KIRIBATI","Bairiki"},{"MARSHALL ISLANDS","Dalap-Uliga-Darrit"},
            {"MICRONESIA","Palikir"}, {"NAURU","Yaren"},
            {"NEW ZEALAND","Wellington"}, {"PALAU","Koror"},
            {"PAPUA NEW GUINEA","Port Moresby"},
            {"SOLOMON ISLANDS","Honaira"}, {"TONGA","Nuku’alofa"},
            {"TUVALU","Fongafale"}, {"VANUATU","Port-Vila"},
            {"WESTERN SAMOA","Apia"},
            // Eastern Europe and former USSR
            {"ARMENIA","Yerevan"}, {"AZERBAIJAN","Baku"},
            {"BELARUS (BYELORUSSIA)","Minsk"},
            {"BULGARIA","Sofia"}, {"GEORGIA","Tbilisi"},
            {"KAZAKSTAN","Almaty"}, {"KYRGYZSTAN","Alma-Ata"},
            {"MOLDOVA","Chisinau"}, {"RUSSIA","Moscow"},
            {"TAJIKISTAN","Dushanbe"}, {"TURKMENISTAN","Ashkabad"},
            {"UKRAINE","Kyiv"}, {"UZBEKISTAN","Tashkent"},
            // Europe
            {"ALBANIA","Tirana"}, {"ANDORRA","Andorra la Vella"},
            {"AUSTRIA","Vienna"}, {"BELGIUM","Brussels"},
            {"BOSNIA-HERZEGOVINA","Sarajevo"},
            {"CROATIA","Zagreb"}, {"CZECH REPUBLIC","Prague"},
            {"DENMARK","Copenhagen"}, {"ESTONIA","Tallinn"},
            {"FINLAND","Helsinki"}, {"FRANCE","Paris"},
            {"GERMANY","Berlin"}, {"GREECE","Athens"},
            {"HUNGARY","Budapest"}, {"ICELAND","Reykjavik"},
            {"IRELAND","Dublin"}, {"ITALY","Rome"},
            {"LATVIA","Riga"}, {"LIECHTENSTEIN","Vaduz"},
            {"LITHUANIA","Vilnius"}, {"LUXEMBOURG","Luxembourg"},
            {"MACEDONIA","Skopje"}, {"MALTA","Valletta"},
            {"MONACO","Monaco"}, {"MONTENEGRO","Podgorica"},
            {"THE NETHERLANDS","Amsterdam"}, {"NORWAY","Oslo"},
            {"POLAND","Warsaw"}, {"PORTUGAL","Lisbon"},
            {"ROMANIA","Bucharest"}, {"SAN MARINO","San Marino"},
            {"SERBIA","Belgrade"}, {"SLOVAKIA","Bratislava"},
            {"SLOVENIA","Ljuijana"}, {"SPAIN","Madrid"},
            {"SWEDEN","Stockholm"}, {"SWITZERLAND","Berne"},
            {"UNITED KINGDOM","London"}, {"VATICAN CITY","Vatican"},
            // North and Central America
            {"ANTIGUA AND BARBUDA","Saint John’s"}, {"BAHAMAS","Nassau"},
            {"BARBADOS","Bridgetown"}, {"BELIZE","Belmopan"},
            {"CANADA","Ottawa"}, {"COSTA RICA","San Jose"},
            {"CUBA","Havana"}, {"DOMINICA","Roseau"},
            {"DOMINICAN REPUBLIC","Santo Domingo"},
            {"EL SALVADOR","San Salvador"}, {"GRENADA","Saint George’s"},
            {"GUATEMALA","Guatemala City"}, {"HAITI","Port-au-Prince"},
            {"HONDURAS","Tegucigalpa"}, {"JAMAICA","Kingston"},
            {"MEXICO","Mexico City"}, {"NICARAGUA","Managua"},
            {"PANAMA","Panama City"}, {"ST. KITTS-NEVIS","Basseterre"}, {"ST. LUCIA","Castries"},
            {"ST. VINCENT AND THE GRENADINES","Kingstown"},
            {"UNITED STATES OF AMERICA","Washington, D.C."},
            // South America
            {"ARGENTINA","Buenos Aires"}, {"BOLIVIA","La Paz"},
            {"BRAZIL","Brasilia"}, {"CHILE","Santiago"},
            {"COLOMBIA","Bogota"}, {"ECUADOR","Quito"},
            {"GUYANA","Georgetown"}, {"PARAGUAY","Asuncion"},
            {"PERU","Lima"}, {"SURINAME","Paramaribo"},
            {"TRINIDAD AND TOBAGO","Port of Spain"},
            {"URUGUAY","Montevideo"}, {"VENEZUELA","Caracas"},
    };
    private Exercise1 exercise1;
    private Map<String, String> countries;
    private String[] expected = {"romania", "rwanda", "russia" };
    private String[] expected2 = {"ROMANIA", "RWANDA", "RUSSIA"};
    private String expectedCapital = "Bandar Seri Begawan";

    @Before
    public void setUp() throws Exception {
        countries = new HashMap<String, String>();
        for(String[] countryAndCapital : data){
            countries.put(countryAndCapital[0], countryAndCapital[1]);
        }
        exercise1 = new Exercise1(countries);

    }

    @Test
    public void testIteratingOverKeys() throws Exception {
        List<String> testResults = exercise1.iteratingOverKeys();
        Assert.assertEquals("Test Iterating Over Keys", Arrays.asList(expected2), testResults);
    }

    @Test
    public void testIteratingOverEntries() throws Exception {
        List<String> testResults = exercise1.iteratingOverEntries();
        Assert.assertEquals("Test Iterating Over Entries", Arrays.asList(expected), testResults);
    }

    @Test
    public void testIteratingOverValues() throws Exception {
        String capital = exercise1.iteratingOverValues();
        Assert.assertEquals("Test Iterating Over Values", expectedCapital, capital);
    }
}
