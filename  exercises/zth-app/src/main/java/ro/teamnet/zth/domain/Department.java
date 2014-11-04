package ro.teamnet.zth.domain;

/**
 * Created by user on 11/3/2014.
 */
public class Department {

    private Long Id;
    private String departmentName;

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
