package ro.teamnet.zerotohero.reflection.model;
import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

@Table(name="Employee")
public class Employee {
    @Column(coloana="Nume")
    public String nume;
}
