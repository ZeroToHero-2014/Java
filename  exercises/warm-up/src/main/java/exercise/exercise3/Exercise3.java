package exercise.exercise3;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 10/28/2014.
 *
 * Exercise 3: Fill three Set implementations that you know (Hint: they were described during
 *             the earlier presentation) with the List<String> that is given to this class by
 *             its constructor.
 *
 *             Check out the elements that the list mentioned above contains and then, add them
 *             to your three Sets. After this check out the elements of your Sets. What do you
 *             remark? What could be the reason?
 *
 *             Finally, add to the one of the three Sets some elements
 *             that already exist in the Set (e.g add("that") and add("collection"))
 *
 *             To run your implementation, run the Exercise3Test class.
 */
public class Exercise3 {

    // List containing some elements that need to be added into the Set
    private List<String> listToAdd;

    public Exercise3(List l) {
        listToAdd = l;
    }

    public void addElementsToSets() {
        // hint: you should create an instance for every type of discussed Set implementation
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new TreeSet<String>();
        Set<String> set3 = new LinkedHashSet<String>();


        System.out.println("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Print the content of the elements you will add into the Set
        System.out.println("Lista");
        System.out.println(listToAdd);

        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        set1.addAll(listToAdd);
        set2.addAll(listToAdd);
        set3.addAll(listToAdd);

        // TODO Exercise #3 c) Print the content of the Sets
        System.out.println("Hash");
        System.out.println(set1);
        System.out.println("Tree");
        System.out.println(set2);
        System.out.println("Linked");
        System.out.println(set3);

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?\
        set2.add("collection");
        set2.add("contains");

        System.out.println("Tree");
        System.out.println(set2);
    }
}
