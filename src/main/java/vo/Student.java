package vo;

import java.io.Serializable;

public class Student implements Serializable {

    private static int studentCount=0;

    private int studentId;
    private String studentName;
    private int course;

    public Student(int id, String name, int course){
        studentId=id;
        studentName=name;
        this.course=course;
        studentCount++;
    }

    public Student(String name, int course){
        studentId=++studentCount;
        studentName=name;
        this.course=course;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }


    public String toString(){
        return studentId+". " +studentName + " - "+course;
    }
}
