package exercise.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 10/28/2014.
 *
 * Exercise 1: Compute the sum, the minimum and the maximum element from a given list (givenList) using three
 *             different ways to iterate over a List:
 *             a) ListIterator (implement it in the iterateUsingListIterator() method)
 *             b) for loop (implement it in the iterateUsingForLoop() method)
 *             c) foreach loop (implement it in the iterateUsingForEachLoop() method)
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
        List<Integer> doi = new ArrayList<Integer>();

     /*   givenList.add(43);
        doi.add(53);
        doi.add(3);
        doi.add(67);
        doi.add(999);
        doi.add(2);
        doi.add(89);
       */
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        ListIterator<Integer> iterator = givenList.listIterator();
        while(iterator.hasNext())
            {
                int i1 = iterator.next();
                sum += i1;

                if(min > i1) min = i1;
                if(max < i1) max = i1;
            }



        System.out.println("suma este: " + sum);
        System.out.println("maxim este: " + max);
        System.out.println("minim este: " + min);





        // TODO Exercise #1 a1) In order to pass the tests you need to name your variables sum, min and max or if
        // TODO Exercise #1 a1) you want to name them differently you need to modify when you add them to testValues below

        // Adding the results to the List in order to be tested
        // TODO Exercise #1 a2) Uncomment the following three lines in order to test your implementation

       testValues.add(sum);
       testValues.add(min);
       testValues.add(max);

        return testValues;
    }

  /*  public static void main(String[] args) {
               iterateUsingListIterator


    }
    */

    // TODO Exercise #0 b) Compute sum and get the min and the max from list iterating through it using foreach loop
    public List<Integer> iterateUsingForEachLoop(){

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();

        // Adding the results to the List in order to be tested
        // TODO Exercise #1 b1) Uncomment the following three lines in order to test your implementation

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;


        for(int i = 0; i < givenList.size(); i++ ){

            int i1 = givenList.get(i);
            sum += i1;

            if(min > i1) min = i1;
            if(max < i1) max = i1;

        }


        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);



        return testValues;
    }
}
