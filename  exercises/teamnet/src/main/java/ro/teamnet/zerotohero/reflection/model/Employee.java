package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

/**
 * Created by Buli on 28.10.2014.
 */

@Table(tableName = "EMP")
public class Employee {

    @Column(columnName = "NAME")
    public String name;

    @Column(columnName = "JOB")
    public String job;

}
