package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.MyAnnotation;
import ro.teamnet.zerotohero.reflection.api.Table;

/**
 * Created by user on 10/27/2014.
 */

@Table(name = "Angajati")
public class Employ {

    @Column(name = "Name")
    String name;

    public Employ(String name, String job) {
        this.name = name;


        this.job = job;

    }

    public Employ(){ }
    @Column(name = "Job")
    String job;


}
