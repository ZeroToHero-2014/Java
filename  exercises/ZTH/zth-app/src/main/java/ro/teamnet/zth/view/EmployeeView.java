package ro.teamnet.zth.view;

import ro.teamnet.zth.domain.Department;
import ro.teamnet.zth.domain.Employee;
import ro.teamnet.zth.domain.Job;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ovy on 11/5/2014.
 */
public class EmployeeView {
    private Long id;
    private String firstName;
    private String lastName;
    private ArrayList<Employee> manager;
    private String email;
    private Date hireDate;
    private Double salary;
    private Double comissionPoints;
    private String phoneNumber;
    private ArrayList<Job> job;
    private ArrayList<Department> department;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Employee> getManager() {
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

    public ArrayList<Job> getJob() {
        return job;
    }

    public ArrayList<Department> getDepartment() {
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

    public void setManager(ArrayList<Employee> manager) {
        this.manager = manager;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setComissionPoints(Double comissionPoints) {
        this.comissionPoints = comissionPoints;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setJob(ArrayList<Job> job) {
        this.job = job;
    }

    public void setDepartment(ArrayList<Department> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeView{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", manager=" + manager +
                ", email='" + email + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", comissionPoints=" + comissionPoints +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", job=" + job +
                ", department=" + department +
                '}';
    }
}