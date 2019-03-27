package dao.impl;

import dao.DAO;
import vo.Discipline;
import vo.Enrollment;
import vo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends DAO<Student> {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/University";
    private static final String user = "root";
    private static final String password = "root";


    // JDBC variables for opening and managing connection
    private static Connection con;

    public StudentDaoImpl(){
        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insert(Student adr) {

    }

    public Student getById(int id) {
        return null;
    }

    public void update(Student adr) {

    }

    public void delete(Student adr) {

    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<Student>();
        try {
            PreparedStatement prep = con.prepareStatement("SELECT * FROM student");
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                students.add(new Student(res.getInt(1), res.getString(2), res.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    public List<Enrollment> getDiscByStudent(Student student){
       List<Enrollment> enroll = new ArrayList<Enrollment>();

        try {
            PreparedStatement prep = con.prepareStatement("SELECT ENROLLMENT.id, DISCIPLINE.id, DISCIPLINE.name, credits, STUDENT.id, STUDENT.fio, course, grade\n" +
                    "FROM (STUDENT INNER JOIN ENROLLMENT on STUDENT.id = student_id)\n" +
                    "  INNER JOIN DISCIPLINE ON discipline_id = DISCIPLINE.id\n" +
                    "WHERE student_id=? AND fio=?;");

            prep.setInt(1, student.getStudentId());
            prep.setString(1, student.getStudentName());

            ResultSet res = prep.executeQuery();
            while (res.next()) {
                enroll.add(new Enrollment(res.getInt(1),
                        new Student(res.getInt(5), res.getString(6), res.getInt(7)),
                        new Discipline(res.getInt(2), res.getString(3), res.getFloat(4)),
                         res.getInt(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enroll;
    }


    public List<Discipline> getDiscByStudentId(){
        return null;
    }

    public void close() {

        try {
            con.commit();
            con.close();
        } catch (SQLException se) {
            System.out.println("Some troubles with close connection");
        }
    }
}
