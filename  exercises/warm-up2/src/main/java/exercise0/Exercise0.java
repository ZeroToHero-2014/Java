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
        HashMap<String,String> myHasMap = new HashMap<>();
        myHasMap.put("Car1","Dacia");
        myHasMap.put("Car2","Opel");
        myHasMap.put("Car3","Lada");
        myHasMap.put("Car4","Audi");
        // TODO Exercise #0 c) Iterate over the Map using keySet() method and print all its elements
        for(String str :myHasMap.keySet()){
            System.out.println(myHasMap.get(str));
        }
        // TODO Exercise #0 c) The elements are printed like this: [key1=value1, key2=value2, ...]
        System.out.println(myHasMap);
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
