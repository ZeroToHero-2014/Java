package exercise.exercise0;

import java.util.ArrayList;
import java.util.LinkedList;
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
        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        List<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);


        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator<Integer> arrayIterator = arrayList.listIterator();
        System.out.println("Afisarea ArrayList utilizand ListIterator");
        while(arrayIterator.hasNext()){
            System.out.println("ArrayList: " + arrayIterator.next());
        }
        System.out.println();

        System.out.println("Afisarea LinkedList utilizand ListIterator");
        ListIterator<Integer> linkedIterator = linkedList.listIterator();
        while(linkedIterator.hasNext()){
            System.out.println("LinkedList: " + linkedIterator.next());
        }
        System.out.println();


        // TODO Exercise #0 c) Iterate through the list using for loop and print all its elements

        System.out.println("Afisarea ArrayList utilizand for");
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println("ArrayList: " + arrayList.get(i));
        }
        System.out.println();

        System.out.println("Afisarea LinkedList utilizand for");
        for (int i = 0; i < linkedList.size(); i++){
            System.out.println("LinkedList: " + linkedList.get(i));
        }
        System.out.println();

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.println("Afisarea ArrayList utilizand foreach");
        for(Integer a : arrayList){
            System.out.println("ArrayList: " + a);
        }
        System.out.println();

        System.out.println("Afisarea LinkedList utilizand foreach");
        for(Integer l : linkedList){
            System.out.println("LinkedList: " + l);
        }
        System.out.println();

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 ex0 = new Exercise0();
        ex0.iterateThroughList();
    }
}