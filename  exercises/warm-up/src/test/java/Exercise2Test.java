import exercise.exercise2.MyList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
* Created by Radu.Hoaghe on 10/29/2014.
*/
public class Exercise2Test {
    private MyList listToTest;
    private int addExpectedTest1, addExpectedTest2;
    private int insertExpectedTest1;
    private int removeExpectedTest1, removeExpectedTest2;
    private int addAllExpectedTest1, addAllExpectedTest2;
    private Integer[] v = new Integer[5];

    @Before
    public void setUp() throws Exception {
        listToTest = new MyList();
        addExpectedTest1 = 10;
        addExpectedTest2 = 11;
        insertExpectedTest1 = 13;
        addAllExpectedTest1 = 10;
        addAllExpectedTest2 = 13;
        removeExpectedTest1 = 8;
        removeExpectedTest2 = 8;
    }

    @Test
    public void testAdd() throws Exception {
        listToTest.clear();
        Assert.assertEquals("Test clear method", 0, listToTest.getDifferentElements());

        for(int i = 0; i < 10; i++)
            listToTest.add(i);

        Assert.assertEquals("Test add method with all different elements", addExpectedTest1, listToTest.getDifferentElements());

        listToTest.add(5);
        listToTest.add(3);
        listToTest.add(11);
        listToTest.add(8);

        Assert.assertEquals("Test add method with some equal elements", addExpectedTest2, listToTest.getDifferentElements());
    }

    @Test
    public void testAddAtIndex() throws Exception {
        listToTest.clear();
        Assert.assertEquals("Test clear method", 0, listToTest.getDifferentElements());


        for(int i = 0; i < 10; i++)
            listToTest.add(i);

        listToTest.add(8, 11);
        listToTest.add(5, 12);
        listToTest.add(3, 13);

        Assert.assertEquals("Test insert different elements", insertExpectedTest1, listToTest.getDifferentElements());

        listToTest.add(7, 8);
        listToTest.add(4, 4);
        listToTest.add(5, 12);

        Assert.assertEquals("Test insert equal elements", insertExpectedTest1, listToTest.getDifferentElements());

    }

    @Test
    public void testAddAll() throws Exception {
        listToTest.clear();
        Assert.assertEquals("Test clear method", 0, listToTest.getDifferentElements());

        for(int i = 0; i < 10; i++)
            listToTest.add(i);

        for(int i = 0; i < 5; i++)
            v[i] = i;

        listToTest.addAll(Arrays.asList(v));
        Assert.assertEquals("Test addAll with all equal elements", addAllExpectedTest1, listToTest.getDifferentElements());

        for(int i = 0; i < 5; i++)
            v[i] = 5 * i;

        listToTest.addAll(Arrays.asList(v));
        Assert.assertEquals("Test addAll with all some different elements", addAllExpectedTest2, listToTest.getDifferentElements());

    }

    @Test
    public void testAddAllAtIndex() throws Exception {
        listToTest.clear();
        Assert.assertEquals("Test clear method", 0, listToTest.getDifferentElements());

        for(int i = 0; i < 10; i++)
            listToTest.add(i);

        for(int i = 0; i < 5; i++)
            v[i] = i;

        listToTest.addAll(5, Arrays.asList(v));
        Assert.assertEquals("Test addAll with all equal elements", addAllExpectedTest1, listToTest.getDifferentElements());

        for(int i = 0; i < 5; i++)
            v[i] = 5 * i;

        listToTest.addAll(10, Arrays.asList(v));
        Assert.assertEquals("Test addAll with some different elements", addAllExpectedTest2, listToTest.getDifferentElements());

    }

    @Test
    public void testRemove() throws Exception {
        listToTest.clear();
        Assert.assertEquals("Test clear method", 0, listToTest.getDifferentElements());

        for(int i = 0; i < 10; i++)
            listToTest.add(i);

        listToTest.remove(5);
        listToTest.remove(3);

        Assert.assertEquals("Test remove elements with 1 occurence", removeExpectedTest1, listToTest.getDifferentElements());

        listToTest.add(7);
        listToTest.add(7);
        listToTest.remove(5);

        Assert.assertEquals("Test remove element with 3 occurences", removeExpectedTest2, listToTest.getDifferentElements());

    }

    @Test
    public void testRemoveObject() throws Exception {
        listToTest.clear();
        Assert.assertEquals("Test clear method", 0, listToTest.getDifferentElements());

        for(int i = 0; i < 10; i++)
            listToTest.add(i);

        listToTest.remove((Integer) 5);
        listToTest.remove((Integer) 3);

        Assert.assertEquals("Test remove elements with 1 occurence", removeExpectedTest1, listToTest.getDifferentElements());

        listToTest.add(7);
        listToTest.add(7);
        listToTest.remove((Integer) 7);

        Assert.assertEquals("Test remove element with 3 occurences", removeExpectedTest2, listToTest.getDifferentElements());

    }
}
