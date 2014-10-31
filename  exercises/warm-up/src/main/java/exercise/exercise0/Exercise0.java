package exercise.exercise0;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * Created by Radu.Hoaghe on 10/29/2014.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)
       LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0; i<5; i++)
            list.add(i, i+2*i);

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        Iterator<Integer> it= list.iterator();
        while (it.hasNext()) {
            Integer elem = it.next();
            System.out.println("val: " + elem + " ");
        }
        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements
        for (int el : list)
            System.out.println(el + " ");
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for(int i=0; i<5; i++)
            System.out.println(list.get(i) + " ");
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughList();
    }
}
