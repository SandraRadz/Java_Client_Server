package vo;

import java.io.Serializable;

public class Enrollment implements Serializable {
    private static int enrollCount=0;
    private int enrollId;
    private Student student;
    private Discipline disc;
    private int grade;


    public Enrollment(int id, Student student, Discipline disc, int grade){
        enrollId=id;
        this.student=student;
        this.disc=disc;
        this.grade=grade;
        enrollCount++;
    }


    public Enrollment(Student student, Discipline disc, int grade){
        enrollId=++enrollCount;
        this.student=student;
        this.disc=disc;
        this.grade=grade;
    }

    public static int getEnrollCount() {
        return enrollCount;
    }

    public static void setEnrollCount(int enrollCount) {
        Enrollment.enrollCount = enrollCount;
    }

    public int getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Discipline getDisc() {
        return disc;
    }

    public void setDisc(Discipline disc) {
        this.disc = disc;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString(){
        return enrollId+". /"+student.toString() +"/  /"+disc.toString()+"/ MARK = "+grade;
    }
}
