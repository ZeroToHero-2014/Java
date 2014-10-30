package exercise.exercise0;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

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
        List<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        for(int i = 0; i < 5; i++)
        {
            list.add((Integer)r.nextInt(100));
        }

        System.out.println(list);

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        ListIterator<Integer> it = list.listIterator();
        System.out.println("Iterate with iterator");
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements
        System.out.println("Iterate with for loop");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.println("Iterate with foreach");
        for(Integer integer : list)
        {
            System.out.println(integer);
        }

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 e = new Exercise0();

       e.iterateThroughList();
    }
}
