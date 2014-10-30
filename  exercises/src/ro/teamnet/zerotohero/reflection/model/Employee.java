package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

@Table(name="Employee")
public class Employee {

    @Column(col="Nume")
    public String nume;
    @Column(col="Job")
    public String job;

}
