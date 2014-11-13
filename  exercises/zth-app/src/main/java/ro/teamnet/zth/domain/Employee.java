package ro.teamnet.zth.domain;


import java.util.Date;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private Employee manager;
    private String email;
    private Date hireDate;
    private Double salary;
    private Double commissionPoints;
    private String phoneNumber;
    private Job job;
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getCommissionPoints() {
        return commissionPoints;
    }

    public void setCommissionPoints(Double commissionPoints) {
        this.commissionPoints = commissionPoints;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {

        return "(id: " + id + ",firstName: " + firstName + ",lastName: " + lastName + ",email: " + email
                + ",hireDate: " + hireDate+ ",salary: " + salary + ",phoneNumber: " + phoneNumber
                + ",commissionPoints: " + commissionPoints+ ",manager: " + manager + ",job: " + job.toString()
                +",department: " + department + ")\n";

    }
}
