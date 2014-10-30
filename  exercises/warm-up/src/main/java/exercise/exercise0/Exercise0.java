package exercise.exercise0;

import java.util.ArrayList;
import java.util.LinkedList;
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

        ArrayList<Integer> myList = new ArrayList<Integer>(5);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        ListIterator<Integer> it = myList.listIterator();
        System.out.print("List elements: ");
        while(it.hasNext()){
            int element = it.next();

            System.out.print(element + ", ");
        }

        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements
        System.out.println();
        System.out.print("For loop ->");
        System.out.print("List elements: ");
        for(int counter=0; counter<myList.size(); counter++){

            System.out.print(myList.get(counter) + ", ");
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.println();
        System.out.print("Foreach loop ->");
        System.out.print("List elements: ");
        it = myList.listIterator();
        for(Integer element : myList){

            System.out.print(element + ", ");
        }

        //backward iterator
        System.out.println();
        System.out.println("Iterator backward");
        System.out.print("List elements: ");
        it = myList.listIterator();
        while(it.hasPrevious()){
            int element = it.previous();

            System.out.print(element + ", ");
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 newEx = new Exercise0();
        newEx.iterateThroughList();
    }
}
