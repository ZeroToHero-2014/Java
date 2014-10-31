import exercise2.Exercise2;
import exercise2.Student;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by radu992 on 31.10.2014.
 */
public class Exercise2Test {
    private Student[] students = {new Student("Popescu", "Mihai", 8.66),
                                    new Student("Ionescu", "Ion", 7.92),
                                    new Student("Popa", "Cristina", 9.34),
                                    new Student("Barbu", "Mihai", 5.01),
                                    new Student("Popescu", "Mihai", 8.66),
                                    new Student("Serban", "Alin", 9.66),
                                    new Student("Georgescu", "Andreea", 5.01),
                                    new Student("Popa", "Cristina", 9.34),
                                    new Student("Popescu", "Mihai", 8.66),};

    private Long[] cnps = {1851021345131L,
                            1920617149053L,
                            1870505168646L,
                            1870619152998L,
                            1921204325416L,
                            1931011351347L};

    private List<Student> studentList;
    private List<Long> cnpsList;
    @Before
    public void setUp() throws Exception {
        studentList = new ArrayList<Student>(Arrays.asList(students));
        cnpsList = new ArrayList<Long>(Arrays.asList(cnps));

    }

    @Test
    public void testEqualsMethod() throws Exception {
        Student student1 = studentList.get(0); // Mihai Popescu
        Student student2 = studentList.get(4); // Mihai Popescu
        Student student3 = studentList.get(8); // Mihai Popescu
        Assert.assertEquals("Test equals method from student", true, student1.equals(student2));

        Assert.assertEquals("Test reflexitivity on equals method", true, student1.equals(student1));

        Assert.assertEquals("Test symmetry on equals method", student2.equals(student1), student1.equals(student2));

        Assert.assertEquals("Test transitivity on equals method", student1.equals(student3), student1.equals(student2)
                && student2.equals(student3));

        Assert.assertEquals("Test null on equals method", false, student1.equals(null));
        new Exercise2(studentList, cnpsList).addStudents();
    }

    @Test
    public void testHashCodeMethod() throws Exception {
        Student student1 = studentList.get(0); // Mihai Popescu
        Student student2 = studentList.get(4); // Mihai Popescu
        Student student3 = studentList.get(1);
        Student student4 = new Student("Mihai", "Popescu", 8.98); // Mihai Popescu with other averageGrade

        Assert.assertEquals("Test equal elements to have the same hashCode", student1.hashCode(), student2.hashCode());

        Assert.assertNotSame("Test different elements to have different hashCode", student1.hashCode(), student3.hashCode());

        Assert.assertNotSame("Test different elements that differ by one field to have different hashCode", student1.hashCode(),
                student4.hashCode());
    }
}
