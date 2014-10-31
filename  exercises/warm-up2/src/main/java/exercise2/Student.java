package exercise2;

/**
 * Created by Radu.Hoaghe on 31.10.2014.
 */
public class Student {
    private final String firstName;
    private final String lastName;
    private final Double averageGrade;

    public Student(String firstName, String lastName, Double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageGrade = averageGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    // TODO Exercise 2 c) Override the equals() method
    @Override
    public boolean equals(Object o) {
        // TODO Exercise 2 c1) Check if the current instance is the same instance as the one from Object o
            if(!(o instanceof Student)) return false;
        // TODO Exercise 2 c2) Check if Object o is null
            if(o == null) return false;
        // TODO Exercise 2 c3) Cast the object into a Student variable
            Student student = (Student)o;
        // TODO Exercise 2 c3) Check if all the fields from Student class are equal to the ones from
            if(!student.firstName.equals(this.firstName))return  false;
            if(!student.lastName.equals(this.lastName))return  false;
            if(!student.averageGrade.equals(this.averageGrade))return false;
        // TODO Exercise 2 c3) the variable that you casted earlier (lastName, firstName, averageGrade)

        return true;
        // TODO Exercise 2 d) After you finished implementing equals method go to TODO Exercise 2 e) from Exercise2 class
    }

    // TODO Exercise 2 g) Override the hashCode() method
    // TODO Exercise 2 g) Hint: Don't forget to include in the hashCode result all the fields from
    // TODO Exercise 2 g) the Student class
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31*hash + this.firstName.hashCode();
        hash = 31*hash + this.lastName.hashCode();
        hash = 31*hash + (int)(Double.valueOf(averageGrade).hashCode());

        return hash;
        // TODO Exercise 2 h) After you finished implementing hashCode go to TODO Exercise 2 i) from Exercise2 class
    }

    // TODO You should override the toString() method in order to print the Student class' elements
    @Override
    public String toString() {
        return firstName + ' ' + lastName +':' + averageGrade;
    }
}
