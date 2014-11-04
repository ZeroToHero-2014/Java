package ro.teamnet.zth.domain;

import java.util.Locale;

/**
 * Created by ovy on 11/4/2014.
 */
public class Department {
    private Long id;
    private String department;

    public Long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
