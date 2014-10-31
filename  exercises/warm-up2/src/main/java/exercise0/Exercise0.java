package exercise0;

import java.util.HashMap;
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
        HashMap<Integer,String> hashMap= new HashMap<Integer, String>();
        hashMap.put(1,"first");
        hashMap.put(2,"second");
        hashMap.put(3,"third");
        hashMap.put(3,"alala");

        // TODO Exercise #0 b) Don't forget to specify the types of the key and value when creating the Map
        Set<Integer> h= hashMap.keySet();

        for( Integer i : h) {
            System.out.println("key"+i + "="+ hashMap.get(i));
        }

        // TODO Exercise #0 c) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 c) The elements are printed like this: [key1=value1, key2=value2, ...]
        
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
