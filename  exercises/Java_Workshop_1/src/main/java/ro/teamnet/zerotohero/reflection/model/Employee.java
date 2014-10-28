package ro.teamnet.zerotohero.reflection.model;
import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

@Table(someValue="EMP")
public class Employee {

    @Column(anotherValue="Name")
    public String name;


    @Column(anotherValue="Job")
    public String job;



}
