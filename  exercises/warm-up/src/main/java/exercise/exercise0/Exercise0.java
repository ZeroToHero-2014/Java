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
        ArrayList <Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(4);
        list.add(15);
        list.add(7);
        list.add(9);

        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        for(Integer element:list){
            System.out.println(element);
        }


        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements


        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements

    }

    public static void main(String[] args) {
        Exercise0 nme = new Exercise0();
        nme.iterateThroughList();
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
    }
}
