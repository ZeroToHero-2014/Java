package exercise2;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 10/30/2014.
 *
 * Exercise 2: Overriding equals() and hashCode() methods.
 *              Create a Set and a Map and add some elements to them before and after overriding equals() and hashCode()
 *              For this exercise you need to follow in order all the TODO steps.
 */
public class Exercise2 {
    private List<Student> studentList;
    private List<Long> cnps;

    public Exercise2(List<Student> studentList, List<Long> cnps){
        this.studentList = studentList;
        this.cnps = cnps;
    }

    public void addStudents(){

        System.out.println("The list of students is: " + studentList);

        // TODO Exercise 2 a) Make a new Set, add the elements from the studentList into it
        // TODO and print them (hint: notice the duplicate elements)
        // TODO (hint: in order to print the elements of Student class in a human readable way you should override
        // TODO the toString() method from Student class
        Set<Student> sS = new HashSet<Student>();
        sS.addAll(studentList);

        System.out.println(sS.toString());

        // TODO Exercise 2 b) Remove all elements from the Set using clear() method and go to TODO Exercise 2 c) from Student class

        // TODO Exercise 2 e) Add the elements from studentList into the Set after you finished the TODO Exercise 2 c)
        // TODO from Student class. What do you notice?

        // TODO Exercise 2 f) Remove all elements from the Set using clear() method and go to TODO Exercise 2 g) from Student class

        // TODO Exercise 2 i) Add the elements from studentList into the Set after you finished the TODO Exercise 2 g)
        // TODO from Student class. What do you notice this time?

        // TODO Exercise 2 j) Create a new Map<Student, Long> so that it holds in the key all the Students from the
        // TODO (Important !) Set you have just already created, and in the keys' value, the CNP of the Student found in cnps List
        // TODO (suggestion: after you implement this, you could comment, firstly, the equals() method from Student class
        // TODO and then the hashCode() method in order to see some differences).

    }
}
