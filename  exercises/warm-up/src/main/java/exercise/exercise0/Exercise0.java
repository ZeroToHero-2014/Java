package exercise.exercise0;

import java.lang.reflect.Array;
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

        ArrayList<String> myList = new ArrayList<String>();
            myList.add("List Element 1");
            myList.add("List Element 2");
            myList.add("List Element 3");


        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
            ListIterator<String> it= myList.listIterator();
            while(it.hasNext()) {
                System.out.println("List of elements displayed with next():"+it.next());
            }
            System.out.println();
            while(it.hasPrevious()){
                System.out.println("List of elements displayed with previous()"+it.previous());
            }

            System.out.println();
        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements
            for(int i=0;i<myList.size();i++){
                System.out.println("Using for loop, the list of elements:"+it.next());

        }
            System.out.println();
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
            System.out.println("Using foreach loop, the list of elements:");
            for(String element : myList){
                System.out.println(element);


            }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
            Exercise0 a= new Exercise0();
            a.iterateThroughList();
    }
}
