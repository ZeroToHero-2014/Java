package ro.teamnet.zth.views;


import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeView {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date hireDate;
    private Double salary;
    private Double commissionPoints;
    private String phoneNumber;
    private ArrayList<Job> jobs;
    private ArrayList<Employee> managers;
    private ArrayList<Department> departments;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Double getCommissionPoints() {
        return commissionPoints;
    }

    public void setCommissionPoints(Double commissionPoints) {
        this.commissionPoints = commissionPoints;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public ArrayList<Employee> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<Employee> managers) {
        this.managers = managers;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }


}
