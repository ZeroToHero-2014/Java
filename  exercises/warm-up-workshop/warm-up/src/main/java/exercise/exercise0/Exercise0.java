package exercise.exercise0;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by Radu.Hoaghe on 10/29/2014.
 * <p/>
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 * for loop and foreach loop
 */
public class Exercise0 {

    public Exercise0() {

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 ex0= new Exercise0();
        ex0.iterateThroughList();
    }

    public void iterateThroughList() {

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        ArrayList<Integer> array = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            array.add(r.nextInt(100));
        }

        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator<Integer> it = array.listIterator();
        while (it.hasNext())
            System.out.println(it.next());

        ListIterator<Integer> it1 = array.listIterator(array.size() - 1);
        while (it.hasPrevious())
            System.out.println(it.previous());

        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements
        for (int i = 0; i <array.size() ; i++) {
            System.out.println(array.get(i));
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for (Integer integer:array){
            System.out.println(integer);
        }
    }
}
