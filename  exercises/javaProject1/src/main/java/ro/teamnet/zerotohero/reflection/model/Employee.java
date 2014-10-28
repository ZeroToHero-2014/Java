package ro.teamnet.zerotohero.reflection.model;


import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

@Table(someValue = "EMP")
public class Employee {

    @Column(someValue = "Name")
    public String name;
    @Column(someValue = "Job")
    public String job;
}





