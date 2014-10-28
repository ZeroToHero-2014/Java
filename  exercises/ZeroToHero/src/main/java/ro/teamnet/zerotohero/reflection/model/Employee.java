package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

/**
 * Created by user on 10/28/2014.
 */
@Table(tabel="EMP")
public class Employee {
    @Column(coloana="NAME")
    public String name;

    @Column(coloana="JOB")
    public String job;
}
