package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

/**
 * Created by Miha on 10/28/2014.
 */
@Table(tableName = "Employees")
public class Employee {
    @Column(columnName = "Varsta")
    public int varsta;
    @Column(columnName = "Job_Name")
    public String job;
}
