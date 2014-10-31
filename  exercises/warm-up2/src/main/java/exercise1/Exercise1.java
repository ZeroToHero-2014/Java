package exercise1;

import java.util.*;

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
        List<String> seekingCountries = new ArrayList<String>();

        for(String country : countries.keySet())
            if (country.startsWith("R")) {
                seekingCountries.add(country);
            }

        // The list of countries that start with the 'R' character



        return seekingCountries;
    }

//    Find all the countries that start with 'R' character, iterating through the keys of the Map using
//    *              Map.Entry, and convert all the characters of the countries found to lowercase
    // TODO Exercise #1 b) You need to iterate over the map entries using a foreach loop (see Map.Entry)
    // TODO Exercise #1 b) and convert to lowercase (hint: String documentation) all the countries that start with 'R'
    // TODO Exercise #1 b) character into the seekingCountries list

    public List<String> iteratingOverEntries(){

        // The list of countries that start with the 'R' character and will be converted to lowercase
        List<String> seekingCountries = new ArrayList<String>();
        Set<Map.Entry<String, String>> entrySet = countries.entrySet();
        Iterator<Map.Entry<String, String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> var = it.next();
            if (var.getKey().startsWith("R")) {
                String s = var.getKey().toLowerCase();
                seekingCountries.add(s);
            }
        }

        return seekingCountries;
    }

    // TODO Exercise #1 c) You need to iterate over the map values using a foreach loop (see Map.values())
    // TODO Exercise #1 c) and find the capital city with the longest name
    //c) Find the capital city with the longest name, iterating through the values of the Map (values() method)
    public String iteratingOverValues(){

        // The country that has the capital city with the longest name
        String seekingCapital = "";
        int max = 0;
        for(String capital : countries.values()) {
            if (capital.length() > max) {
                max = capital.length();
                seekingCapital = capital;
            }

        }

        return seekingCapital;
    }
}
