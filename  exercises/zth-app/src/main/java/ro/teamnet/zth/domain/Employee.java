package ro.teamnet.zth.domain;

import java.util.Date;

/**
 * Created by Buli on 04.11.2014.
 */
public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private Employee manager;
    private String email;
    private Date hireDate;
    private Double salary;
    private Double commisionPoints;
    private String phoneNmber;
    private Job job;
    private Department department;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommisionPoints() {
        return commisionPoints;
    }

    public void setCommisionPoints(Double commisionPoints) {
        this.commisionPoints = commisionPoints;
    }

    public String getPhoneNmber() {
        return phoneNmber;
    }

    public void setPhoneNmber(String phoneNmber) {
        this.phoneNmber = phoneNmber;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
