package ro.teamnet.zth.domain;

import java.util.Locale;

/**
 * Created by ovy on 11/4/2014.
 */
public class Department {
    private Long id;
    private String department;
    private Location location;

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", location=" + location +
                '}';
    }
}
