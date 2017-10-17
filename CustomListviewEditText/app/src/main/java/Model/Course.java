package Model;

import java.io.Serializable;

/**
 * Created by shafi on 8/27/2017.
 */

public class Course implements Serializable{

    String courseId;
    int credit;
    double grade;

    public Course(){

    }

    public Course(int course_id){
        this.courseId = "Course " + course_id;
    }

    public Course (String courseId, int credit, double grade){
        this.courseId = courseId;
        this.credit = credit;
        this.grade = grade;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
