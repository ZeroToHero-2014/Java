package ro.teamnet.zth.domain;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class Department {

    private Long id;
    private String departmentName;

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
