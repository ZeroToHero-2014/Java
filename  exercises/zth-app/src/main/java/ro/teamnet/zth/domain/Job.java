package ro.teamnet.zth.domain;

/**
 * Created by Bogdan on 11/4/2014.
 */
public class Job
{
    private String id;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String toString()
    {
        return "id: " + id + ", job_title: " + jobTitle + ", min_salary: " + minSalary + ", max_salary: " +maxSalary + "\n" ;
    }
}
