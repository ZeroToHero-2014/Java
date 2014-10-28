package ro.teamnet.zerotohero.reflection.api.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

import java.util.Date;

/**
 * Created by Dumitru on 28.10.2014.
 */
@Table(name = "EMP")
public class Employee {
    @Column(fname = "FirstName")
    String fName;
    @Column(lname = "LastName")
    String lName;
    @Column(job = "Job")
    String job;
    @Column(dept = "department")
    String department;
}
