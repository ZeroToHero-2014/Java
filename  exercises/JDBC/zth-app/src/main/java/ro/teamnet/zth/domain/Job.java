package ro.teamnet.zth.domain;

/**
<<<<<<< HEAD
 * Created by Dumitru on 04.11.2014.
 */
public class Job {

=======
 * Created by liviu.spiroiu on 11/3/14.
 */
public class Job {
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
    private String id;
    private String jobTitle;
    private Double minSalary;
    private Double maxSalary;

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
<<<<<<< HEAD

    public String toString() {
        return this.getId() + " " +
                this.getJobTitle() + " " +
                this.getMinSalary() + " " +
                this.getMaxSalary();
    }
=======
>>>>>>> 2aa8ea60933430da1b502e540467678c2594e6ba
}
