package exercise.exercise2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Radu.Hoaghe on 28.10.2014.
 *
 * Exercise 2: Create a class that inherits ArrayList<Integer> (class MyList<Integer>).
 *
 *             This list (MyList) should have the following functionality, besides the functionality
 *             that ArrayList already offers: it should retain in every moment how many different
 *             elements exist in the list.
 *                  
 *                  Examples: 1. If you have a List that contains: 7 5 3 2 4 1, there are 6 different elements.
 *                            2. If you have a List that contains: 5 6 1 2 5 6, there are 4 different elements.
 *
 *             A variable that retains the number of different elements that exist in the list in
 *             every moment was already defined (differentElements).
 *
 *             First of all, you will need to override the add methods so that every time a different
 *             element is added the counter will be updated.
 *                      Hint : check out the List documentation to see the methods signatures.
 *
 *             Secondly, you will also need to override the remove methods (Hint: Of course the List
 *             documentation) because the number of different elements in the list could change if
 *             the last element of its kind in the list is removed and by not overrriding it the
 *             counter will remain unchanged.
 *
 *             Finally, you will need to override the clear method and create a getter method for the
 *             counter (in order to access it outside the class).
 *
 *             In order to add/remove/clear the elements into/from the list you will need to use the
 *             add/remove/clear methods inherited from ArrayList.
 *
 *             To test your implementation run the Exercise2Test class.
 *
 */
public class MyList extends ArrayList<Integer> {

    public int getDifferentElements() {
        return differentElements;
    }

    // A counter to hold the number of adds that were made on the list
    private int differentElements;

    public MyList(){

        super();
        differentElements = 0;
    }

    // TODO Exercise #2 a) Override add() and addAll() methods so that the list should retain the number of


    public boolean add(Integer element) {
        if(!this.contains((Integer)element))
            differentElements++;
        return super.add((Integer)element);
    }

    @Override
    public void add(int index, Integer e) {

        if(!this.contains((Integer)e))
            differentElements++;
        super.add(index, (Integer)e);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {

        for(Integer element: c) {
            this.add(index, element);
            index++;
        }

        return true;
    }
    @Override
    public boolean addAll(Collection<? extends Integer> c) {

        for(Integer element: c) {
            if(!this.add(element))
                return false;
        }
       return true;
    }
    // TODO Exercise #2 a) different elements

    // TODO Exercise #2 b) Override the remove methods so that the number of different elements is updated when

    @Override
    public boolean remove(Object o) {

        boolean res = super.remove(o);
        if (res && !this.contains((Integer)o))
            differentElements--;
        return res;
    }

    @Override
    public Integer remove(int index) {


        Integer res = super.remove(index);
        if (!this.contains(res))
            differentElements--;
        return res;
    }

    @Override
    public void clear() {
        super.clear();
        differentElements = 0;
    }


    // TODO Exercise #2 b) an element is removed
    // TODO Exercise #2 b) hint: you need to update the number of different elements only when
    // TODO Exercise #2 b) the element that needs to be removed is the last element of its kind in the list

    // TODO Exercise #2 c) Override the clear method and reset the number of different elements

    // TODO Exercise #2 d) Generate a getter method in order to get the counter value
}
