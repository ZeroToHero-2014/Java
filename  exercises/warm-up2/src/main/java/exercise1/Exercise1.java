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

        // The list of countries that start with the 'R' character

        List<String> seekingCountries = new ArrayList<String>();
        for(String it: countries.keySet()){

         Character x = it.charAt(0);
            if(x.equals('R')){
                seekingCountries.add(it);
            }

        }


        return seekingCountries;
    }

    // TODO Exercise #1 b) You need to iterate over the map entries using a foreach loop (see Map.Entry)
    // TODO Exercise #1 b) and convert to lowercase (hint: String documentation) all the countries that start with 'R'
    // TODO Exercise #1 b) character into the seekingCountries list
    public List<String> iteratingOverEntries(){

        // The list of countries that start with the 'R' character and will be converted to lowercase

        List<String> seekingCountries = new ArrayList<String>();
      //Iterator i = countries.entrySet().iterator();

       // Iterator i = set.iterator();
        for (Map.Entry<String, String> entry : countries.entrySet())
        {
            String key = entry.getKey();
            String  value = entry.getValue();
        /*while(i.hasNext()){
            String st=countries.get(i.next());*/
            Character x = value.charAt(0);
            if(x.equals('R')){
                seekingCountries.add(key.toLowerCase());
               // st.toLowerCase();
                //countries.put(countries.get(i.hasNext()),st);
            }
        }

        return seekingCountries;
    }

    // TODO Exercise #1 c) You need to iterate over the map values using a foreach loop (see Map.values())
    // TODO Exercise #1 c) and find the capital city with the longest name
    public String iteratingOverValues(){
        String k="";
        Integer x=Integer.MIN_VALUE;
        for(String v: countries.values() )
        {
            if(v.length()>x){
                k=v;
                x=v.length();
            }

        }

        // The country that has the capital city with the longest name
        String seekingCapital =k;


        return seekingCapital;
    }
}
