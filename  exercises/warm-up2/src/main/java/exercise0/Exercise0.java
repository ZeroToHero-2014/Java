package exercise0;

import java.util.*;

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

        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("a1",1);
        myMap.put("a2",2);
        myMap.put("a3",3);
        myMap.put("a4",4);
        myMap.put("b1",1);
        myMap.put("b2",2);
        myMap.put("b3",3);
        myMap.put("b4",4);
        Set<String> mySet = myMap.keySet();
        Iterator<String> it = mySet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // TODO Exercise #0 b) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 b) Don't forget to specify the types of the key and value when creating the Map

        // TODO Exercise #0 c) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 c) The elements are printed like this: [key1=value1, key2=value2, ...]

        for(String s : mySet){
            System.out.println("[" + s + " = " +myMap.get(s) + "]");
        }

    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
