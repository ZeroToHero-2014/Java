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
    private HashSet<String> hashSet = new HashSet<>();
    private LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
    private TreeSet<String> treeSet = new TreeSet<>();

    public Exercise3(List l) {
        listToAdd = l;
    }

    public void addElementsToSets(){
        // hint: you should create an instance for every type of discussed Set implementation

        System.out.println("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Print the content of the elements you will add into the Set
        ListIterator<String> it = listToAdd.listIterator();
        System.out.println("Afisara elemente lista: ");
        while(it.hasNext())
        {
            System.out.print(it.next()+ " ");
        }

        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
            hashSet.addAll(listToAdd);
            linkedHashSet.addAll(listToAdd);
            treeSet.addAll(listToAdd);
        // TODO Exercise #3 c) Print the content of the Sets

        System.out.println("\n HashSet: ");
        System.out.println(hashSet);

        System.out.println("\n LinkedHashSet: ");
        for(String elem : linkedHashSet)
        {
            System.out.print(elem + " "); }

        System.out.println("\n \n TreeSet");
        System.out.println(treeSet);

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        treeSet.add(listToAdd.get(0));
        treeSet.add(listToAdd.get(0));
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?

        System.out.println("\n TreeSet");
        System.out.println(treeSet);
    }

    public static void main(String[] args) {
        new Exercise3(Arrays.asList(new String[]{"Gelu","Marian","Andrei","Gigi","Ion","Andrei","Gigi" })).addElementsToSets();
    /*Obeservam ca elementele duplicate nu sunt adaugate in set
    * Observam ca elementele  in LinkedList sunt in aceasi ordine ca in lista lista, la hashset ordinea e data de functia de hash
    * si la TreeSet sunt sortate (alfabetic)  [atat pe main cat pe si test]
    *
    * */}
}
