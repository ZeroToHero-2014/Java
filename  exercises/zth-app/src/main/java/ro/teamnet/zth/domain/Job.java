package ro.teamnet.zth.domain;


public class Job {

    private String id;
    private String jobTitle;

    public Job(){}
    public Job(String id, String jobTitle, Double minSalary, Double maxSalary) {
        this.id = new String(id);
        this.jobTitle = new String(jobTitle);
        this.minSalary = new Double(minSalary);
        this.maxSalary = new Double(maxSalary);
    }
    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Double minSalary;
    private Double maxSalary;

    public String toString() {
        return "(job_id: " + id + ", job_name: " + jobTitle + ", minSalary: " + minSalary + ", maxSalary: " + maxSalary + ")";
    }
}
