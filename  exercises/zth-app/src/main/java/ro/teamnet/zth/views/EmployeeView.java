package ro.teamnet.zth.views;

import ro.teamnet.zth.domain.Department;

/**
 * Created by Buli on 11/9/2014.
 */
public class EmployeeView {

    private Long employeeId;
    private String firstName;
    private String departmentName;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
}
