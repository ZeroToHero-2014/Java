package ro.teamnet.zerotohero.model;

import ro.teamnet.zerotohero.api.Column;
import ro.teamnet.zerotohero.api.Table;

/**
 * Created by Bogdan on 10/28/2014.
 */
@Table(tableName = "Employees")
public class Employee
{
    @Column(columnName="NAME" )
    public String name = "ion";

    @Column(columnName ="JOB_AA" )
    public String job = "ion";
}
