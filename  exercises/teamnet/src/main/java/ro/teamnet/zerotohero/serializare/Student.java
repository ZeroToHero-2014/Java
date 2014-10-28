package ro.teamnet.zerotohero.serializare;

import java.io.Serializable;

/**
 * Created by Buli on 28.10.2014.
 */
public class Student implements Serializable{

    int id;
    String firstName;
    String lastName;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Student id " + id + ", First name " + firstName + ", Last name " + lastName;
    }
}
