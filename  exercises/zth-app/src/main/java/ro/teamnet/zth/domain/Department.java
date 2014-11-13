package ro.teamnet.zth.domain;


public class Department {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    private Long id;
    private String departmentName;

    @Override
    public String toString(){

        return "[id: " + id + ", department_name: " + departmentName + "]\n";
    }
}
