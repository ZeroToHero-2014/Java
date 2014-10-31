package exercise1;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Radu.Hoaghe on 10/29/2014.
 *
 * Exercise 1: You have a Map<String, String> that holds in each element a country with its capital (countries Map)
 *              a) Find all the countries that start with 'R' character, iterating through the keys of the Map using
 *              keySet() method
 *              b) Find all the countries that start with 'R' character, iterating through the keys of the Map using
 *              Map.Entry, and convert all the characters of the countries found to lowercase
 *              c) Find the capital city with the longest name, iterating through the values of the Map (values() method)
 *
 */
public class Exercise1 {

    // A map that holds some key-value pairs, the key represents the country and its value represents
    // the capital city of the country
    private Map<String, String> countries;

    public Exercise1(Map<String, String> countries){
        this.countries = countries;
    }

    // TODO Exercise #1 a) You need to iterate over the map keys using a foreach loop (see Map.keySet())
    // TODO Exercise #1 a) and add the countries that start with 'R' character into the seekingCountries list
    // TODO Exercise #1 a) hint: see String documentation
    public List<String> iteratingOverKeys(){

        // The list of countries that start with the 'R' character
        List<String> seekingCountries = new ArrayList<String>();

        for(String entry: countries.keySet()) {

            if (entry.startsWith("R")){
                seekingCountries.add(entry);
            }


        }



        return seekingCountries;
    }



    public List<String> iteratingOverEntries(){

        // The list of countries that start with the 'R' character and will be converted to lowercase
        List<String> seekingCountries = new ArrayList<String>();
        // TODO Exercise #1 b) You need to iterate over the map entries using a foreach loop (see Map.Entry)
        // TODO Exercise #1 b) and convert to lowercase (hint: String documentation) all the countries that start with 'R'
        // TODO Exercise #1 b) character into the seekingCountries list
        for(Map.Entry<String, String> entry: countries.entrySet()) {

            String key = entry.getKey();
            if (entry.getKey().startsWith("R")){
                seekingCountries.add(entry.getKey().toLowerCase());
            }

        }

        return seekingCountries;
    }

    // TODO Exercise #1 c) You need to iterate over the map values using a foreach loop (see Map.values())
    // TODO Exercise #1 c) and find the capital city with the longest name
    public String iteratingOverValues(){


        // The country that has the capital city with the longest name
        String seekingCapital = "";
        for( String entry: countries.values()) {
            if (seekingCapital.length()< entry.length()){

                seekingCapital=entry;
            }

        }

        return seekingCapital;
    }
}