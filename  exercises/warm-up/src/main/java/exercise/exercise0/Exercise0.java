package exercise.exercise0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        List<Integer> lista1 = new ArrayList<Integer>();
        lista1.add(9);
        lista1.add(12);
        lista1.add(5);
        lista1.add(7);
        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator it = lista1.listIterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------");
        it = lista1.listIterator();
        //while(it.hasNext()) {
            System.out.println(it.next());
            System.out.println(it.next());
            System.out.println(it.next());
            System.out.println(it.previous());

       // }
        System.out.println("--------------");
        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements
        for(int i=0; i<lista1.size(); i++) {
            System.out.println(lista1.get(i));
        }
        System.out.println("--------------");
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for(Integer j : lista1) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 ex = new Exercise0();
        ex.iterateThroughList();
    }
}
