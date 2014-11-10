package ro.teamnet.zth.views;

/**
 * Created by George on 11/11/2014.
 */
public class EmployeeView {

    private Long id;
    private String firstName;
    private String departmentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeView{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
