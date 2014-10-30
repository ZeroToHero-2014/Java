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
        Set<String> hashSet = new HashSet<String>(listToAdd);
        Set<String> linkedHashSet = new LinkedHashSet<String>(listToAdd);
        Set<String> treeSet = new TreeSet<String>(listToAdd);

        System.out.println("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Print the content of the elements you will add into the Set
        System.out.println("Add \"aaa\" into hashSet: " + hashSet.add("aaa"));
        System.out.println("Add \"bbb\" into hashSet: " + hashSet.add("bbb"));
        System.out.println("Add \"ccc\" into hashSet: " + hashSet.add("ccc"));
        System.out.println("Add \"aaa\" into hashSet: " + hashSet.add("aaa"));
        System.out.println();


        System.out.println("Add \"aaa\" into linkedHashSet: " + linkedHashSet.add("aaa"));
        System.out.println("Add \"bbb\" into linkedHashSet: " + linkedHashSet.add("bbb"));
        System.out.println("Add \"ccc\" into linkedHashSet: " + linkedHashSet.add("ccc"));
        System.out.println("Add \"aaa\" into linkedHashSet: " + linkedHashSet.add("aaa"));
        System.out.println();



        System.out.println("Add \"aaa\" into treeSet: " + treeSet.add("aaa"));
        System.out.println("Add \"bbb\" into treeSet: " + treeSet.add("bbb"));
        System.out.println("Add \"ccc\" into treeSet: " + treeSet.add("ccc"));
        System.out.println("Add \"aaa\" into treeSet: " + treeSet.add("aaa"));
        System.out.println();

        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        hashSet.addAll(listToAdd);
        linkedHashSet.addAll(listToAdd);
        treeSet.addAll(listToAdd);


        // TODO Exercise #3 c) Print the content of the Sets
        System.out.println("hashset:      \t" + hashSet);
        System.out.println("linkedHashSet:\t" + linkedHashSet);
        System.out.println("treeSet:      \t" + treeSet);

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?
        treeSet.addAll(treeSet);
    }
}
