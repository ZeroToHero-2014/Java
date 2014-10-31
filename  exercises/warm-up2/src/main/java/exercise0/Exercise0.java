package exercise0;

import javax.xml.transform.sax.SAXSource;
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

    }

    // TODO Exercise #0 a) iterate over a Map's keys using keySet method
    public void iterateThroughMap(){

        // TODO Exercise #0 b) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 b) Don't forget to specify the types of the key and value when creating the Map
        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("a", "aaa");
        myMap.put("b", "bbb");
        myMap.put("c", "ccc");

        // TODO Exercise #0 c) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 c) The elements are printed like this: [key1=value1, key2=value2, ...]
        Set<String> keys = myMap.keySet();

        for(String key : keys){
            System.out.print("Key = " + key + "\t");
            System.out.println("Value = " + myMap.get(key));
        }

        /*
        for (Map.Entry<String, String> entry : myMap.entrySet()){
            String values = myMap.get(entry.getKey());
            System.out.println("Value = " + values);
        }
        */
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
