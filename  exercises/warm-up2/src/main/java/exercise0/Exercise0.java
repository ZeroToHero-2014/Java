package exercise0;

import java.util.HashMap;

/**
 * Created by Radu.Hoaghe on 10/29/2014.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys)
 */
public class Exercise0 {

    public Exercise0(){

    }

    // TODO Exercise #0 a) iterate over a Map's keys using keySet method
    public void iterateThroughMap(){


        // TODO Exercise #0 b) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 b) Don't forget to specify the types of the key and value when creating the Map
        HashMap<String, String> hashm = new HashMap<String, String>();
        hashm.put("First Name: " , "John");
        hashm.put("Second Name: " , "Doe");
        hashm.put("Telephone: " , "0123456789");

        // TODO Exercise #0 c) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 c) The elements are printed like this: [key1=value1, key2=value2, ...]

        for(String show : hashm.keySet() )
        {
            System.out.println(show + hashm.get(show));
        
    }}

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
