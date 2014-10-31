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
    Set<String> st= new HashSet<String>();
    Set<String> st1 = new LinkedHashSet<String>();
    Set<String> st2= new TreeSet<String>();
    public Exercise3(List l) {
        listToAdd = l;

        st.addAll(listToAdd);

        st1.addAll(listToAdd);

        st2.addAll(listToAdd);
    }

    public void addElementsToSets(){

        System.out.println("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Check the content of the elements you will add into the Set
        System.out.println(st);
        System.out.println(st1);
        System.out.println(st2);
        // TODO Exercise #3 b) add the elements from listToAdd to the Sets

        // TODO Exercise #3 c) Check the content of the Sets

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?
    }

    public static void main(String[] args) {
        List<String> li= new ArrayList<String>();
        li.add("mare arar nebuni msds fds");
        li.add("mare gfdgfdgdfarar nefgfdbuni gfdgmsds fds");
        li.add("mare ararfgfdgfdg nebuni msds fds");
        Exercise3 exe = new Exercise3(li);
        exe.addElementsToSets();


    }
}
