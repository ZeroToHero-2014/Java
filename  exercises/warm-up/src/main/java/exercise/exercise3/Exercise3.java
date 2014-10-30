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

        HashSet<String> hashSet = new HashSet<String>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        TreeSet<String> treeSet = new TreeSet<String>();

        System.out.println("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Print the content of the elements you will add into the Set
        ListIterator<String> it = listToAdd.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        hashSet.addAll(listToAdd);
        linkedHashSet.addAll(listToAdd);
        treeSet.addAll(listToAdd);

        // TODO Exercise #3 c) Print the content of the Sets
        System.out.println("HashSet: " + hashSet.toString());
        System.out.println("LinkedHashSet" + linkedHashSet.toString());
        System.out.println("TreeHashSet" + treeSet.toString());

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        treeSet.add("no");
        treeSet.add("that");
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?
        System.out.println("TreeHashSet" + treeSet.toString());
    }
}
