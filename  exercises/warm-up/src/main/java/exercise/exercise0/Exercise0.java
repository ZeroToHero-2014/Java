package exercise.exercise0;

import java.util.ArrayList;
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
        ArrayList<Integer> el= new ArrayList<Integer>();
        el.add(1);
        el.add(3);
        el.add(5);
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        ListIterator<Integer> list= el.listIterator();
       while (list.hasNext()){
           System.out.print(list.next()+" ");
        }
         // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements
        for (int i=0; i<el.size(); i++){
            System.out.print(el.get(i)+" ");
        }
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
            for(Integer e: el)
                System.out.print(e+" ");
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
       Exercise0 ex= new Exercise0();
        ex.iterateThroughList();
    }
}
