package ro.teamnet.zth.domain;

/**
 * Created by Bogdan on 11/4/2014.
 */
public class Department
{
    private String id;
    private String departmentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String toString()
    {
        return "id: " + id + ", name: " +departmentName +"\n";
    }
}
