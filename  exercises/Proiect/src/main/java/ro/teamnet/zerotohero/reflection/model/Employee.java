package ro.teamnet.zerotohero.reflection.model;

import ro.teamnet.zerotohero.reflection.api.Column;
import ro.teamnet.zerotohero.reflection.api.Table;

/**
 * Created by ovy on 10/28/2014.
 */
@Table( nume = "Tabel")
public class Employee {
    @Column(nume="Alex")
   public String nume;
    @Column(job ="spalator")
   public  String job;


}
