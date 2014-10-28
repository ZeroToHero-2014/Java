package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

/**
 * Created by George on 10/28/2014.
 */

@Table(nameTable = "EMP")
public class Employee {
    @Column(nameColumn = "NAME")
    public String name;

    @Column(nameColumn = "JOB")
    public String job;
}
