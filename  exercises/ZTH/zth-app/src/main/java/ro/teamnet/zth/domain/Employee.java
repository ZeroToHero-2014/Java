package ro.teamnet.zth.domain;

import java.util.Date;

/**
 * Created by ovy on 11/4/2014.
 */
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private Employee manager;
    private String email;
    private Date hireDate;
    private Double salary;
    private Double comissionPoints;
    private String phoneNumber;
    private Job job;
    private  Department department;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee getManager() {
        return manager;
    }

    public String getEmail() {
        return email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getComissionPoints() {
        return comissionPoints;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Job getJob() {
        return job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setComissionPoints(Double comissionPoints) {
        this.comissionPoints = comissionPoints;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
