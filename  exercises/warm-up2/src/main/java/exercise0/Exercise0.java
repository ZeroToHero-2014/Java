package exercise0;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 10/29/2014.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys)
 */
public class Exercise0 {

    public Exercise0(){
        Map<String,String> myMap= new HashMap<String,String>();
        myMap.put("Name 1", "Thing 1");
        myMap.put("Name 2", "Thing 2");
        myMap.put("Name 3","Thing 3");
        System.out.println("Withouth iterate");
        System.out.println(myMap.keySet());

        Set<String> mySet = myMap.keySet();
        System.out.println("keySet:");
        for(String name:mySet){
            System.out.println(name);
        }



    }

    // TODO Exercise #0 a) iterate over a Map's keys using keySet method
    public void iterateThroughMap(){
        Map<String,String> myMap= new HashMap<String, String>();
        myMap.put("Random Country 1","Random Capital 1");
        myMap.put("Random Country 2","Random Capital 2");
        myMap.put("Random Country 3","Random Capital 3");
        myMap.put("Normal Country 1","Normal Capital 1");
        myMap.put("Normal Country 2","Normal Capital 2");

        System.out.println("Country keys without iterate");
        System.out.println(myMap.keySet());
        System.out.println("Capitals without iterare");
        System.out.println(myMap.values());

        Set<String> countrySet = myMap.keySet();
        for(String country: countrySet){
            System.out.println(country+"="+myMap.get(country));
        }
        //
        // TODO Exercise #0 b) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 b) Don't forget to specify the types of the key and value when creating the Map

        // TODO Exercise #0 c) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 c) The elements are printed like this: [key1=value1, key2=value2, ...]
        
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
