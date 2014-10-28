package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

/**
 * Created by Juvie on 28.10.2014.
 */

@Table(name = "EMPLOYEE")
public class Employee {
    @Column(col = "NAME")
    public String name;
    @Column(col = "SALARY")
    public float salary;

}
