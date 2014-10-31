package exercise.exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Radu.Hoaghe on 10/28/2014.
 *
 * Exercise 1: Compute the sum, the minimum and the maximum element from a given list (givenList) using three
 *             different ways to iterate over a List:
 *             a) ListIterator (implement it in the iterateUsingListIterator() method)
 *             b) foreach loop (implement it in the iterateUsingForEachLoop() method)
 *
 *             In order to test your implementations you need to run the Exercise1Test from the test/java package
 *             (right-click on Exercise1Test class then click Run 'Exercise1Test' )
 */
public class Exercise1{


    private List<Integer> givenList;

    public Exercise1(List l) {
       this.givenList = l;
    }

    // TODO Exercise #1 a) Compute sum and get the min and the max from above 'givenList' iterating through it using ListIterator
    public List<Integer> iterateUsingListIterator(){

            // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        Integer sum = 0;
        Integer min = givenList.get(0);
        Integer max = givenList.get(0);
        Iterator<Integer> it= givenList.iterator();
        while (it.hasNext()) {
            Integer elem = it.next();
            sum += elem;
            if (elem < min) {
                min = elem;
            }
            if (elem > max) {
                max = elem;
            }
        }

        // TODO Exercise #1 a1) In order to pass the tests you need to name your variables sum, min and max or if
        // TODO Exercise #1 a1) you want to name them differently you need to modify when you add them to testValues below

        // Adding the results to the List in order to be tested
//        TODO Exercise #1 a2) Uncomment the following three lines in order to test your implementation
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;

    }

    // TODO Exercise #0 b) Compute sum and get the min and the max from list iterating through it using foreach loop
    public List<Integer> iterateUsingForEachLoop(){


        List<Integer> testValues = new ArrayList<Integer>();
            // This List is used only for testing so you don't need to modify it
        int sum, min, max;
        sum = 0;
        min = givenList.get(0);
        max = givenList.get(0);
        for(int el: givenList) {
            sum = sum + el;
            if (el < min) {
                min = el;
            }
            if (el > max) {
                max = el;
            }
        }
        // Adding the results to the List in order to be tested
        // TODO Exercise #1 b1) Uncomment the following three lines in order to test your implementation
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }


}
