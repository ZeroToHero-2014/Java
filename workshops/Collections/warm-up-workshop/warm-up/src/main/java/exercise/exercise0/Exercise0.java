package exercise.exercise0;

/**
 * Created by Radu.Hoaghe on 10/29/2014.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop
 *
 */
import java.util.*;
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(11);

        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        ListIterator<Integer> it = arrayList.listIterator();

        while(it.hasNext())
            System.out.print(it.next() + " ");
        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements

        System.out.println();
        for(int i = 0; i < arrayList.size(); i++)
        {
            System.out.print((Integer)arrayList.get(i) + " ");
        }
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.println();
        for(Integer i : arrayList)
        {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method

        (new Exercise0()).iterateThroughList();
    }
}
