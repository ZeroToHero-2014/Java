package exercise0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        HashMap<Integer, String > map = new HashMap<Integer,String>();

        map.put(1, "Val1");
        map.put(2, "Val2");
        map.put(3, "Val3");

        Iterator it = map.keySet().iterator();

        while(it.hasNext()){

            System.out.println(it.next());
        }

        // TODO Exercise #0 c) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 c) The elements are printed like this: [key1=value1, key2=value2, ...]

        System.out.println(map);
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
