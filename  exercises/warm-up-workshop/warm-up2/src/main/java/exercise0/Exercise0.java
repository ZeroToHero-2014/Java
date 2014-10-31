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

        HashMap<Integer,String> exer1 = new HashMap();

        exer1.put(1,"A");
        exer1.put(2,"B");
        exer1.put(3,"C");
        exer1.put(4,"D");

        Set<Integer> chei = exer1.keySet();

        // TODO Exercise #0 b) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 b) Don't forget to specify the types of the key and value when creating the Map



        // TODO Exercise #0 c) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 c) The elements are printed like this: [key1=value1, key2=value2, ...]

        for (Integer element:chei){
            System.out.println(element);
        }

        System.out.println(exer1);
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}