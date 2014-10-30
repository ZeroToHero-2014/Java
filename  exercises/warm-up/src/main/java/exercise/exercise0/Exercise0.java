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
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(3); list1.add(1); list1.add(2);list1.add(0);list1.add(4);
        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator<Integer> listIt = list1.listIterator();

        while(listIt.hasNext()){
            System.out.print(listIt.next() + " ");
        }
        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements
        System.out.println();
        for(int i = 0; i<list1.size();i++){
            System.out.print(list1.get(i) + " ");
        }
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.println();
        for(Integer list : list1){
            System.out.print(list + " ");
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 ex0 = new Exercise0();
        ex0.iterateThroughList();
    }
}
