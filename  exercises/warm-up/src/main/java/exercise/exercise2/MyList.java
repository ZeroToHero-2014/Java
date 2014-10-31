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

    // A counter to hold the number of adds that were made on the list
    private int differentElements;

    @Override
    public boolean addAll(Collection c) {
        for(Object o : c )
        {
            if (!this.contains(o)) differentElements++;
        }
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        for(Object o : c )
        {
            if (!this.contains(o)) differentElements++;
        }
        return super.addAll(index, c);

}

    @Override
    public boolean remove(Object o) {
        boolean x = super.remove(o);

        if (!this.contains(o))  {differentElements--; return x;}
                else return x;

    }

    @Override
    public Integer remove(int index) {
        int elm=super.remove(index);
        if (this.contains(elm))  return elm;
            else  { differentElements--; return elm;}

    }

    @Override
    public boolean add(Integer integer) {

        if(!this.contains(integer)) differentElements++;

        return super.add(integer);
    }

    @Override
    public void add(int index, Integer element) {

        if(!this.contains(element)) differentElements++;
        super.add(index, element);
    }

    @Override
    public void clear() {
        super.clear();
    }

    public MyList(){
		super();
        differentElements = 0;
    }

    public int getDifferentElements() {
        return differentElements;
    }


    // TODO Exercise #2 a) Override add() and addAll() methods so that the list should retain the number of
    // TODO Exercise #2 a) different elements

    // TODO Exercise #2 b) Override the remove methods so that the number of different elements is updated when
    // TODO Exercise #2 b) an element is removed
    // TODO Exercise #2 b) hint: you need to update the number of different elements only when
    // TODO Exercise #2 b) the element that needs to be removed is the last element of its kind in the list

    // TODO Exercise #2 c) Override the clear method (hint: don't forget to reset the number of different elements)

    // TODO Exercise #2 d) Generate a getter method in order to get the counter value

    // TODO Exercise #2 e) Uncomment all the lines from Exercise2Test.java in order to test your implementation
}
