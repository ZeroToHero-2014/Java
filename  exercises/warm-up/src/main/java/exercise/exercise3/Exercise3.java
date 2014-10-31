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

    public void addElementsToSets(){
        // hint: you should create an instance for every type of discussed Set implementation

        System.out.println("The elements that will be added to the Sets: ");
        Set<String> hashSet = new HashSet<String>();
        Set<String> linkedHS = new LinkedHashSet<String>();
        Set<String> treeset1 = new TreeSet<String>();
    // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        System.out.println(listToAdd.toString());
        hashSet.addAll(listToAdd);
        linkedHS.addAll(listToAdd);
        treeset1.addAll(listToAdd);
    // TODO Exercise #3 c) Check the content of the Sets
        System.out.println("Element hashSet"+hashSet);
        System.out.println("Element linkedHashSet"+linkedHS);
        System.out.println("Element treeset1"+treeset1);
    // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        hashSet.add("that");
        System.out.println("Element hashSet"+hashSet);
// TODO Exercise #3 d) and print again the TreeSet. What do you see?
    }
}
