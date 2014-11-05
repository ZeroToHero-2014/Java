package ro.teamnet.zth.domain;

/**
 * Created by ovy on 11/4/2014.
 */
public class Job {
    private String id;
    private String title;
    private Double max_salary;
    private  Double min_salary;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getMax_salary() {
        return max_salary;
    }

    public Double getMin_salary() {
        return min_salary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMax_salary(Double max_salary) {
        this.max_salary = max_salary;
    }

    public void setMin_salary(Double min_salary) {
        this.min_salary = min_salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", max_salary=" + max_salary +
                ", min_salary=" + min_salary +
                '}';
    }
}
