package ro.teamnet.zth.domain;

/**
 * Created by user on 11/3/2014.
 */
public class Department {

    private Long Id;
    private String departmentName;
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Department{" +
                "Id=" + Id +
                ", departmentName='" + departmentName + '\'' +
                ", location=" + location +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
