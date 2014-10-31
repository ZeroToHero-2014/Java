package exercise0;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 10/29/2014.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys)
 */
public class Exercise0 {

    HashMap<String, Integer> map = new HashMap<>();


    public Exercise0(){

    }

    // TODO Exercise #0 a) iterate over a Map's keys using keySet method
    public void iterateThroughMap(){

        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        Set<String> keySet = map.keySet();
        for(String key : keySet)
        {
            System.out.println(key);
        }
        System.out.println(map);

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
